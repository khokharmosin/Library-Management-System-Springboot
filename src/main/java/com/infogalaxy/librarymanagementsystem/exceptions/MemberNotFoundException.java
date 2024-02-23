package com.infogalaxy.librarymanagementsystem.exceptions;



public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException(String massage){
        super(massage);
    }
}
