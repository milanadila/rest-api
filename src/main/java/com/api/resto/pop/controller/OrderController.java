package com.api.resto.pop.controller;

import com.api.resto.pop.dto.OrderRequestDto;
import com.api.resto.pop.service.OrderService;
import com.api.resto.pop.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    ResponseEntity<Response> addOrder(@RequestBody @Valid OrderRequestDto orderRequestDto) {
        Response response = new Response();
        response.setMesssage("OrderFood Success");
        response.setData(orderService.orderFood(orderRequestDto));

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @GetMapping
    ResponseEntity<Response> findAll() {
        Response response = new Response();
        response.setMesssage("Success show all order");
        response.setData(orderService.findAll());

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Response> getById (@PathVariable ("id") Integer id) {
        Response response = new Response();
        response.setMesssage("Success show order by id");
        response.setData(orderService.findById(id));

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Response> deleteById (@PathVariable ("id") Integer id) {
        Response response = new Response();
        response.setMesssage("Success delete by id");
        response.setData(orderService.findByIdOrder(id));

        orderService.cancelOrder(id);


        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }
}
