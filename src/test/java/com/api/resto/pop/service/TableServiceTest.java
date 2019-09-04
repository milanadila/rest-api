package com.api.resto.pop.service;

import com.api.resto.pop.dto.TableRequestDto;
import com.api.resto.pop.dto.TableResponseDto;
import com.api.resto.pop.entity.TableOrder;
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
public class TableServiceTest {

    @Autowired
    TableService tableService;

    @Test
    public void findAll() {
        List<TableOrder> tableResponseDtoTest = tableService.findAll();
        assertThat(tableResponseDtoTest.size()).isNotNull();
        for (int i = 0; i < tableResponseDtoTest.size(); i++) {
        }
    }

    @Test
    public void findById() {
        Integer id = 1;
        TableOrder table = tableService.findById(id);

        assertThat(table)
                .hasFieldOrProperty("idTable")
                .hasFieldOrProperty("numberTable");
    }

    @Test
    public void chooseTable() {
        TableRequestDto tableRequestDto = new TableRequestDto();

        Integer numberTable= 1;

        tableRequestDto.setNumberTable(numberTable);

        TableResponseDto tableResponseDto = tableService.chooseTable(tableRequestDto);
        assertThat(tableResponseDto.getNumberTable()).isEqualTo(numberTable);
    }
}
