package com.infogalaxy.librarymanagementsystem.repo;

import com.infogalaxy.librarymanagementsystem.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/***
 * IAuthorRepo Interface is Responsible to Execute the all SQL Query with the help of JpaRepository Method
 */

@Repository
public interface IAuthorRepo extends JpaRepository<AuthorEntity, Integer> {

}
