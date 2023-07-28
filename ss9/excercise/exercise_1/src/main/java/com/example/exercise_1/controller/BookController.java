package com.example.exercise_1.controller;

import com.example.exercise_1.dto.BookDto;
import com.example.exercise_1.model.Book;
import com.example.exercise_1.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping("/list")
    public ModelAndView showList(@RequestParam(defaultValue = "0") Integer page){
        ModelAndView modelAndView = new ModelAndView("list");
        Pageable pageable = PageRequest.of(page,2, Sort.by("name").descending());
        Page<Book> bookPage = bookService.findAll(pageable);
        modelAndView.addObject("bookPage",bookPage);
        return modelAndView;
    }
    @PostMapping("/info")
    public ModelAndView showInfoBorrowForm(@RequestParam Integer id){
       ModelAndView modelAndView = new ModelAndView("book-info");
        Book book = bookService.findById(id);
        modelAndView.addObject("book",book);
        return modelAndView;
    }
}
