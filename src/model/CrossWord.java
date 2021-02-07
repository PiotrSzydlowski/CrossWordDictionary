package model;

public class CrossWord {
    private String crossword;
    private String description;



    public CrossWord(String crossword, String description) {
        this.crossword = crossword;
        this.description = description;
    }

    public String getCrossword() {
        return crossword;
    }

    public void setCrossword(String crossword) {
        this.crossword = crossword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int length() {
        int lenght = crossword.length();
        return lenght;
    }
}
