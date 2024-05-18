package com.example.BookWebService.Repositories;

import com.example.BookWebService.Models.Book;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBookRepository {
    private List<Book> books;

    public Optional<Book> getBookById(int id)
    {
        for (Book book : books) {
            if (book.getId()==id) 
                return Optional.of(book);
            }
        return Optional.empty();
    }

    public void addBook(Book book)
    {
        books.add(book);
    }

    public void deleteBook(int id)
    {
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            if(bookIterator.next().getId()==id)
                bookIterator.remove();          
        }}

    public void updateBook(Book book)
    {
        books.set(book.getId()-1, book);
    }

    @PostConstruct
    public void init()
    {
        books = new ArrayList<>(Arrays.asList(
            new Book(1, "Что такое жизнь?", "Эрвин Шредингер", 1944 , 288),
            new Book(2, "Критика практического разума", "Иммануил Кант", 1788, 256),
            new Book(3, "Апология Сократа", "Платон", -393, 352),
            new Book(4, "Смерть в кредит", "Луи-Фердинанд Селин", 1936, 544),
            new Book(5, "Сто лет одиночества", "Габриэль Гарсиа Маркес", 1967, 544),
            new Book(6, "Посмертные записки Пиквикского клуба", "Чарлз Диккенс",1837 , 1008)
        ));
    }}
