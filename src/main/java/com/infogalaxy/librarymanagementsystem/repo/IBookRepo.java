package com.infogalaxy.librarymanagementsystem.repo;

import com.infogalaxy.librarymanagementsystem.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/***
 * IBookRepo Interface is Responsible to Execute the all SQL Query with the help of JpaRepository Method
 */
@Repository
public interface IBookRepo extends JpaRepository<BookEntity, Integer> {
}
