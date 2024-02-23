package com.infogalaxy.librarymanagementsystem.controller;

import com.infogalaxy.librarymanagementsystem.entity.AuthorEntity;
import com.infogalaxy.librarymanagementsystem.responses.GlobalResponses;
import com.infogalaxy.librarymanagementsystem.service.IAuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    /***
     * To Create Object of Author Service Interface
     */
    @Autowired
    IAuthorService iAuthorService;

    /***
     *
     * @return String - Welcome to Author API
     */
    @GetMapping("/home")
    public String author(){
        return "Welcome to Author API";
    }

    /***
     * API to Create Author Data in Database
     * @param authorEntity - Object of AuthorEntity
     * @return GlobalResponse - Custom Response object with response data
     */
    @PostMapping("/createauthor")
    public ResponseEntity<?> createAuthor(@RequestBody @Valid AuthorEntity authorEntity) {
        return new ResponseEntity<>(new GlobalResponses("New Author Added Successfully", HttpStatus.CREATED,iAuthorService.createAuthor(authorEntity)),HttpStatus.CREATED);
    }

    /***
     * API to Retrieve all Author Data in Database
     * @return GlobalResponse - Custom Response object with response data
     */
    @GetMapping("/retrieveallauthor")
    public ResponseEntity<?> retrieveAllAuthor(){
        return new ResponseEntity<>(new GlobalResponses("All Author Data Found", HttpStatus.FOUND, iAuthorService.retrieveAllAuthor()), HttpStatus.FOUND);
    }

    /***
     * API to Update existing Author data in database with the help of Author ID
     * @param id - Find the Author Data By the given ID
     * @param authorEntity - Object of AuthorEntity
     * @return GlobalResponse - Custom Response object with response data
     */
    @PutMapping("/updateauthorbyid/{id}")
    public ResponseEntity<?> updateAuthorById(@PathVariable ("id") int id, @RequestBody AuthorEntity authorEntity){
        return new ResponseEntity<>(new GlobalResponses("Author Data Updated Sccuessfully...", HttpStatus.ACCEPTED, iAuthorService.updateAthorById(id,authorEntity)), HttpStatus.ACCEPTED);
    }

    /***
     * API to Retrieve the existing Author Data from Database with the help of Author ID
     * @param id - Find the Author Data By the given ID
     * @return GlobalResponse - Custom Response object with response data
     */
    @GetMapping("/retrieveauthorbyid/{id}")
    public ResponseEntity<?> retrieveAuthorById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(new GlobalResponses("Author Data Found By Id", HttpStatus.FOUND, iAuthorService.retrieveAuthorById(id)), HttpStatus.FOUND);
    }

    /***
     * API to Delete existing Author Data from Database with the help of Author ID
     * @param id - Find the Author Data By the given ID
     * @return GlobalResponse - Custom Response object with response data
     */
    @DeleteMapping("/deleteauthorbyid/{id}")
    public ResponseEntity<?> deleteAuthorById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(new GlobalResponses("Author Data Deleted Successfully...", HttpStatus.ACCEPTED, iAuthorService.deleteAuthorById(id)), HttpStatus.ACCEPTED);

    }
}
