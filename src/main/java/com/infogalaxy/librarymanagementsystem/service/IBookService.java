package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.BookEntity;

import java.util.List;
import java.util.Optional;

/***
 * IBookService Interface is used to Declare the Book Functions
 */

public interface IBookService {

    public BookEntity createBook(BookEntity bookEntity);

    public List<BookEntity> retrieveAllBook();

    public Optional<BookEntity> retrieveBookById(int id);

    public BookEntity updateBookById(int id, BookEntity bookEntity);

    public String deleteBookById(int id);

}

