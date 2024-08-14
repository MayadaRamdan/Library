package com.Library.borrowing.reop;

import com.Library.borrowing.entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowingRepo extends JpaRepository<Borrowing, Long> {
    @Query(value = " SELECT u FROM Borrowing u" +
            " WHERE u.book.id = :bookId AND u.patron.id= :patronId")
    Optional<Borrowing> findByIds(Long bookId, Long patronId);
}
