package com.books.bookseller.Service;

import java.util.Optional;

import com.books.bookseller.Entity.User;

public interface UserService {
    User SaveUser(User user);
    Optional<User> findByUsername(String username);
    void MakeAdmin(String username);
    
}
