package com.Library.book.service;

import com.Library.ISBNValidator;
import com.Library.book.BookStatus;
import com.Library.book.dto.BookDto;
import com.Library.book.entity.Book;
import com.Library.book.mapper.BookMapping;
import com.Library.exceptions.BookNotFoundException;
import com.Library.book.repo.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final ISBNValidator isbnValidator;

    private final BookRepo bookRepo ;


    @Transactional(readOnly = true)
    public List<BookDto> getAllBooks(){

        List<Book> books =bookRepo.findAll();
        List<BookDto> bookDtos =BookMapping.toListBoobDto(books);
        return bookDtos;

    }

    @Transactional(readOnly = true)
    public BookDto getBook(long id){

        Optional<Book> byId = bookRepo.findById(id);
        if( byId.isPresent()){
            return BookMapping.toDto(byId.get());
        }else {
            throw new BookNotFoundException("no Book with this id");
        }
    }


    @Transactional
    public void addBook( BookDto bookDto){
        isbnValidator.validate(bookDto.getIsbn());
        Book book= BookMapping.toBook(bookDto);

        bookRepo.save(book);
    }

    @Transactional
    public void updateBook( BookDto bookDto){
       Book book= BookMapping.toBook(bookDto);
        bookRepo.save(book);
    }

    @Transactional
    public void deleteBook( long id){

        Optional<Book> byId = bookRepo.findById(id);
        if( byId.isPresent()){
            Book book = byId.get();
            book.setStatus(BookStatus.DELETED);
            bookRepo.save(book);
        }else {
            throw new BookNotFoundException("no Book with this id");
        }

    }



}
