package com.nikhil;

/**
 * Created by nikhilverma on 2/26/18.
 */
public class EndOfInput extends Exception{

    String message;

    EndOfInput(String message){
        this.message = message;
    }

    String message(){
        return "Input has ended with message:"+this.getMessage();
    }
}
