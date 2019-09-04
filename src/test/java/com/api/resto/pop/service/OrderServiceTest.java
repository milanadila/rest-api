package com.api.resto.pop.service;

import com.api.resto.pop.dto.OrderRequestDto;
import com.api.resto.pop.dto.OrderResponseDto;
import com.api.resto.pop.entity.OrderFood;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    public void findAll() {
        List<OrderFood> orderResponseDtoTest = orderService.findAll();
        assertThat(orderResponseDtoTest.size()).isNotNull();
        for (int i = 0; i < orderResponseDtoTest.size(); i++) {
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
}
