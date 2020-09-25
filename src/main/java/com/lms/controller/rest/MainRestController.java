package com.lms.controller.rest;

import com.lms.models.Book;
import com.lms.service.LmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController

public class MainRestController {

    @Autowired
    private LmsService lmsService;

    @GetMapping("/findAllBooks")
    public Collection<Book> getAllBooks(){
        return lmsService.findAllBooks();
    }

    @GetMapping("/delete")
    public void deleteBook(@RequestParam long id){
        lmsService.delete(id);
    }

}
