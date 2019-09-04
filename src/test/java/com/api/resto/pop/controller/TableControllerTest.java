package com.api.resto.pop.controller;

import com.api.resto.pop.service.TableService;
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
public class TableControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TableService tableService;

    @InjectMocks
    private TableController tableController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(tableController).build();
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/table")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.messsage", Matchers.is("Success show all table")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }

    @Test
    public void findById() throws Exception {
        Integer id = 1;
        mockMvc.perform(get("/table/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.messsage", Matchers.is("Success show table by id")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }

    @Test
    public void chooseTable() throws Exception {
        String json = "{\n" +
                "  \"numberTable\": 1\n" +
                "}";

        mockMvc.perform(post("/table")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.messsage", Matchers.is("Success choose table")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }
}
