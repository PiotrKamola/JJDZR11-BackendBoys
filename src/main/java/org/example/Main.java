package org.example;

public class Main {

    public static void main(String[] args) {
        BrowseByInput browse = new BrowseByInput();

        // call displayAll() to print all records
        browse.displayAll();

        // call browseRecords() to search for records
        browse.browseRecords();
    }
}