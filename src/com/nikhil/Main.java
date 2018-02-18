package com.nikhil;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String option;
        String filename;

        if(args.length==0){
            System.out.println("Please give source file");
        }else if(args.length==1){
            filename=args[0];
            option="--lex";//default
        }else{
            option=args[0];
            filename=args[1];
        }

        //TODO send the filename to respective operation class
    }
}
