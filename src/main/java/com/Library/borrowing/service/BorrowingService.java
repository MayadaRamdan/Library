package com.Library.borrowing.service;

import com.Library.book.entity.Book;
import com.Library.book.mapper.BookMapping;
import com.Library.book.service.BookService;
import com.Library.borrowing.entity.Borrowing;
import com.Library.patron.entity.Patron;
import com.Library.borrowing.reop.BorrowingRepo;
import com.Library.patron.mapper.PatronMapper;
import com.Library.patron.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BorrowingService {

    @Autowired
    BorrowingRepo borrowingRepo;

    @Autowired
    BookService bookService;

    @Autowired
    PatronService patronService;

    @Transactional
    public void addBorrowing( Long bookId , Long patronId){
        Patron patron= PatronMapper.toPatronEntity( patronService.getAPatron(patronId));
        Book book= BookMapping.toBook(bookService.getABook(bookId));
        borrowingRepo.save(new Borrowing(book ,patron ,LocalDateTime.now() , null));
    }

    @Transactional
    public void returnBorrowing( Long bookId , Long patronId){
       Borrowing borrowing= borrowingRepo.findByIds(bookId ,patronId).get();
        borrowing.setReturnDate(LocalDateTime.now());
        borrowingRepo.save(borrowing);
    }

}
