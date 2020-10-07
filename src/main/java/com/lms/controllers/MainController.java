package com.lms.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.models.Book;
import com.lms.service.LmsService;

@Controller
public class MainController {

    @Autowired
    private LmsService lmsService;


    @GetMapping("/")
    public String init(HttpServletRequest req) {
        req.setAttribute("books", lmsService.findAllBooks());
        req.setAttribute("mode", "BOOK_VIEW");
        return "index";
    }

    @GetMapping("/updateBook")
    public String init(@RequestParam long id, HttpServletRequest req) {
        req.setAttribute("book", lmsService.findOne(id));
        req.setAttribute("mode", "BOOK_EDIT");
        return "index";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
       binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

    @PostMapping("/save")
    public void save( @ModelAttribute  Book book , HttpServletRequest req, BindingResult bindingResult, HttpServletResponse response) throws IOException {
        lmsService.save(book);
        //init(req);
        req.setAttribute("book",lmsService.findAllBooks());
        req.setAttribute("mode", "BOOK_VIEW");
        response.sendRedirect("/");
    }

    @GetMapping("/newBook")
    public String newBook(HttpServletRequest req){
        req.setAttribute("mode", "NEW_BOOK");
        return "index";
    }

    @GetMapping("/deleteBook")
    public void deleteBook(@RequestParam long id, HttpServletRequest req, HttpServletResponse response)throws IOException {
        req.setAttribute("book", lmsService.findOne(id));
        lmsService.delete(id);
        response.sendRedirect("/");
    }
}
