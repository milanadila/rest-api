package com.api.resto.pop.controller;

import com.api.resto.pop.service.MenuService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping(value = "/menu")
public class WebMenuController {

    @Autowired
    MenuService menuService;

    @GetMapping(value = "/viewMenu")
    public ModelAndView menuGet() {
        ModelAndView modelAndView = new ModelAndView("menu");

        modelAndView.addObject("Menus", menuService.findAll());
        return modelAndView;
    }
}
