import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String word = pickRandomWord();
        System.out.println(letterCount());
        startGuessing();
    }

    private static void startGuessing() {
        Scanner guess = new Scanner(System.in);
        int tries = 10;
        String wrongGuess = "";
        String myGuess = "";
        int myGuessPos = pickRandomWord().indexOf(myGuess);
        while (tries > 0) {
            myGuess = guess.nextLine();
            if (pickRandomWord().indexOf(myGuess) >= 0) {
                while (myGuessPos >= 0) {
                    System.out.println(myGuessPos);
                    myGuessPos = pickRandomWord().indexOf(myGuess, ++myGuessPos);
                }
            } else {
                wrongGuess += myGuess;
                --tries;
                System.out.println(letterCount());
                System.out.println(wrongGuess);
                System.out.println("Du har " + tries + " försök kvar");

            }
        }
    }

    private static char[] letterCount() {
        int letterAmount = pickRandomWord().length();
        String wordViewer = "";
        int findSpace = pickRandomWord().indexOf(" ");
        for (int i = 0 ; i < letterAmount ; i++) {
            if (findSpace == i) {
                wordViewer += " ";
                findSpace = pickRandomWord().indexOf(" ",++findSpace);
            } else {
                wordViewer += "_";
            }
        }
        return wordViewer.toCharArray();
    }

    private static String pickRandomWord() {
        ArrayList<String> wordList = new ArrayList<>();
        Scanner wordInput = null;
        try {
            wordInput = new Scanner(new File("HangmanWordlist"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (wordInput.hasNextLine()) {
            wordList.add(wordInput.nextLine());
        }
        Random r = new Random();
        int number = r.nextInt(wordList.size());
        String randomWord = wordList.get(number);
        return randomWord;
    }
}
