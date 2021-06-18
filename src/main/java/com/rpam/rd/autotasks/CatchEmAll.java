package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new FileNotFoundException();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    public static void main(String[] args) throws Exception {
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
        }
    }
}