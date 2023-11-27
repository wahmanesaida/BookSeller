package com.books.bookseller.Service;

import java.util.List;
import java.util.Optional;

import com.books.bookseller.Entity.Purchases;

public interface PurchaseService {
    public Purchases SavePurchase(Purchases purchase);
    public Optional<Purchases> findById(Long id);
    public void DeletePurchase(Long id);
    public void DeleteAllpurchases();
    public List<Purchases> findAllpPurchases();
}
