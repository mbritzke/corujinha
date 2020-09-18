package com.github.mbritzke.exception;

public class EmptyKeyWordException extends RuntimeException{

    public EmptyKeyWordException() {
        super("keyword not found");
    }
}
