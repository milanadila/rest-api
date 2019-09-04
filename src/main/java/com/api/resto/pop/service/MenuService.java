package com.api.resto.pop.service;

import com.api.resto.pop.dto.MenuResponseDto;
import com.api.resto.pop.entity.Menu;
import com.api.resto.pop.exception.IdNotFoundException;
import com.api.resto.pop.repository.MenuRepository;
import jdk.nashorn.internal.ir.Optimistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    public Menu findById(Integer id) {

        Optional<Menu> menu = Optional.of(menuRepository.findById(id).orElseThrow(IdNotFoundException::new));
        Menu menuResponseDto = new Menu();
        menuResponseDto.setNameMenu(menu.get().getNameMenu());
        menuResponseDto.setPriceMenu(menu.get().getPriceMenu());

        return menuResponseDto;
    }
}
