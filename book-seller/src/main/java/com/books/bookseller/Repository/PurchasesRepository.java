package com.books.bookseller.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.books.bookseller.Entity.Purchases;
import com.books.bookseller.Repository.GetPurchasesItems.PurchaseItems;

public interface PurchasesRepository extends JpaRepository<Purchases, Long> {

    @Query("select b.title as title, ph.price as price, ph.purchaseTime as purchaseTime from Purchases ph left join Book b on b.id=ph.bookId where ph.userId= :userId")
    List<PurchaseItems> findAllPurchasesOfUser(@Param("userId") Long userId);

    
}
