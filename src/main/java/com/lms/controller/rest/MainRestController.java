package com.lms.controller.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.models.Book;
import com.lms.service.LmsService;

@RestController

public class MainRestController {

    @Autowired
    private LmsService lmsService;

    @GetMapping("/findAllBooks")
    public Collection<Book> getAllBooks(){
        return lmsService.findAllBooks();
    }
}
