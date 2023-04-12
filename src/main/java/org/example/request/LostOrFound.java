package org.example.request;

public enum LostOrFound {
    LOST("Lost"),
    FOUND("Found");

    private final String lostOrFoundString;
    LostOrFound(String lostOrFoundString){
        this.lostOrFoundString = lostOrFoundString;
    }

    protected String getLostOrFoundString(){
        return lostOrFoundString;
    }
    
    protected static String showOptions(){
        StringBuilder strBuilder = new StringBuilder();
        for(LostOrFound option : LostOrFound.values()){
            strBuilder.append(option.ordinal() +". "+ option.getLostOrFoundString()+"\n");
        }
        return strBuilder.toString();
    }
}
