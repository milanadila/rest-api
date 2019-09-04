package com.api.resto.pop.controller;

import com.api.resto.pop.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class InvoiceControllerTest {

    private MockMvc mockMvc;

    @Mock
    private InvoiceService invoiceService;

    @InjectMocks
    private InvoiceController invoiceController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(invoiceController).build();
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/invoice")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.messsage", Matchers.is("Success show all invoice")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }

    @Test
    public void findById() throws Exception {
        Integer id = 1;
        mockMvc.perform(get("/invoice/" + id)
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.messsage", Matchers.is("Success show invoice by id")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }

    @Test
    public void doPayment() throws Exception {
        String json = "{\n" +
                "  \"idOrder\": 1,\n" +
                "  \"idTable\": 1\n" +
                "}";

        mockMvc.perform(post("/invoice")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.messsage", Matchers.is("Payment Success")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }
}
