package com.Library.book.mapper;


import com.Library.book.dto.BookDto;
import com.Library.book.entity.Book;

import java.util.LinkedList;
import java.util.List;

public class BookMapping {

    public static Book toBook(BookDto bookDto){
        return Book.builder()
                .id(bookDto.getId())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .publicationYear(bookDto.getPublicationYear())
                .isbn(bookDto.getIsbn())
                .status(bookDto.getStatus())
                .build();

    }

    public static BookDto toDto(Book book){
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .publicationYear(book.getPublicationYear())
                .isbn(book.getIsbn())
                .status(book.getStatus())
                .build();
    }
    public static List<BookDto> toListBoobDto(List<Book> books) {
        List<BookDto> bookDtos = new LinkedList<>();
        for (Book book : books) {
            BookDto bookDto = BookDto.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .author(book.getAuthor())
                    .publicationYear(book.getPublicationYear())
                    .isbn(book.getIsbn())
                    .status(book.getStatus())
                    .build();
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }


}
