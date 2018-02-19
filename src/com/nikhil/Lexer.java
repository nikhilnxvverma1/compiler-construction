package com.nikhil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nikhilverma on 2/13/18.
 */
public class Lexer {
    Token token;
    CharStream ch;

    Map<String,Token> keywords = new HashMap<>();

    Lexer(){
        keywords.put("int",Token.INT);
        keywords.put("interface",Token.INTERFACE);
        keywords.put("void",Token.VOID);
        keywords.put("while",Token.WHILE);
        keywords.put("if",Token.IF);
        keywords.put("else",Token.ELSE);
        keywords.put("this",Token.THIS);
        keywords.put("new",Token.NEW);
        keywords.put("boolean",Token.BOOLEAN);
        keywords.put("sidef",Token.SIDEF);

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
