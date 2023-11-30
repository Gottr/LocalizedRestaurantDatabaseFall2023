package com.example.majorprogrammingproject;

public class MyNode {
    protected Restaurant item;
    protected MyNode next;

    MyNode(Restaurant item){
        this.item = item;
        this.next = null;
    }

    MyNode(Restaurant item, MyNode next){
        this.item = item;
        this.next = next;
    }

}
