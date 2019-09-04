package com.api.resto.pop.controller;

import com.api.resto.pop.dto.TransactionRequestDto;
import com.api.resto.pop.service.TransactionService;
import com.api.resto.pop.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping
    ResponseEntity<Response> addTransaction(@RequestBody @Valid TransactionRequestDto transactionRequestDto) {
        Response response = new Response();
        response.setMesssage("TransactionInvoice success");
        response.setData(transactionService.doTransaction(transactionRequestDto));

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @GetMapping
    ResponseEntity<Response> findAll() {
        Response response = new Response();
        response.setMesssage("Success show all transaction");
        response.setData(transactionService.findAll());

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Response> findById(@PathVariable("id") Integer id) {
        Response response = new Response();
        response.setMesssage("Success show transaction by id");
        response.setData(transactionService.findById(id));

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);

    }
}