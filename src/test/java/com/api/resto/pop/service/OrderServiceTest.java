package com.api.resto.pop.service;

import com.api.resto.pop.dto.OrderRequestDto;
import com.api.resto.pop.dto.OrderResponseDto;
import com.api.resto.pop.dto.TableResponseDto;
import com.api.resto.pop.entity.OrderFood;
import com.api.resto.pop.exception.IdNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    OrderResponseDto orderResponseDto;

    @Before
    public void preDefine(){

        orderResponseDto = new OrderResponseDto();
        orderResponseDto.setQuantityMenu(1);
        orderResponseDto.setNameMenu("Grilled Atlantic Salmon Steak");
        orderResponseDto.setIdMenu(1);
        orderResponseDto.setIdOrder(1);
        orderResponseDto.setIdTable(1);
        orderResponseDto.setNumberTable(1);
        orderResponseDto.setPriceMenu(BigDecimal.valueOf(98000));
    }

    @Test
    public void findAll() {
        List<OrderFood> orderTest = orderService.findAll();
        assertThat(orderTest.size()).isNotNull();
        for (int i = 0; i < orderTest.size(); i++) {
        }
    }

    @Test
    public void findById() {
        Integer id = 1;
        OrderFood order = orderService.findById(id);

        assertThat(order)
                .hasFieldOrProperty("idOrder")
                .hasFieldOrProperty("idTable")
                .hasFieldOrProperty("numberTable")
                .hasFieldOrProperty("idMenu")
                .hasFieldOrProperty("nameMenu")
                .hasFieldOrProperty("priceMenu")
                .hasFieldOrProperty("quantityMenu");

        Assert.assertEquals(order.getNumberTable(), orderResponseDto.getNumberTable());
        Assert.assertEquals(order.getQuantityMenu(), orderResponseDto.getQuantityMenu());
        Assert.assertEquals(order.getNameMenu(), orderResponseDto.getNameMenu());
        Assert.assertEquals(order.getIdMenu(), orderResponseDto.getIdMenu());
        Assert.assertEquals(order.getIdOrder(), orderResponseDto.getIdOrder());
        Assert.assertEquals(order.getIdTable(), orderResponseDto.getIdTable());
//        Assert.assertEquals(order.getPriceMenu(), orderResponseDto.getPriceMenu());
    }

    @Test
    public void orderFood() {
        OrderRequestDto orderRequestDto = new OrderRequestDto();

        Integer idMenu = 1;
        Integer idTable = 1;
        Integer quantityMenu = 1;

        orderRequestDto.setIdMenu(idMenu);
        orderRequestDto.setIdTable(idTable);
        orderRequestDto.setQuantityMenu(quantityMenu);

        OrderResponseDto orderResponseDto = orderService.orderFood(orderRequestDto);
        assertThat(orderResponseDto.getIdMenu()).isEqualTo(idMenu);
        assertThat(orderResponseDto.getIdTable()).isEqualTo(idTable);
        assertThat(orderResponseDto.getQuantityMenu()).isEqualTo(quantityMenu);
    }


    @Test
    public void cancelOrder() {
        Integer id = 2;
        List<OrderFood> orderFoods = orderService.findAll();
        orderService.cancelOrder(id);

        List<OrderFood> orderServiceAll = orderService.findAll();
        assertThat(orderFoods.size()).isGreaterThan(orderServiceAll.size());
    }

    @Test(expected = IdNotFoundException.class)
    public void failedById() {
        Integer id = 50;
        OrderFood orderFood = orderService.findById(id);
        assertThat(orderFood.getIdOrder()).isNotEqualTo(id);
    }



    @Test(expected = IdNotFoundException.class)
    public void orderFailedByIdMenu() {
        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setIdMenu(20);
        orderRequestDto.setIdTable(1);
        orderRequestDto.setQuantityMenu(1);

        OrderResponseDto orderResponseDto = orderService.orderFood(orderRequestDto);
        assertThat(orderResponseDto.getIdMenu()).isNotEqualTo(20);
        assertThat(orderResponseDto.getIdTable()).isNotEqualTo(1);
        assertThat(orderResponseDto.getQuantityMenu()).isNotEqualTo(1);
    }

}
