package com.api.resto.pop.service;


import com.api.resto.pop.dto.MenuResponseDto;
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
public class MenuServiceTest {

    @Autowired
    MenuService menuService;

    @Test
    public void findAll() {
        List<MenuResponseDto> menuResponseDtoTest = menuService.findAll();
        assertThat(menuResponseDtoTest.size()).isNotNull();
        for (int i = 0; i < menuResponseDtoTest.size(); i++) {
        }
    }

    @Test
    public void findById() {
        Integer id = 1;
        MenuResponseDto menu = menuService.findById(id);

        assertThat(menu)
                .hasFieldOrProperty("nameMenu")
                .hasFieldOrProperty("priceMenu");
    }
}
