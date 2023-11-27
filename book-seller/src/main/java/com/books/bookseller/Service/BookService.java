package com.books.bookseller.Service;

import java.util.List;

import com.books.bookseller.Entity.Book;

public interface BookService {
    public Book SaveBook(Book book);
    public void DeleteBook(Long id);
    public List<Book> findAllBooks();
}
