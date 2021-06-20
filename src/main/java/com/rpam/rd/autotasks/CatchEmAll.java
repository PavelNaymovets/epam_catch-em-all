package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new IndexOutOfBoundsException("ioobe");

    public static void main(String[] args) throws Exception {
        try {
            try {
                riskyMethod();
            } catch(FileNotFoundException fileNotFoundException){
                throw new IllegalArgumentException("Resource is missing", fileNotFoundException);
            } catch(ArithmeticException | NumberFormatException total){
                System.err.println(total.getMessage());
            }
        } catch (IOException ioException){
            throw new IllegalArgumentException("Resource error", ioException);
        }
    }

    public static void riskyMethod() throws Exception {
        throw exception;
    }
}

/*
try{
        riskyMethod();
        } catch(Exception e){
        if(e instanceof FileNotFoundException){
        throw new IllegalArgumentException("Resource is missing");
        } else if((e instanceof ArithmeticException) || (e instanceof NumberFormatException)){
        System.setErr(System.err);
        } else if(e instanceof IOException){
        throw new IllegalArgumentException("Resource error");
        }
        }*/
