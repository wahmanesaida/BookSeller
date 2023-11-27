package com.books.bookseller.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.books.bookseller.Entity.Purchases;
import com.books.bookseller.Repository.PurchasesRepository;

@Service
public class PurchaseServiceImp implements PurchaseService {
    
    @Autowired
    private PurchasesRepository purchasesRepository;

    @Override
    public Purchases SavePurchase(Purchases purchase){
        purchase.setPurchaseTime(LocalDateTime.now());
        return purchasesRepository.save(purchase);
    }

    @Override
    public Optional<Purchases> findById(Long id){
        return purchasesRepository.findById(id);
    }

    @Transactional
    @Override
    public void DeletePurchase(Long id){
        purchasesRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void DeleteAllpurchases(){
        purchasesRepository.deleteAll();
    }

    @Override
    public List<Purchases> findAllpPurchases(){
        return purchasesRepository.findAll();
    }
}
