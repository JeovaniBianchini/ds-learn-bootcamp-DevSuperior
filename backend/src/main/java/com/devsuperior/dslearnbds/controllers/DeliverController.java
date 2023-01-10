package com.devsuperior.dslearnbds.controllers;

import com.devsuperior.dslearnbds.dtos.DeliverResponseDto;
import com.devsuperior.dslearnbds.services.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverController {

    @Autowired
    private DeliverService deliverService;


    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
    public ResponseEntity<Void> updateDeliver(@PathVariable Long id, @RequestBody DeliverResponseDto deliverResponseDto){
        deliverService.saveResponseDeliver(id, deliverResponseDto);
        return ResponseEntity.noContent().build();
    }

}
