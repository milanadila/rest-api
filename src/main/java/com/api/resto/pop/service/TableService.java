package com.api.resto.pop.service;

import com.api.resto.pop.dto.TableRequestDto;
import com.api.resto.pop.dto.TableResponseDto;
import com.api.resto.pop.entity.TableOrder;
import com.api.resto.pop.exception.IdNotFoundException;
import com.api.resto.pop.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    TableRepository tableRepository;

    public List<TableOrder> findAll() {
        return tableRepository.findAll();
    }

    public TableOrder findById(Integer id) {
        return tableRepository.findById(id).orElseThrow(IdNotFoundException::new);
    }

    public TableResponseDto chooseTable(TableRequestDto tableRequestDto) {
        TableOrder tableOrder = new TableOrder();
        tableOrder.setNumberTable(tableRequestDto.getNumberTable());
        tableRepository.save(tableOrder);

        TableResponseDto tableResponseDto = new TableResponseDto();
        tableResponseDto.setIdTable(tableOrder.getIdTable());
        tableResponseDto.setNumberTable(tableOrder.getNumberTable());

        return tableResponseDto;
    }

    public TableOrder findByIdTable(Integer id) {
        return tableRepository.findByIdTable(id);
    }
}
