package com.nikhil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nikhilverma on 2/13/18.
 */
public class Lexer {
    TokenType token;
    CharStream ch;
    private Map<String,TokenType> keywords = new HashMap<>();
    List<Token> tokenList = new ArrayList<>();

    void next() throws Exception {

//        String line;
//        int row=1;// in the question it is expected to start from one
//        try {
//            while(ch.next();) != null) {
//                System.out.println(line);
//                // iterate through this line character by character
//                lexify(line,row++);
//                printToFile("output");
//            }
//            file.close();
//        }
//        catch(FileNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//        catch(IOException ex) {
//            System.out.println(ex.getMessage());
//
//        }
//
//        printToFile(this.outputFileName);


    }

    private void lexify(String line,int row){
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
}
