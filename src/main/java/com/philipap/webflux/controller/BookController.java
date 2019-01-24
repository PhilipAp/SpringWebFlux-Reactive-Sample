package com.philipap.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.philipap.webflux.model.Book;
import com.philipap.webflux.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {
	
	private BookService bookService;
	
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping(value = "/book/{id}")
    public Mono<Book> getBookById(@PathVariable String id) {
        return bookService.findById(id);
    }
    
    @GetMapping(value = "/books")
    public Flux<Book> getAllBooks() {
        return bookService.findAll();
    }
    
    @PostMapping(value = "/book")
    public Mono<Book> createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

}
