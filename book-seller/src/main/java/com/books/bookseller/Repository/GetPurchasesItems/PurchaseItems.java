package com.books.bookseller.Repository.GetPurchasesItems;

import java.time.LocalDateTime;

public interface PurchaseItems {
    // to extract the nessessory title , price and local date
    String getTitle();
    Double getPrice();
    LocalDateTime getPurchaseTime();
    
}
