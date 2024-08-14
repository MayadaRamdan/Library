package com.Library.admin.repo;

import com.Library.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

//    @Query(value = " SELECT u FROM Admin u WHERE u.name = :name")
//   Admin findByName(String name);


    @Query(value = " SELECT u FROM Admin u WHERE u.email = :email ")
    Admin findByEmail(String email);


}
