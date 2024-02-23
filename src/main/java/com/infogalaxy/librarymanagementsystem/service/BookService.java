package com.infogalaxy.librarymanagementsystem.service;

import com.infogalaxy.librarymanagementsystem.entity.BookEntity;
import com.infogalaxy.librarymanagementsystem.exceptions.MemberNotFoundException;
import com.infogalaxy.librarymanagementsystem.repo.IBookRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService implements IBookService{

    /***
     * To Create Object of Book Repo Interface
     */
    @Autowired
    IBookRepo iBookRepo;

    /***
     * Method to Add New Book Data in Database
     * @param bookEntity - Object of BookEntity
     * @return libraryMemberEntity - Object of BookEntity(Book)
     */
    @Override
    public BookEntity createBook(BookEntity bookEntity) {
       iBookRepo.save(bookEntity) ;
       return bookEntity;
    }

    /***
     * Method to Retrieve All Books Data From Database
     * @return List - List of BookEntity Objects
     */
    @Override
    public List<BookEntity> retrieveAllBook() {
        return iBookRepo.findAll();
    }

    /***
     * Method to Retrieve Book Data From Database with the help of Book ID
     * @param id - Find the Book Data By the given ID
     * @return bookEntity - BookEntity Object with the help of Book ID
     */
    @Override
    public Optional<BookEntity> retrieveBookById(int id) {
        Optional<BookEntity> bookEntity = iBookRepo.findById(id);

        if(bookEntity.isPresent()){
            return bookEntity;
        } else {
            throw new MemberNotFoundException("Author with Given ID is not found in database");
        }
    }

    /***
     * Method to Update existing Book data with the help of Book ID
     * @param id - Access the Book Data from given Database
     * @param bookEntity - Object of BookEntity
     * @return bookEntityNew - Object of New Updated Data
     */
    @Override
    public BookEntity updateBookById(int id, BookEntity bookEntity) {
        Optional<BookEntity> bookEntityNew = iBookRepo.findById(id);

        if(bookEntityNew.isPresent()){
            BeanUtils.copyProperties(bookEntity,bookEntityNew);
            return iBookRepo.save(bookEntity);
        } else {
            throw new MemberNotFoundException("Author with Given ID is not found in database");
        }

    }

    /***
     * Method to Delete existing Book Data with the help of Book ID
     * @param id - Access the Book Data from Database
     * @return String - Display the Delete Successfully message
     */
    @Override
    public String deleteBookById(int id) {
        Optional<BookEntity> bookEntity= iBookRepo.findById(id);
        if(bookEntity.isPresent()){
            iBookRepo.deleteById(id);

            return "Book Deleted Successfully";
        } else {
            throw new MemberNotFoundException("Author with Given ID is not found in database");
        }
    }

//    public List<BookEntity> retrieveBookByCategory(String category) {
//
//        List<BookEntity> bookEntities = new ArrayList<>();
//        BookEntity bookEntity = new BookEntity();
//        for (int i = 0; i < 10; i++) {
//            if (category.equalsIgnoreCase(bookEntity.getBooktitle())) {
//
//                return bookEntities = iBookRepo.
//            }
//        }
//
//    }

}
