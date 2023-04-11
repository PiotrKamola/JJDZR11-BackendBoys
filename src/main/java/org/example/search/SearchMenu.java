package org.example.search;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchMenu {


    public void printOptions() {
        System.out.println("1. Search by city\n2. Back to MENU");
    }


    // instance variable to hold the records
    private ArrayList<String> records;

    // constructor to initialize the records
    public SearchMenu() {
        records = new ArrayList<String>();
        records.add("John Smith, 123 Main St., Anytown, USA");
        records.add("Jane Doe, 456 Maple Rd., Somewhere, USA");
        records.add("Bob Johnson, 789 Elm Ave., Nowhere, USA");
    }

    // method to browse the records for a matching input
    public ArrayList<String> browseRecordsByInput(ArrayList<String> records, String input) {
        ArrayList<String> matchingRecords = new ArrayList<String>();

        for (String record : records) {
            if (record.contains(input)) {
                matchingRecords.add(record);
            }
        }

        return matchingRecords;
    }

    // method to browse the records based on user input
    public void browseRecords() {
        // create a Scanner to get the search input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter search input: ");
        String searchInput = scanner.nextLine();

        // browse the records for a matching input
        ArrayList<String> matchingRecords = browseRecordsByInput(records, searchInput);

        // print out the matching records
        System.out.println("Matching records:");
        for (String matchingRecord : matchingRecords) {
            System.out.println(matchingRecord);
        }

        // close the scanner
        scanner.close();
    }

    // method to display all records
    public void displayAll() {
        // print all existing records
        for (String record : records) {
            System.out.println(record);
        }
    }
}