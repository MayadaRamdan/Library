package com.Library.book.dto;

import com.Library.book.BookStatus;
import com.Library.book.entity.Book;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long id;
    @NonNull
    @Size(min = 3, message = "Title should contains 3 or more letters")
    @Size(max = 10, message = "Title should contains 10 or less letters")
    private String title;
    @NonNull
    private String author;
    @NonNull
    private String publicationYear;
    @NonNull
    @Pattern(regexp = "[0-9]+" , message = "isbn should contain number only")
    private String isbn;
    private BookStatus status;


}
