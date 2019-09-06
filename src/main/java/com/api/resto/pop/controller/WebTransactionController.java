package com.api.resto.pop.controller;

import com.api.resto.pop.dto.TransactionRequestDto;
import com.api.resto.pop.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/transaction")
public class WebTransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping(value = "viewTransaction")
    public ModelAndView transaction() {
        ModelAndView modelAndView = new ModelAndView("transaction");
        modelAndView.addObject("Transaction", transactionService.findAll());
        return modelAndView;
    }

    @GetMapping(value = "addTransaction")
    public ModelAndView addTrans() {
        ModelAndView modelAndView = new ModelAndView("transaction");
        return modelAndView;
    }

    @PostMapping(value = "addTransaction")
    public ModelAndView addTransaction(@Valid TransactionRequestDto transactionRequestDto) {
        ModelAndView modelAndView = new ModelAndView("detail-transaction");
        modelAndView.addObject("Transaction", transactionService.doTransaction(transactionRequestDto));
        return modelAndView;
    }

    @GetMapping(value = "viewAllTransaction")
    public ModelAndView viewAll() {
        ModelAndView modelAndView = new ModelAndView("view-all-transaction");
        modelAndView.addObject("Transactions", transactionService.findAll());
        return modelAndView;
    }
}
