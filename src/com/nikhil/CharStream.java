package com.nikhil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<String,TokenType> keywords = new HashMap<>();

    public CharStream(String filename) throws FileNotFoundException {
        this.filename = filename;
        this.reader = new FileReader(this.filename);
        this.file = new BufferedReader(this.reader);
        this.insertKeywords();
    }

    private void insertKeywords(){
        this.keywords.put("while",TokenType.WHILE);
        this.keywords.put("if",TokenType.IF);
        this.keywords.put("else",TokenType.ELSE);
        this.keywords.put("=",TokenType.ASSIGN_EQ);
        this.keywords.put("{",TokenType.LPAREN);
        this.keywords.put("}",TokenType.RPAREN);
        this.keywords.put(";",TokenType.SEMICOLON);
        this.keywords.put("*",TokenType.MUL);
        this.keywords.put("/",TokenType.DIV);
        this.keywords.put("+",TokenType.PLUS);
        this.keywords.put("-",TokenType.MINUS);
        this.keywords.put("==",TokenType.COMPARE_EQ);
        this.keywords.put("<=",TokenType.LESS_THAN_EQUAL_TO);
        this.keywords.put("<",TokenType.LESS_THAN);
        this.keywords.put(">=",TokenType.GREATER_THAN_EQUAL_TO);
        this.keywords.put(">",TokenType.GREATER_THAN);
        this.keywords.put("==",TokenType.COMPARE_EQ);
        this.keywords.put(".",TokenType.DOT);
        this.keywords.put("void",TokenType.VOID);
        this.keywords.put("interface",TokenType.INTERFACE);
        this.keywords.put("int",TokenType.INT);
        this.keywords.put("new",TokenType.NEW);
        this.keywords.put("this",TokenType.THIS);
        this.keywords.put("bool",TokenType.BOOLEAN);

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

        printToFile(this.outputFileName);
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

                // TODO handle the case for floating point numbers

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
        // TODO print whatever exists in the token list to the file

        for(Token token :tokenList){
            String line = token.row+":"+token.col+" "+token.tokenType;
            System.out.println(line);
        }
    }
}
