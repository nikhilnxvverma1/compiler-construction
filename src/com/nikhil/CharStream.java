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
//            throw new Exception("reading");
            throw new EndOfInput(" reading ");
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
                // iterate through this line character by character
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
        int length = line.length();
        for(int i=0;i<length;i++) {
            char c = line.charAt(i);
            if (Character.isLetter(c)) {
                StringBuffer b = new StringBuffer();
                while (Character.isLetter(c) || Character.isDigit(c)) {
                    b.append(c);
                    //                ch.next();
                    //                c = ch.current;
                }
                Token token = new Token();
                token.tokenType = TokenType.ID;
            }
            if (Character.isDigit(c)) {
                int k = 0;
                while (Character.isDigit(c)) {
                    k = 10 * k +
                            Character.getNumericValue(c);
                    //                ch.next();
                    //                c = ch.current;
                }
                Token token = new Token();
                token.tokenType = TokenType.INT;
                token.value = k;
            }else{
                Token token = new Token();
                token.tokenType = TokenType.KEYWORD;
                token.value = c;// TODO look ahead upto the end
            }

        }
//        if(!keywords.containsKey(b.toString)){
//            token.kind = ID;
//            token.id = b;
//        }
//        else token.kind = KW;
//        }
    }
}
