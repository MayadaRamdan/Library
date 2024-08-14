package com.Library.patron.mapper;

import com.Library.book.dto.BookDto;
import com.Library.book.entity.Book;
import com.Library.patron.dto.PatronDto;
import com.Library.patron.entity.Patron;

import java.util.LinkedList;
import java.util.List;

public class PatronMapper {
    public static Patron toPatronEntity(PatronDto patronDto){
        return Patron.builder()
                .id(patronDto.getId())
                .name(patronDto.getName())
                .phone(patronDto.getPhone())
                .email(patronDto.getEmail())
                .address(patronDto.getAddress())
                .build();

    }
    public static PatronDto toPatronDto(Patron patron){
        return PatronDto.builder()
                .id(patron.getId())
                .name(patron.getName())
                .phone(patron.getPhone())
                .email(patron.getEmail())
                .address(patron.getAddress())
                .build();

    }

    public static List<PatronDto> toListPatronDto(List<Patron> patrons) {
        List<PatronDto> patronDtos = new LinkedList<>();
        for (Patron patron : patrons) {
            PatronDto patronDto = PatronDto.builder()
                    .id(patron.getId())
                    .name(patron.getName())
                    .phone(patron.getPhone())
                    .email(patron.getEmail())
                    .address(patron.getAddress())
                    .build();
            patronDtos.add(patronDto);
        }
        return patronDtos;
    }
}
