package com.nikhil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nikhilverma on 2/13/18.
 */
public class Lexer {
    TokenType token;
    CharStream ch;

    Map<String,TokenType> keywords = new HashMap<>();

    Lexer(){
        keywords.put("int", TokenType.INT);
        keywords.put("interface", TokenType.INTERFACE);
        keywords.put("void", TokenType.VOID);
        keywords.put("while", TokenType.WHILE);
        keywords.put("if", TokenType.IF);
        keywords.put("else", TokenType.ELSE);
        keywords.put("this", TokenType.THIS);
        keywords.put("new", TokenType.NEW);
        keywords.put("boolean", TokenType.BOOLEAN);
        keywords.put("sidef", TokenType.SIDEF);

    }

    void next() throws Exception {

        //TODO Rough code from lecture slightly edited

//        char c = ch.current;
//        if (Character.isLetter(c)) {
//            StringBuffer b = new
//                    StringBuffer();
//            while (Character.isLetter(c)
//                    || Character.isDigit(c)){
//                b.append(c);
//                ch.next();
//                c = ch.current;
//            }
//        }
//        if (Character.isDigit(c)) {
//            int k = 0;
//            while (Character.isDigit(c)) {
//                k = 10 * k +
//                        Character.getNumericValue(c);
//                ch.next();
//                c = ch.current;
//            }
//            token.kind = INT;
//            token.value = k;
//        }
//        if(!keywords.containsKey(b.toString)){
//            token.kind = ID;
//            token.id = b;
//        }
//        else token.kind = KW;

    }
}
