package com.book_order.controller;


import com.book_order.model.Book;
import com.book_order.model.BookOder;
import com.book_order.service.book_service.IBookService;
import com.book_order.service.order_service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("")
public class BookOrderController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IOderService oderService;

@GetMapping("/")
    public String showList(Model model){
    model.addAttribute("books",bookService.finAll());
    return"book/list";
}

@GetMapping("/order/{id}")
    public String showOder(@PathVariable int id, Model model){
    Book book = bookService.finById(id);
    model.addAttribute("book",book);
    return "/book/oder_form";
}
//    @PostMapping("/order")
//    public String order(@RequestParam Integer id, Model model) {
//
//        int otp = (int) (Math.random() * (99999 - 10000) + 10000);
//        Book book = bookService.finById(id);
//        String orderDate = String.valueOf(new Date(System.currentTimeMillis()));
//
//        BookOder bookOrder = new BookOder(otp, orderDate, book);
//        oderService.save(bookOrder);
//
//        book.setStock(book.getStock() - 1);
//        bookService.save(book);
//
//        model.addAttribute("message",
//                "Successfully order! Your order OTP is: " + otp);
//        return "book/notification";
//    }
}
