package com.api.resto.pop.controller;

import com.api.resto.pop.dto.InvoiceRequestDto;
import com.api.resto.pop.dto.OrderRequestDto;
import com.api.resto.pop.service.InvoiceService;
import com.api.resto.pop.service.MenuService;
import com.api.resto.pop.service.OrderService;
import com.api.resto.pop.service.TableService;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @Autowired
    InvoiceService invoiceService;

    @GetMapping(value = "viewOrder")
    public ModelAndView orderGet() {
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("Tables", tableService.findAll());
        modelAndView.addObject("Menus", menuService.findAll());

        return modelAndView;
    }

    @GetMapping(value = "doOrder")
    public ModelAndView orderFoods() {
        ModelAndView modelAndView= new ModelAndView("order");
        menuService.findAll();
        tableService.findAll();
        modelAndView.addObject("Menus", menuService.findAll());
        modelAndView.addObject("Tables", tableService.findAll());

        return modelAndView;
    }

    @PostMapping(value = "doOrder")
    public ModelAndView orderFood(@Valid InvoiceRequestDto invoiceRequestDto) {
        ModelAndView modelAndView = new ModelAndView();
        invoiceService.doPayment(invoiceRequestDto);
        modelAndView.addObject("Invoices", invoiceService.findAll());
        modelAndView.setViewName("redirect:/invoice/viewInvoice");

        return modelAndView;
    }

}
