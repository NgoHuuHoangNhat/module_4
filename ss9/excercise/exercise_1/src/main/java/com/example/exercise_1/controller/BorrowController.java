package com.example.exercise_1.controller;

import com.example.exercise_1.model.Book;
import com.example.exercise_1.model.Borrow;
import com.example.exercise_1.model.LibraryCard;
import com.example.exercise_1.service.IBookService;
import com.example.exercise_1.service.IBorrowService;
import com.example.exercise_1.service.ILibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;


@Controller
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private ILibraryCardService libraryCardService;
    @Autowired
    private IBorrowService borrowService;
    @Autowired
    private IBookService bookService;
    @PostMapping("/get-code")
    public String borrowBook(@RequestParam String code,
                             @RequestParam Integer bookId,
                             Model model){
        LibraryCard libraryCard = libraryCardService.findByCardCode(code);
        Book book = bookService.findById(bookId);
        if(libraryCard == null){
            model.addAttribute("code",code);
            model.addAttribute("book",book);
            model.addAttribute("msg","The library card code has not exist!");
            return "book-info";
        }

        String generatedString = new Random().ints(65, 90)
                .limit(5)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        Boolean check = borrowService.save(book,libraryCard,generatedString);
        if(!check){
            model.addAttribute("code",code);
            model.addAttribute("book",book);
            model.addAttribute("msgQuantity","This book is sold out, please choose another one!");
            return "book-info";
        }
        model.addAttribute("generatedString",generatedString);
        return "borrow-success";
    }
    @GetMapping("/give-back-form")
    public String showForm(){
        return "give-back";
    }
    @PostMapping("/give-back")
    public String giveBackBook(@RequestParam String code, RedirectAttributes redirectAttributes){
        Boolean check = borrowService.deleteBorrowByCode(code);
        if(!check){
            redirectAttributes.addFlashAttribute("code",code);
            redirectAttributes.addFlashAttribute("msg","Code not exist or empty!");
            return "redirect:/borrow/give-back-form";
        }
        return "redirect:/book/list";
    }
}
