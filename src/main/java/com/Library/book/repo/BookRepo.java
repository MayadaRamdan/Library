package com.Library.book.repo;

import com.Library.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
    @Query(value = " SELECT u FROM Book u WHERE u.isbn = :isbn and u.status <> 'DELETED'")
    List<Book> findByIsbn(String isbn);


}
