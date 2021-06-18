package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new FileNotFoundException();
    static Exception exception_1 = new IOException();
    static Exception exception_2 = new ArithmeticException();
    static Exception exception_3 = new NumberFormatException();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    public static void main(String[] args) throws Exception {
        try {
            throw exception_1;
        } catch(IOException ioException){
            try{
                riskyMethod();
            } catch(FileNotFoundException fileNotFoundException){
                try{
                    throw new IllegalArgumentException("Resource is missing");
                } catch (IllegalArgumentException illegalArgumentException){
                    try{
                        throw new ArithmeticException("System.err");
                    } catch(ArithmeticException arithmeticException){
                        throw  new NumberFormatException("System.err");

                    }
                }
            }
        }
    }
}
