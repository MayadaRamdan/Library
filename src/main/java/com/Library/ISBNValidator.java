package com.Library;


import com.Library.book.entity.Book;
import com.Library.book.repo.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ISBNValidator {

    private final BookRepo bookRepo;

    public void validate(String isbn) {
        List<Book> books = bookRepo.findByIsbn(isbn);
        if (books != null && !books.isEmpty()) {
            throw new IllegalArgumentException("this isbn already exist");
        }

    }
}
