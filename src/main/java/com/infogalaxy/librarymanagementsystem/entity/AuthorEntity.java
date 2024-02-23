package com.infogalaxy.librarymanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/***
 * Interacting Author Entity Class to the Database with authorentity Table
 */

@Entity
@Data
@Table(name = "authorentity")
public class AuthorEntity {

    @Id
    private int authorid;
    @NotBlank(message = "Please Enter the Author Name...")
    private String authorname;
    @NotBlank(message = "Please Enter the Author Country...")
    private  String authorcountry;




}
