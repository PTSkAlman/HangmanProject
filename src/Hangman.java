import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        startGuessing();
    }

    private static void startGuessing() {
        System.out.println(letterCount());
        Scanner input = new Scanner(System.in);
        String guess = input.nextLine();
        int tries = 10;
        String currentWord = null;
        boolean isRunning = true;
        while (isRunning) {
            if (tries == 0) {
                System.out.println("Du förlorade!");
                isRunning = false;
            } else if (currentWord.equals(pickRandomWord())) {
                System.out.println("Du vann!");
                isRunning = false;
            }

            if (pickRandomWord().contains(guess)) {
                if (guess.length() < 1) {
                    if (/*guess.charAt(0) == charOf(pickRandomWord())*/ false) {

                    } else {
                        --tries;
                        System.out.println("Du har " + tries + " kvar");
                    }
                }
            }
        }
    }
/*
    private static void startGuessing() {
        Scanner guess = new Scanner(System.in);
        int tries = 10;
        String wrongGuess = "";
        String myGuess;
        StringBuilder currentWord = new StringBuilder(String.valueOf(letterCount()));
        int myGuessPos;
        while (tries > 0 || currentWord.equals(pickRandomWord())) {
            myGuess = guess.nextLine();
            myGuessPos = pickRandomWord().indexOf(myGuess);
            if (pickRandomWord().contains(myGuess)) {

                while (myGuessPos >= 0 && myGuessPos < myGuess.length()) {
                    currentWord.setCharAt(myGuessPos, myGuess.charAt(0));
                    myGuessPos = pickRandomWord().indexOf(myGuess, ++myGuessPos);
                    System.out.println(currentWord);
                }

                for (int i = 0 ; i<pickRandomWord().length() ; i++) {
                    if (myGuess.equals(pickRandomWord())) {
                        currentWord.replace(0, pickRandomWord().length(), pickRandomWord());
                        System.out.println(currentWord);
                        i = pickRandomWord().length();
                    } else if (myGuess.substring(0,1).equals(pickRandomWord().charAt(i))) {
                        currentWord.setCharAt(i, myGuess.charAt(0));
                    }
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
 */

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
