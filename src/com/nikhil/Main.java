package com.nikhil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Arguments arguments = new Arguments(args);

        try{
            CharStream charStream = new CharStream(arguments.filename);
            Lexer lexer = new Lexer(charStream);


        }catch (FileNotFoundException ex){
            System.out.println("Cannot find file "+arguments.filename);
        }

        // TODO use Lexer class here
    }
}
