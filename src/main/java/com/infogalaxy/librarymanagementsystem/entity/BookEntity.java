package com.infogalaxy.librarymanagementsystem.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/***
 * Interacting Book Entity Class to the Database with bookentity Table
 */
@Data
@Entity
@Table(name = "bookentity")
public class BookEntity {

    @Id
    private int bookid;
    @NotBlank(message = "Please Enter the Book Title")
    private String booktitle;
    @NotBlank(message = "Please Enter the Book Author Name")
    private String bookauthorname;
   // @NotBlank(message = "Please Enter the Book Price")
    private int bookprice;
    @NotBlank(message = "Please Enter the Book ISBN Number")
    private String bookisbn;
    //@NotBlank(message = "Please Enter the Book Publish Year")
    private int bookpublishyear;


    //private String Category;
}
