package com.Library.borrowing.dto;


import com.Library.book.entity.Book;
import com.Library.patron.entity.Patron;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingDto {

    private Long id;

    private Book book;
    private Patron patron;
    private LocalDateTime borrowingDate;
    private LocalDateTime returnDate;


}
