package com.api.resto.pop.service;


import com.api.resto.pop.dto.MenuResponseDto;
import com.api.resto.pop.entity.Menu;
import com.api.resto.pop.exception.IdNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
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

    MenuResponseDto menuResponseDto;

    @Before
    public void preDefine() {

        menuResponseDto = new MenuResponseDto();
        menuResponseDto.setNameMenu("Grilled Atlantic Salmon Steak");
    }
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
        Menu menu = menuService.findById(id);

        assertThat(menu)
                .hasFieldOrProperty("nameMenu")
                .hasFieldOrProperty("priceMenu");

        Assert.assertEquals(menu.getNameMenu(), menuResponseDto.getNameMenu());
    }
}
