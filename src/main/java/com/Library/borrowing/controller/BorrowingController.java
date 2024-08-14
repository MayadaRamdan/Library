package com.Library.borrowing.controller;

import com.Library.borrowing.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BorrowingController {
    @Autowired
    BorrowingService borrowingService;



    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<Void> addBorrowing( @PathVariable("bookId") Long bookId, @PathVariable("patronId") Long patronId){
        borrowingService.addBorrowing(bookId , patronId);
        return ResponseEntity.ok().build();
    }



    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<Void> updateBook( @PathVariable("bookId") Long bookId, @PathVariable("patronId") Long patronId){
        borrowingService.returnBorrowing(bookId , patronId);
        return ResponseEntity.ok().build();
    }
}
