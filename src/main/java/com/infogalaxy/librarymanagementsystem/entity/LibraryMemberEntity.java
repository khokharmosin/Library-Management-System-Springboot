package com.infogalaxy.librarymanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


/***
 * Interacting Library Member Entity Class to the Database with librarymemberentity Table
 */
@Data
@Entity
@Table(name = "librarymemberentity")
public class LibraryMemberEntity {

    @Id
    private int memberid;
    @NotBlank(message = "Please Enter The MemberName...")
    private String membername;

    private int membermbno;
    @Email(message = "Please Enter The Valid Email_ID...")
    private String memberemail;
    @NotBlank(message = "Please Enter City Name...")
    private String membercity;
}
