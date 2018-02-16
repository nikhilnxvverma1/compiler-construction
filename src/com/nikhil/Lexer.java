package com.nikhil;

/**
 * Created by nikhilverma on 2/13/18.
 */
public class Lexer {
    Token token;
    CharStream ch;
    void next() throws Exception {

        //TODO Rough code from lecture slightly edited

        char c = ch.current;
        if (Character.isLetter(c)) {
            StringBuffer b = new
                    StringBuffer();
            while (Character.isLetter(c)
                    || Character.isDigit(c)){
                b.append(c);
                ch.next();
                c = ch.current;
            }
        }
        if (Character.isDigit(c)) {
            int k = 0;
            while (Character.isDigit(c)) {
                k = 10 * k +
                        Character.getNumericValue(c);
                ch.next();
                c = ch.current;
            }
            token.kind = INT;
            token.value = k;
        }
        if(!keywords.containsKey(b.toString)){
            token.kind = ID;
            token.id = b;
        }
        else token.kind = KW;

    }
}
