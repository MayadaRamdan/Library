package com.Library.borrowing.service;

import com.Library.book.entity.Book;
import com.Library.book.repo.BookRepo;
import com.Library.borrowing.entity.Borrowing;
import com.Library.borrowing.reop.BorrowingRepo;
import com.Library.exceptions.BookNotFoundException;
import com.Library.exceptions.PatronNotFoundException;
import com.Library.patron.entity.Patron;
import com.Library.patron.repo.PatronRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class BorrowingService {

    private final BorrowingRepo borrowingRepo;
    private final BookRepo bookRepo;
    private final PatronRepo patronRepo;

    @Transactional
    public void addBorrowing(Long bookId, Long patronId) {

        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(""));

        Patron patron =patronRepo.findById(patronId)
                        .orElseThrow(()-> new PatronNotFoundException(""));

        Borrowing borrowing = new Borrowing(book, patron, LocalDateTime.now(), null);
        borrowingRepo.save(borrowing);

    }

    @Transactional
    public void returnBorrowing(Long bookId, Long patronId) {
        Borrowing borrowing = borrowingRepo.findByIds(bookId, patronId).get();
        borrowing.setReturnDate(LocalDateTime.now());
        borrowingRepo.save(borrowing);
    }

}
