package com.github.mbritzke.exception;

public class EmptyAddressException extends RuntimeException{

    public EmptyAddressException(){
        super("Address not found");
    }
}
