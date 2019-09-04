package com.api.resto.pop.controller;

import com.api.resto.pop.dto.InvoiceRequestDto;
import com.api.resto.pop.service.InvoiceService;
import com.api.resto.pop.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping
    ResponseEntity<Response> addInvoice(@RequestBody @Valid InvoiceRequestDto invoiceRequestDto) {
        Response response = new Response();
        response.setMesssage("Payment Success");
        response.setData(invoiceService.doPayment(invoiceRequestDto));

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @GetMapping
    ResponseEntity<Response> findAll() {
        Response response = new Response();
        response.setMesssage("Success show all invoice");
        response.setData(invoiceService.findAll());

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Response> findById(@PathVariable ("id") Integer id) {
        Response response = new Response();
        response.setMesssage("Success show invoice by id");
        response.setData(invoiceService.findById(id));

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }
}
