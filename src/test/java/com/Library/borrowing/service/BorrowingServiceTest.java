package com.Library.borrowing.service;

import com.Library.book.entity.Book;
import com.Library.book.repo.BookRepo;
import com.Library.borrowing.entity.Borrowing;
import com.Library.borrowing.reop.BorrowingRepo;
import com.Library.exceptions.BookNotFoundException;
import com.Library.exceptions.PatronNotFoundException;
import com.Library.patron.entity.Patron;
import com.Library.patron.repo.PatronRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class BorrowingServiceTest {


    @Mock
    BookRepo bookRepo;

    @Mock
    PatronRepo patronRepo;

    @Mock
    BorrowingRepo borrowingRepo;

    @Test
    public void testingHappyScenario() {

        Book mockedBook = new Book();
        Patron mockedPatron = new Patron();
        Mockito.when(bookRepo.findById(1L)).thenReturn(Optional.of(mockedBook));
        Mockito.when(patronRepo.findById(1L)).thenReturn(Optional.of(mockedPatron));

        BorrowingService borrowingService = new BorrowingService(borrowingRepo, bookRepo, patronRepo);
        borrowingService.addBorrowing(1L, 1L);

        Borrowing borrowingMock = new Borrowing(null, mockedBook, mockedPatron, LocalDateTime.now(), null);
        Mockito.verify(borrowingRepo).save(borrowingMock);
    }


    @Test
    public void testingInvalidBookId() {

        Patron mockedPatron = new Patron();
        Mockito.when(bookRepo.findById(1L)).thenReturn(Optional.empty());
        Mockito.when(patronRepo.findById(1L)).thenReturn(Optional.of(mockedPatron));

        BorrowingService borrowingService = new BorrowingService(borrowingRepo, bookRepo, patronRepo);

        assertThatThrownBy(() -> borrowingService.addBorrowing(1L, 1L))
                .isInstanceOf(BookNotFoundException.class);
    }

    @Test
    public void testingInvalidPatronId() {

        Book mockedBook = new Book();

        Mockito.when(bookRepo.findById(1L)).thenReturn(Optional.of(mockedBook));
        Mockito.when(patronRepo.findById(1L)).thenReturn(Optional.empty());

        BorrowingService borrowingService = new BorrowingService(borrowingRepo, bookRepo, patronRepo);

        assertThatThrownBy(() -> borrowingService.addBorrowing(1L, 1L))
                .isInstanceOf(PatronNotFoundException.class);
    }

}