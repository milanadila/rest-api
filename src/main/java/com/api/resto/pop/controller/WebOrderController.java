package com.api.resto.pop.controller;

import com.api.resto.pop.dto.OrderRequestDto;
import com.api.resto.pop.dto.OrderResponseDto;
import com.api.resto.pop.service.MenuService;
import com.api.resto.pop.service.OrderService;
import com.api.resto.pop.service.TableService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping(value = "/order")
public class WebOrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    TableService tableService;

    @Autowired
    MenuService menuService;

    @GetMapping(value = "viewOrder")
    public ModelAndView orderGet() {
        ModelAndView modelAndView = new ModelAndView("add-order");
        modelAndView.addObject("Tables", tableService.findAll());
        modelAndView.addObject("Menus", menuService.findAll());
        modelAndView.addObject("Orders", orderService.findAll());

        return modelAndView;
    }

    @GetMapping(value = "addOrder")
    public ModelAndView orderFoods() {
        ModelAndView modelAndView= new ModelAndView("add-order");

        return modelAndView;
    }

    @PostMapping(value = "addOrder")
    public ModelAndView orderFood(@Valid OrderRequestDto orderRequestDto) {
        ModelAndView modelAndView = new ModelAndView("detail-order");
        modelAndView.addObject("Orders", orderService.orderFood(orderRequestDto));

        return modelAndView;
    }

    @GetMapping(value = "viewAllOrder")
    public ModelAndView viewAllOrder() {
        ModelAndView modelAndView = new ModelAndView("view-all-order");

        modelAndView.addObject("AllOrder", orderService.findAll());

        return modelAndView;
    }

    @GetMapping(value = "cancelOrder/{id}")
    public RedirectView deleteOrder(@PathVariable Integer id) {
        orderService.cancelOrder(id);

        return new RedirectView("/popresto/order/viewAllOrder");
    }

}
