package com.example.BookWebService.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private int id;
    private String title;
    private String author;
    private int pubYear;
    private int numberOfPages;
}
