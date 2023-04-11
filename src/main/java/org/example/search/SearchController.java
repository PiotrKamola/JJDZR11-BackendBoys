package org.example.search;

import org.example.applicationMenu.AppMenu;

import java.util.ArrayList;

public class SearchController  {

    SearchMenu browseMenu = new SearchMenu();


    public ArrayList<String> browseRecordsByInput(ArrayList<String> records, String input) {
        ArrayList<String> matchingRecords = new ArrayList<String>();

        for (String record : records) {
            if (record.contains(input)) {
                matchingRecords.add(record);
            }
        }

        return matchingRecords;
    }
}
