package com.infogalaxy.librarymanagementsystem.controller;

import com.infogalaxy.librarymanagementsystem.entity.BookEntity;
import com.infogalaxy.librarymanagementsystem.responses.GlobalResponses;
import com.infogalaxy.librarymanagementsystem.service.IBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/book")
public class BookController {

    /***
     * To Create Object of Book Service Interface
     */
    @Autowired
    IBookService iBookService;

    /***
     *
     * @return String - Welcome to Book API
     */
    @GetMapping("/home")
    public String Book(){
        return "Welcome To Book API...";
    }

    /***
     * API to Create Book Data in Database
     * @param bookEntity - Object of BookEntity
     * @return GlobalResponse - Custom Response object with response data
     */
    @PostMapping("/createbook")
    public ResponseEntity<?> createBook(@RequestBody @Valid BookEntity bookEntity){
        return new ResponseEntity<>(new GlobalResponses("New Book Added Successfully", HttpStatus.CREATED, iBookService.createBook(bookEntity)), HttpStatus.CREATED);
    }

    /***
     * API to Retrieve all Book Data in Database
     * @return GlobalResponse - Custom Response object with response data
     */
    @GetMapping("retrieveallbook")
    public ResponseEntity<?> retrieveAllBook(){
        return new ResponseEntity<>(new GlobalResponses("All Book Data Found", HttpStatus.FOUND, iBookService.retrieveAllBook()), HttpStatus.FOUND);
    }

    /***
     * API to Retrieve the existing Book Data from Database with the help of Book ID
     * @param id - Find the Book Data By the given ID
     * @return GlobalResponse - Custom Response object with response data
     */
    @GetMapping("/retrievebookbyid/{id}")
    public ResponseEntity<?> retrieveBookById(@PathVariable ("id") int id){
        return new ResponseEntity<>(new GlobalResponses("Book Data Found By Id", HttpStatus.FOUND, iBookService.retrieveBookById(id)), HttpStatus.FOUND);
    }

    /***
     * API to Update existing Book data in database with the help of Book ID
     * @param id - Find the Book Data By the given ID
     * @param bookEntity - Object of BookEntity
     * @return GlobalResponse - Custom Response object with response data
     */
    @PutMapping("/updatebookbyid/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable ("id") int id, @RequestBody BookEntity bookEntity) {
        return new ResponseEntity<>(new GlobalResponses("Book Data Updated By Id", HttpStatus.ACCEPTED, iBookService.updateBookById(id,bookEntity)), HttpStatus.ACCEPTED);
    }

    /***
     * API to Delete existing Book Data from Database with the help of Book ID
     * @param id - Find the Book Data By the given ID
     * @return GlobalResponse - Custom Response object with response data
     */
    @DeleteMapping("/deletebookbyid/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(new GlobalResponses("Book Data Deleted Successfully", HttpStatus.ACCEPTED, iBookService.deleteBookById(id)),HttpStatus.ACCEPTED);
    }
}
