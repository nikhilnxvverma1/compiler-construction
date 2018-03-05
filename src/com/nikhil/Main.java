package com.nikhil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Arguments arguments = new Arguments(args);

        try{
            CharStream charStream = new CharStream(arguments.filename);
            charStream.beginReading();
        }catch (FileNotFoundException ex){
            //TODO
        }



        //TODO send the filename to respective operation class
        //TODO the following code is only for reference purposes

        // This will reference one line at a time
//        String line = null;
//
//        try {
//            // FileReader reads text files in the default encoding.
//            FileReader fileReader = new FileReader(filename);
//
//            // Always wrap FileReader in BufferedReader.
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            // Always close files.
//            bufferedReader.close();
//        }
//        catch(FileNotFoundException ex) {
//            System.out.println(
//                    "Unable to open file '" +
//                            filename + "'"+ex.getMessage());
//        }
//        catch(IOException ex) {
//            System.out.println(
//                    "Error reading file '"
//                            + filename + "'");
//            // Or we could just do this:
//            // ex.printStackTrace();
//        }
    }
}
