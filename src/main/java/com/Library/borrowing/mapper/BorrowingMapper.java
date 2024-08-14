package com.Library.borrowing.mapper;

import com.Library.borrowing.dto.BorrowingDto;
import com.Library.borrowing.entity.Borrowing;

public class BorrowingMapper {
    public static Borrowing toBorrowing(BorrowingDto borrowingDto) {
        return Borrowing.builder()
                .id(borrowingDto.getId())
                .book(borrowingDto.getBook())
                .patron(borrowingDto.getPatron())
                .build();
    }


    public static BorrowingDto toBorrowingDto(Borrowing borrowing){
        return BorrowingDto.builder()
                .id(borrowing.getId())
                .book(borrowing.getBook())
                .patron(borrowing.getPatron())
                .build();

    }
}
