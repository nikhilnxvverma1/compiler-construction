package com.nikhil;

/**
 * Created by nikhilverma on 3/2/18.
 */
public class Arguments {

    boolean lex=true;
    String filename="BinarySearch.emj";

    public Arguments(String args[]) {

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
