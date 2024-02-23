package com.infogalaxy.librarymanagementsystem.responses;

import lombok.Data;
import org.springframework.http.HttpStatus;


/***
 * GlobalResponses Class is Responsible to Custom Response object with response data
 */
@Data
public class GlobalResponses {

    private String massage;

    private HttpStatus code;

    private Object object;

    public GlobalResponses(String massage){
        this.massage = massage;
    }

    public GlobalResponses(String massage, HttpStatus code){
        this.massage = massage;
        this.code = code;
    }

    public GlobalResponses(String massage, HttpStatus code, Object object){
        this.massage = massage;
        this.code = code;
        this.object = object;
    }
}
