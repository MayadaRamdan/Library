package com.Library.book.entity;

import com.Library.book.BookStatus;
import jakarta.persistence.*;
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
