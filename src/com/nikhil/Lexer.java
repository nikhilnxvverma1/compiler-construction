package com.nikhil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Identifies tokens in for a string
 * Created by nikhilverma on 2/13/18.
 */
public class Lexer {
    TokenType token;
    CharStream ch;
    private Map<String,TokenType> keywords = new HashMap<>();
    List<Token> tokenList = new ArrayList<>();

    Lexer(CharStream ch){
        this.ch = ch;
    }

    void beginReading(){

        String line;// TODO unused get rid of it if not needed
        int row=1;// in the question it is expected to start from one
        try {
            char c;
            while(!ch.eof) {
                ch.next();
                // iterate through this line character by character
//                lexify(line,row++);
                lexify(ch.current);
                printToFile("output");
            }
        }
        catch(EndOfInput ex) {
            System.out.println(ex.getMessage());
        }
        catch(IOException ex) {

            System.out.println("Error: file read"+ex.getMessage());
        }


    }

    public void lexify(char c){
        // TODO
        // get a charecter from the charachter stream
        // keep track of the last letter scanned
        // build up the current lexeme

        while(!ch.eof){
            char current = ch.current;

            try{
                ch.next();
            }catch (EndOfInput eoi){
                System.out.println("End of input reached");
            }catch (IOException ioe){
                System.out.println("Error reading file "+ioe.getMessage());
            }

        }
    }

    public void lexify(String line,int row){// TODO remove and use above prototype
        //appends to the tokenList
        int length = line.length();
        Token token=null;
        int originalColumn;
        StringBuilder keywordSoFar = new StringBuilder();

        for(int i=0;i<length;i++) {
            char c = line.charAt(i);
            originalColumn=c;
            keywordSoFar.append(c);
            TokenType tokenType = this.keywords.get(keywordSoFar.toString());
            if(tokenType!=null){
                token = new Token();
                token.tokenType = tokenType;
                keywordSoFar = new StringBuilder();
            }else if(Character.isLetter(c))

            // to avoid interfearance with keyword so far above we reset the keywordSoFar later
            //alphanumeric id
            {
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
                token.id = alphanumericId.toString();

                //reset keyword so far string builder
                keywordSoFar = new StringBuilder();
            }else if (Character.isDigit(c)) {

                //number
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
            }

            if(token!=null){
                token.row = row;
                token.col = originalColumn;
                tokenList.add(token);
            }

        }
    }

    private void printToFile(String outputFile){

        for(Token token :tokenList){
            String line = token.row+":"+token.col+" "+token.tokenType;
//            System.out.println(line);
        }
    }
}
