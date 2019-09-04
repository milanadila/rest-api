package com.api.resto.pop.service;

import com.api.resto.pop.dto.MenuResponseDto;
import com.api.resto.pop.entity.Menu;
import com.api.resto.pop.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> 99ef156e354175c49534aaf92645d73f3c6a9012

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
<<<<<<< HEAD
=======

>>>>>>> 99ef156e354175c49534aaf92645d73f3c6a9012
        Menu menu = menuRepository.findByIdMenu(id);
        MenuResponseDto menuResponseDto = new MenuResponseDto();
        menuResponseDto.setNameMenu(menu.getNameMenu());
        menuResponseDto.setPriceMenu(menu.getPriceMenu());

        return menuResponseDto;
    }
}
