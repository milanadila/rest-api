package com.api.resto.pop.controller;

import com.api.resto.pop.dto.TableRequestDto;
import com.api.resto.pop.service.TableService;
import com.api.resto.pop.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "table")
public class TableController {

    @Autowired
    TableService tableService;

    @PostMapping
    ResponseEntity<Response> addTable(@RequestBody @Valid TableRequestDto tableRequestDto) {
        Response response = new Response();
        response.setMesssage("Success choose table");
        response.setData(tableService.chooseTable(tableRequestDto));

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @GetMapping
    ResponseEntity<Response> findAll() {
        Response response = new Response();
        response.setMesssage("Success show all table");
        response.setData(tableService.findAll());

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Response> getById (@PathVariable ("id") Integer id) {
        Response response = new Response();
        response.setMesssage("Success show table by id");
        response.setData(tableService.findById(id));

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }
}
