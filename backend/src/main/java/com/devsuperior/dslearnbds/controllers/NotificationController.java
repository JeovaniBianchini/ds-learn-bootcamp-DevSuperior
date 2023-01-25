package com.devsuperior.dslearnbds.controllers;

import com.devsuperior.dslearnbds.dtos.NotificationDto;
import com.devsuperior.dslearnbds.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity<Page<NotificationDto>> notificatinsForCurrentUser(@RequestParam(name = "unreadOnly", defaultValue = "false") boolean unreadOnly, Pageable pageable){
        Page<NotificationDto> page = notificationService.notificationsForCurrentUser(unreadOnly, pageable);
        return ResponseEntity.ok().body(page);
    }

}
