package com.api.resto.pop.service;


import com.api.resto.pop.dto.TableRequestDto;
import com.api.resto.pop.dto.TableResponseDto;
import com.api.resto.pop.entity.TableOrder;
import com.api.resto.pop.exception.IdNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class TableServiceTest {

    @Autowired
    TableService tableService;

    private TableResponseDto tableResponseDto;

    @Before
    public void preDefine(){

        tableResponseDto = new TableResponseDto();
        tableResponseDto.setIdTable(1);
    }


    @Test
    public void findAll() {
        List<TableOrder> tableTest = tableService.findAll();
        assertThat(tableTest.size()).isNotNull();
        for (int i = 0; i < tableTest.size(); i++) {
        }
    }

    @Test
    public void findById() {



        Integer id = 1;
        TableOrder table = tableService.findById(id);
        log.info("loggggg" +table.getIdTable().toString());

        assertThat(table)
                .hasFieldOrProperty("idTable")
                .hasFieldOrProperty("numberTable");

        Assert.assertEquals(table.getIdTable(), tableResponseDto.getIdTable());
    }


    @Test
    public void chooseTable() {
        TableRequestDto tableRequestDto = new TableRequestDto();

        Integer numberTable= 1;

        tableRequestDto.setNumberTable(numberTable);

        TableResponseDto tableResponseDto = tableService.chooseTable(tableRequestDto);
        assertThat(tableResponseDto.getNumberTable()).isEqualTo(numberTable);
    }

    @Test(expected = IdNotFoundException.class)
    public void failedById() {
        Integer id = 50;
        TableOrder tableOrder = tableService.findById(id);
        assertThat(tableOrder.getIdTable()).isNotEqualTo(id);
    }

}
