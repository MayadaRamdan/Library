package com.Library.borrowing.dto;


import com.Library.book.entity.Book;
import com.Library.borrowing.entity.Borrowing;
import com.Library.patron.entity.Patron;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingDto {

    private Long id ;
    private Book book;
    private Patron patron;
    private LocalDateTime borrowingDate ;
    private  LocalDateTime returnDate;


    public static BorrowingDto toBorrowingDto(Borrowing borrowing){
        return BorrowingDto.builder()
                .id(borrowing.getId())
                .book(borrowing.getBook())
                .patron(borrowing.getPatron())
                //.borrowingDate(borrowing.getBorrowingDate())
                //.returnDate(borrowing.getReturnDate())
                .build();

    }
}
