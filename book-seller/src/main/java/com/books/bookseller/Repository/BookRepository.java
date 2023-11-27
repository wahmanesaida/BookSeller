package com.books.bookseller.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.bookseller.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    
}
