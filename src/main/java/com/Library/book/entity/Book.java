package com.Library.book.entity;

import com.Library.book.dto.BookDto;
import com.Library.book.BookStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String title ;

    private String author ;

    private String publicationYear ;

    private String isbn;

    @Enumerated(EnumType.STRING)
    private BookStatus status;



}
