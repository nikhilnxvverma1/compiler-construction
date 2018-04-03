package com.nikhil;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        Arguments arguments = new Arguments(args);

        try{
            CharStream charStream = new CharStream(arguments.filename);
            Lexer lexer = new Lexer(charStream);
            lexer.beginReading();
            //TODO refactor

        }catch (FileNotFoundException ex){
            System.out.println("Cannot find file "+arguments.filename);
        }

    }
}
