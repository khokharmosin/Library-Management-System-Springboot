package com.infogalaxy.librarymanagementsystem.controller;
import com.infogalaxy.librarymanagementsystem.entity.LibraryMemberEntity;
import com.infogalaxy.librarymanagementsystem.responses.GlobalResponses;
import com.infogalaxy.librarymanagementsystem.service.IMemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/api/member")
public class LibraryMemberController {

    /***
     * To Create Object of Member Service Interface
     */
    @Autowired
    IMemberService iMemberService;

    /***
     *
     * @return String - Welcome to library Member API
     */
    @GetMapping("/home")
    public String librarymember() {
        return "Welcome to Library Member API";
    }

    /***
     * API to create Member Data in Database
     * @param libraryMemberEntity - Object of LibraryMemberEntity
     * @return GlobalResponse - Custom Response object with response data
     */
    @PostMapping("/createmember")
    public ResponseEntity<?> createMember(@RequestBody @Valid LibraryMemberEntity libraryMemberEntity) {
        return new ResponseEntity<>(new GlobalResponses("New Member Added Successfully",HttpStatus.CREATED,iMemberService.createMember(libraryMemberEntity)),HttpStatus.CREATED);
    }

    /***
     * API to retrieve all member data in Database
     * @return GlobalResponse - Custom Response object with response data
     */
    @GetMapping("/retrievemember")
    public ResponseEntity<?> retrieveMember(){
        return new ResponseEntity<>(new GlobalResponses("All Members Data Found",HttpStatus.FOUND,iMemberService.retrieveAllMember()),HttpStatus.FOUND);
    }


    /***
     * API to Update existing member data in database with the help of member ID
     * @param id - Find the Member Data By the given ID
     * @param libraryMemberEntity - Object of LibraryMemberEntity
     * @return GlobalResponse - Custom Response object with response data
     */
    @PutMapping("/updatememberbyid/{id}")
    public ResponseEntity<?> updateMemberById(@PathVariable ("id") int id, @RequestBody LibraryMemberEntity libraryMemberEntity ){
    return new ResponseEntity<>(new GlobalResponses("Member Data Are Update",HttpStatus.ACCEPTED,iMemberService.updateMemberById(id,libraryMemberEntity)),HttpStatus.ACCEPTED);
    }

    /***
     * API to Retrieve the existing Member Data from Database with the help of Member ID
     * @param id - Find the Member Data By the given ID
     * @return GlobalResponse - Custom Response object with response data
     */
    @GetMapping("/retrievememberbyid/{id}")
    public ResponseEntity<?> retrieveMemberById(@PathVariable ("id") int id) {
    return new ResponseEntity<>(new GlobalResponses("Member data Found by id",HttpStatus.FOUND,iMemberService.retrieveMemberById(id)),HttpStatus.FOUND);
    }


    /***
     * API to Delete existing Member Data from Database with the help of Member ID
     * @param id - Find the Member Data By the given ID
     * @return GlobalResponse - Custom Response object with response data
     */
    @DeleteMapping("/deletememberbyid/{id}")
    public ResponseEntity<?> deleteMemberById(@PathVariable("id")int id){
        return new ResponseEntity<>(new GlobalResponses("Member Data Deleted...",HttpStatus.ACCEPTED,iMemberService.deleteMemberById(id)),HttpStatus.ACCEPTED);

    }
}
