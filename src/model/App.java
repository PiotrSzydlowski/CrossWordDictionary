package model;

public class App {
    private final static int MAX_CROSSWORD = 2000;
    private Crosword[] croswords = new Crosword[MAX_CROSSWORD];
    private int number = 0;

    public void addCrossword(Crosword crosword) {
        if (number < MAX_CROSSWORD) {
            croswords[number] = crosword;
            number++;
        } else {
            System.out.println("Maxymalna liczba haseł została osiągnięta");
        }
    }

    public void printCrossword() {
        for (int i = 0; i < number; i++) {
            System.out.println(croswords[i]);
        }
    }
}
