package model;

public class Crosword {
    private String crossword;
    private String description;
    private int lenght;


    public Crosword(String crossword, String description) {
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

    public int getLenght() {
        this.lenght = getCrossword().length();
        return lenght;
    }

    @Override
    public String toString() {
        return "Crosword{" +
                "crossword='" + crossword + '\'' +
                ", description='" + description + '\'' +
                ", lenght=" + getLenght() +
                '}';
    }
}
