package com.api.resto.pop.service;

import com.api.resto.pop.dto.OrderRequestDto;
import com.api.resto.pop.dto.OrderResponseDto;
import com.api.resto.pop.entity.Menu;
import com.api.resto.pop.entity.OrderFood;
import com.api.resto.pop.entity.TableOrder;
import com.api.resto.pop.exception.IdNotFoundException;
import com.api.resto.pop.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MenuService menuService;

    @Autowired
    TableService tableService;

    public List<OrderFood> findAll(){
        return orderRepository.findAll();
    }

    public OrderFood findById(Integer id){
        return orderRepository.findById(id).orElseThrow(IdNotFoundException::new);
    }

    private static HashMap<Integer, OrderResponseDto> orders = new HashMap();

    public  HashMap<Integer, OrderResponseDto> getHashMap() {
        return  orders;
    }

    public OrderResponseDto orderFood (OrderRequestDto orderRequestDto) {
        TableOrder table = tableService.findById(orderRequestDto.getIdTable());
        Integer numberTable = table.getNumberTable();

        Menu menu = menuService.findById(orderRequestDto.getIdMenu());
        String nameMenu = menu.getNameMenu();
        BigDecimal priceMenu = menu.getPriceMenu();

        OrderFood orderFood = new OrderFood();

        orderFood.setIdTable(orderRequestDto.getIdTable());
        orderFood.setNumberTable(numberTable);
        orderFood.setIdMenu(orderRequestDto.getIdMenu());
        orderFood.setQuantityMenu(orderRequestDto.getQuantityMenu());
        orderFood.setNameMenu(nameMenu);
        orderFood.setPriceMenu(priceMenu);
        orderRepository.save(orderFood);


        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setIdOrder(orderFood.getIdOrder());
        orderResponseDto.setIdTable(orderFood.getIdTable());
        orderResponseDto.setNumberTable(numberTable);
        orderResponseDto.setIdMenu(orderFood.getIdMenu());
        orderResponseDto.setNameMenu(nameMenu);
        orderResponseDto.setPriceMenu(priceMenu);
        orderResponseDto.setQuantityMenu(orderFood.getQuantityMenu());

        orders.put(orderFood.getIdOrder(), orderResponseDto);
        log.info("Yang ini nih: " + orders.toString());
        return orderResponseDto;
    }

    public Collection<OrderResponseDto> listOrder() {
        return orders.values();
    }

    public OrderFood findByIdOrder(Integer id) {
        return orderRepository.findByIdOrder(id);
    }

    public void cancelOrder(Integer id) {
        orderRepository.findByIdOrder(id);
        orderRepository.deleteById(id);

    }
}
