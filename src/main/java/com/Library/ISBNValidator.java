package com.Library;

import com.Library.book.dto.BookDto;
import com.Library.book.entity.Book;
import com.Library.book.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ISBNValidator {
    @Autowired
    BookRepo bookRepo;
    public void validate(String isbn)  {
       List<Book> book= bookRepo.findByIsbn(isbn);
        if ( book!=null){
            throw new IllegalArgumentException("this isbn already exist");
        }

    }
}
