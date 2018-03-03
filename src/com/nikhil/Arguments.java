package com.nikhil;

/**
 * Created by nikhilverma on 3/2/18.
 */
public class Arguments {

    boolean lex=true;
    String filename;

    public Arguments(String args[]) {

        filename="/Users/nikhilverma/Desktop/lexer/src/com/nikhil/BinarySearch.emj";

        if(args.length==0){
            System.out.println("Please give source file");
        }else if(args.length==1){
            filename=args[0];
        }else{
//            option=args[0];
            filename=args[1];
        }
    }
}
