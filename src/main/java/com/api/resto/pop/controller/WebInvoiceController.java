package com.api.resto.pop.controller;

import com.api.resto.pop.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/invoice")
public class WebInvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping(value = "viewInvoice")
    public ModelAndView invoiceGet() {
        ModelAndView modelAndView = new ModelAndView("invoice");
        modelAndView.addObject("Invoices", invoiceService.findAll());
        return modelAndView;
    }
}
