package com.example.exercise_1.aop;

import com.example.exercise_1.model.Book;
import com.example.exercise_1.model.Log;
import com.example.exercise_1.repository.ILogRepository;
import com.example.exercise_1.service.IBookService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Aspect
@Component
public class logger {
    public static long count;
    @Autowired
    private ILogRepository logRepository;
    @Autowired
    private IBookService bookService;
    @After("execution (* com.example.exercise_1.controller.*.*(..))")
    public void count(){
        Log log = logRepository.findByMsg("number of people visited");
        count = log.getCount();
        count++;
        if (log == null){
            log = new Log();
            log.setMsg("number of people visited");
        }
        log.setLastTime(Timestamp.valueOf(LocalDateTime.now()));
        log.setCount(count);
        logRepository.save(log);
    }
    @Around("execution(* com.example.exercise_1.service.BookService.increaseByOneBook(..))")
    public void loggingIncreaseByOneBook(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String code = (String) args[0];
        Book book = bookService.findBookBorrowByCode(code);
        Log log = new Log();
        log.setCount(1L);
        log.setLastTime(Timestamp.valueOf(LocalDateTime.now()));
        log.setMsg("The book \""+book.getName()+"\" has been returned");
        logRepository.save(log);
    }
    @Around("execution(* com.example.exercise_1.service.BookService.decreaseByOneBook(..))")
    public void loggingDecreaseByOneBook(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Book book = (Book) args[0];
        Log log = new Log();
        log.setCount(1L);
        log.setLastTime(Timestamp.valueOf(LocalDateTime.now()));
        log.setMsg("The book \""+book.getName()+"\" has been borrowed");
        logRepository.save(log);
    }

}
