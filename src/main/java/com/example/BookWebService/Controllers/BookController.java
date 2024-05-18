package com.example.BookWebService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.BookWebService.Models.Book;
import com.example.BookWebService.Services.BookService;

@RestController
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("book/{id}")
    public Book findById(@PathVariable Integer id)
    {
        return bookService.findBookById(id);
    }

    @PostMapping("/book/add")
    public String addBook(
        @RequestParam Integer id, 
        @RequestParam String title, 
        @RequestParam String author, 
        @RequestParam int pubYear,
        @RequestParam int numberOfPages
    ){
        bookService.addBook(new Book(id, title, author, pubYear, numberOfPages));
        return "Книга успешно добавлена";
    }

    @DeleteMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable Integer id)
    {
        bookService.deleteBook(id);
        return "Книга "+ id +" удалена";
    }

    @PatchMapping("/book/update")
    public String updateBook(
        @RequestParam Integer id, 
        @RequestParam String title, 
        @RequestParam String author, 
        @RequestParam int pubYear,
        @RequestParam int numberOfPages
    )
    {
        bookService.updateBook(new Book(id, title, author, pubYear, numberOfPages));
        return "Книга "+ id +" изменена";
    }
}
