package org.example;

public class Main {
    public static void main(String[] args) {
        Request request1 = new Request();
        Request request2 = new Request();

        System.out.println("\n\nRequest 1:");
        Request.printRequest(request1);

        System.out.println("\nRequest 2:");
        Request.printRequest(request2);
    }
}