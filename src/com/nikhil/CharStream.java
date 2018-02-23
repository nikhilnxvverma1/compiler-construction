package com.nikhil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikhilverma on 2/14/18.
 */
public class CharStream {
    String filename;
    FileReader reader;
    BufferedReader file;
    char current = ' ';
    boolean eof = false;
    List<Token> tokenList = new ArrayList<>();

    public CharStream(String filename) throws FileNotFoundException {
        this.filename = filename;
        this.reader = new FileReader(this.filename);
        this.file = new BufferedReader(this.reader);
    }

    void next() throws Exception{
        //TODO rough code as described in lecture

        if ( eof ){
            throw new Exception("reading");
//            throw EndOfInput (" reading ") ;
        }

        int c = file . read () ;
        eof = ( c == -1) ;
        current = ( char ) c ;
        System.out.print(this.current);
    }

    void beginReading(){

        String line;
        try {
            while((line = file.readLine()) != null) {
                System.out.println(line);//TODO get rid of this and replace with tokenizing code
                // iterate through this line charecter by charecter
                lexify(line);
            }
            file.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

    private void lexify(String line){
        //appends to the tokenList
    }
}
