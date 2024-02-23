package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.AuthorEntity;
import com.infogalaxy.librarymanagementsystem.entity.LibraryMemberEntity;

import java.util.List;
import java.util.Optional;

/***
 * IMemberService Interface is used to Declare the Library Member Functions
 */

public interface IMemberService {

    public LibraryMemberEntity createMember(LibraryMemberEntity libraryMemberEntity);

    public List<LibraryMemberEntity> retrieveAllMember();

    public LibraryMemberEntity updateMemberById(int id, LibraryMemberEntity libraryMemberEntity);

    public Optional<LibraryMemberEntity> retrieveMemberById(int id);

    public String deleteMemberById(int id);

}
