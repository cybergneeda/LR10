package com.example.BookWebService.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BookWebService.Models.Book;
import com.example.BookWebService.Repositories.InMemoryBookRepository;

@Service
public class BookService {
    private InMemoryBookRepository bookRepository;

    @Autowired
    public BookService(InMemoryBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public Book findBookById(int id)
    {
        return bookRepository.getBookById(id).get();
    }

    public void addBook(Book book)
    {
        bookRepository.addBook(book);
    }

    public void deleteBook(int id)
    {
        bookRepository.deleteBook(id);
    }

    public void updateBook(Book book)
    {
        bookRepository.updateBook(book);
    }
}
