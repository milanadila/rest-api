//package com.api.resto.pop.controller;
//
//import com.api.resto.pop.dto.InvoiceRequestDto;
//import com.api.resto.pop.service.InvoiceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping(value = "/invoice")
//public class WebInvoiceController {
//
//    @Autowired
//    InvoiceService invoiceService;
//
//    @GetMapping(value = "viewInvoice")
//    public ModelAndView invoiceGet() {
//        ModelAndView modelAndView = new ModelAndView("add-invoice");
//        modelAndView.addObject("Invoices", invoiceService.findAll());
//        return modelAndView;
//    }
//
//    @GetMapping(value = "addInvoice")
//    public ModelAndView addInv() {
//        ModelAndView modelAndView = new ModelAndView("add-invoice");
//        return modelAndView;
//    }
//
//    @PostMapping(value = "addInvoice")
//    public ModelAndView addInvoice(@Valid InvoiceRequestDto invoiceRequestDto) {
//        ModelAndView modelAndView = new ModelAndView("detail-invoice");
//        modelAndView.addObject("Invoices", invoiceService.showOrder(invoiceRequestDto));
//
//        return modelAndView;
//    }
//
//
//    @GetMapping(value = "viewAllInvoice")
//    public ModelAndView viewInvoiceAll() {
//        ModelAndView modelAndView = new ModelAndView("view-all-invoice");
//        modelAndView.addObject("AllInvoice", invoiceService.findAll());
//        return modelAndView;
//    }
//
//}
