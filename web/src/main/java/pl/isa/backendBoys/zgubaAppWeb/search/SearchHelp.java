package pl.isa.backendBoys.zgubaAppWeb.search;

public class SearchHelp {
    private String searchWord = "";
    private String searchCity = "";
    private String searchDescription = "";
    private String searchLostOrFound = "";
    private String searchName = "";

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
