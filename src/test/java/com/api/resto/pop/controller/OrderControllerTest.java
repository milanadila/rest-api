package com.api.resto.pop.controller;

import com.api.resto.pop.PopApplicationTests;
import com.api.resto.pop.dto.OrderRequestDto;
import com.api.resto.pop.exception.IdNotFoundException;
import com.api.resto.pop.service.OrderService;
import com.api.resto.pop.util.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderControllerTest {

    private MockMvc mockMvc;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private ErrorResponse errorResponse;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/order")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.messsage", Matchers.is("Success show all order")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }

    @Test
    public void findById() throws Exception {
        Integer id = 1;
        mockMvc.perform(get("/order/" + id)
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.messsage", Matchers.is("Success show order by id")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }

    @Test
    public void orderFood() throws Exception {
        String json = "{\n" +
                "  \"idMenu\": 1,\n" +
                "  \"idTable\": 1,\n" +
                "  \"quantityMenu\": 1\n" +
                "}";

        mockMvc.perform(post("/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.messsage", Matchers.is("OrderFood Success")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }

    @Test
    public void cancelOrder() throws Exception {
        Integer id = 2;
        mockMvc.perform(delete("/order/" + id)
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.messsage", Matchers.is("Success delete by id")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));

    }

//    @Test
//    public void orderFoodFailed() throws Exception {
////        Mockito.when(orderService
////                .orderFood(Mockito.anyString()))
////                .thenReturn(acquirerMock);
//
//        String json = "{\n" +
//                "  \"idMenu\": 30,\n" +
//                "  \"idTable\": 70,\n" +
//                "  \"quantityMenu\": 30\n" +
//                "}";
//
//        mockMvc.perform(post("/order")
//        .contentType(MediaType.APPLICATION_JSON)
//        .content(json))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("$.message", Matchers.is("IdNotFoundException.class Unexpected Error")))
//                .andExpect(jsonPath("$.*", Matchers.hasSize(3)));
//    }
//
//    @Test
//    public void findByIdFailed() throws Exception {
//        Integer id = 0;
//        mockMvc.perform(get("/order/" + id)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("$.message", Matchers.is("Unexpected Error")))
//                .andExpect(jsonPath("$.*", Matchers.hasSize(3)));
//    }
}
