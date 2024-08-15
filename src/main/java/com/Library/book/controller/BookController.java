package com.Library.book.controller;

import com.Library.book.dto.BookDto;
import com.Library.book.service.BookService;
import com.Library.common.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {


    private final BookService bookService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllBook(){
        List<BookDto> allBooks = bookService.getAllBooks();
        return  ResponseEntity.ok(ApiResponse.ok(allBooks));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getBook(@PathVariable(name = "id") Long bookId){
        BookDto bookDto = bookService.getBook(bookId);
        return ResponseEntity.ok(ApiResponse.ok(bookDto) );
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addBook( @RequestBody @Valid  BookDto bookDto){
        bookService.addBook(bookDto);
        return ResponseEntity.ok(ApiResponse.ok());
    }


    @PutMapping
    public ResponseEntity<ApiResponse> updateBook(@RequestBody @Valid  BookDto bookDto){
        bookService.updateBook(bookDto);
        return ResponseEntity.ok(ApiResponse.ok());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteBook(@PathVariable("id") long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok(ApiResponse.ok());

    }
}
