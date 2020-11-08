package com.github.mbritzke.exception;

public class EmptyKeyWordException extends RuntimeException{

    public EmptyKeyWordException() {
        super("Keyword not found");
    }
}
