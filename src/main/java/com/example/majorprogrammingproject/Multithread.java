package com.example.majorprogrammingproject;

public class Multithread implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getId() + " is active");
        } catch (Exception e) {
            System.out.println("Catching Exception");
        }
    }
}

class MultiThreading {
    public static void main(String[] args) {
        int n = 8;
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(new Multithread());
            thread.start();

        }
    }
}
