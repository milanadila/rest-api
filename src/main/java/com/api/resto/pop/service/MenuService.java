package com.api.resto.pop.service;

import com.api.resto.pop.dto.MenuResponseDto;
import com.api.resto.pop.entity.Menu;
import com.api.resto.pop.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    public List<MenuResponseDto> findAll() {
        List<Menu> listMenu = menuRepository.findAll();
        List<MenuResponseDto> listMenuDto = new ArrayList<>();
        for (Menu menu: listMenu) {
            MenuResponseDto menuResponseDto = new MenuResponseDto();
            menuResponseDto.setNameMenu(menu.getNameMenu());
            menuResponseDto.setPriceMenu(menu.getPriceMenu());

            listMenuDto.add(menuResponseDto);
        }

        return listMenuDto;
    }

    public MenuResponseDto findById(Integer id) {
        Menu menu = menuRepository.findByIdMenu(id);
        MenuResponseDto menuResponseDto = new MenuResponseDto();
        menuResponseDto.setNameMenu(menu.getNameMenu());
        menuResponseDto.setPriceMenu(menu.getPriceMenu());

        return menuResponseDto;
    }
}
