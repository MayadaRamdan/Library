package com.Library.borrowing.entity;

import com.Library.book.entity.Book;
import com.Library.patron.entity.Patron;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrowing borrowing = (Borrowing) o;
        return Objects.equals(book, borrowing.book) && Objects.equals(patron, borrowing.patron);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, patron);
    }




}
