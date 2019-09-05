package com.api.resto.pop.controller;

import com.api.resto.pop.service.TableService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping(value = "/table")
public class WebTableController {

    @Autowired
    TableService tableService;

    @GetMapping(value = "/viewTable")
    public ModelAndView menuGet() {
        ModelAndView modelAndView = new ModelAndView("table");

        modelAndView.addObject("Tables", tableService.findAll());
        return modelAndView;
    }
}
