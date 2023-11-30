package com.example.majorprogrammingproject;

public class MyLinkedListException extends Exception{
    public MyLinkedListException(int index) {
        super("Error! Index out of bounds!" + index);
    }

    public MyLinkedListException(String message, int i) {
        super(message + i);
    }
}
