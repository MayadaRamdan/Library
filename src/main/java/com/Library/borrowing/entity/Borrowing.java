package com.Library.borrowing.entity;

import com.Library.book.entity.Book;
import com.Library.borrowing.dto.BorrowingDto;
import com.Library.patron.entity.Patron;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "borrowing")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    private Book book;
    @ManyToOne
    private Patron patron;

    private LocalDateTime borrowingDate ;
    private  LocalDateTime returnDate;

    public Borrowing(Book book, Patron patron, LocalDateTime borrowingDate , LocalDateTime returnDate) {
        this.book=book;
        this.patron = patron;
        this.borrowingDate=borrowingDate;
        this.returnDate=returnDate;
    }







}
