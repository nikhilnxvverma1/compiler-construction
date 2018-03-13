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
    private String outputFileName;

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
        int row=1;// in the question it is expected to start from one
        try {
            while((line = file.readLine()) != null) {
                System.out.println(line);//TODO get rid of this and replace with tokenizing code
                // iterate through this line character by character
                lexify(line,row++);
                printToFile("output");
            }
            file.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());

        }

        printToFile("outputFile");
    }

    private void lexify(String line,int row){
        //appends to the tokenList
        int length = line.length();
        Token token;
        int originalColumn;

        for(int i=0;i<length;i++) {
            char c = line.charAt(i);
            originalColumn=c;

            //alphanumeric id
            if (Character.isLetter(c)) {
                StringBuffer alphanumericId = new StringBuffer();
                while (Character.isLetter(c) || Character.isDigit(c)) {
                    alphanumericId.append(c);
                    if(i+1<length){
                        i++;
                        c=line.charAt(i);
                    }
                }
                token = new Token();
                token.tokenType = TokenType.ID;
            }

            //number
            if (Character.isDigit(c)) {
                int k = 0;
                while (Character.isDigit(c)) {
                    k = 10 * k + Character.getNumericValue(c);

                    if(i+1<length){
                        i++;
                        c=line.charAt(i);
                    }

                }
                token = new Token();
                token.tokenType = TokenType.INT;
                token.value = k;
            }else{
                token = new Token();
                token.tokenType = TokenType.KEYWORD;
                token.value = c;// TODO look ahead upto the end
            }

            if(token!=null){
                token.row = row;
                token.col = originalColumn;
                tokenList.add(token);
//                System.out.println(token.toString());
            }

        }
//        if(!keywords.containsKey(b.toString)){
//            token.kind = ID;
//            token.id = b;
//        }
//        else token.kind = KW;
//        }
    }

    private void printToFile(String outputFile){
        // TODO print whatever exists in the token list to the file

        for(Token token :tokenList){
            String line = token.row+":"+token.col+" "+token.tokenType;
            System.out.println(line);
        }
    }
}
