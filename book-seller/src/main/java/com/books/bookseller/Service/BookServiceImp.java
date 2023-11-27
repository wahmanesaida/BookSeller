package com.books.bookseller.Service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.books.bookseller.Entity.Book;
import com.books.bookseller.Repository.BookRepository;

@Service
public class BookServiceImp implements BookService {


    private final BookRepository bookRepository;

    public BookServiceImp(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    //save book
    @Override
    public Book SaveBook(Book book){
        book.setCreateTime(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Transactional
    @Override
    public void DeleteBook(Long id){
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }
    
   } 

