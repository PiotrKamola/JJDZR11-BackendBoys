package pl.isa.backendBoys.zgubaAppWeb.rest;

public class searchHelp {
    private String searchWord = new String();
    private String searchCity = new String();
    private String searchDescription = new String();
    private String searchLostOrFound = new String();
    private String searchName = new String();

    public String getSearchCity() {
        return searchCity;
    }

    public void setSearchCity(String searchCity) {
        this.searchCity = searchCity;
    }

    public String getSearchDescription() {
        return searchDescription;
    }

    public void setSearchDescription(String searchDescription) {
        this.searchDescription = searchDescription;
    }

    public String getSearchLostOrFound() {
        return searchLostOrFound;
    }

    public void setSearchLostOrFound(String searchLostOrFound) {
        this.searchLostOrFound = searchLostOrFound;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }
}
