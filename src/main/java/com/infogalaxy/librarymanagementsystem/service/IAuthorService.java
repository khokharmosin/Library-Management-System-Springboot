package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.AuthorEntity;

import java.util.List;
import java.util.Optional;

/***
 * IAuthorService Interface is used to Declare the Author Functions
 */

public interface IAuthorService {
    public AuthorEntity createAuthor(AuthorEntity authorEntity);

    public List<AuthorEntity> retrieveAllAuthor();

    public AuthorEntity updateAthorById(int id, AuthorEntity authorEntity);

    public Optional<AuthorEntity> retrieveAuthorById(int id);

    public String deleteAuthorById(int id);
}
