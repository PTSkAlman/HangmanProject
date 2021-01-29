import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        //startGuessing();
        String word = pickRandomWord();
        System.out.println(letterCount());
        Scanner input = new Scanner(System.in);
        String guess = input.nextLine();
        int tries = 10;
        while (tries > 0) {
            if (word.contains(guess)) {

            } else {
                --tries;
            }
        }
    }

    private static char toChar(String s) {
        return s.charAt(0);
    }

    private static int[] charPos(String s, char c) {
        ArrayList<Integer> charIndex = new ArrayList<>();

        for (int i = 0 ; i < pickRandomWord().length() ; i++) {
            if (s.charAt(i) == c) {
                charIndex.add(i);
            }
        }
        int[] intIndex = new int[charIndex.size()];
        for (int i = 0 ; i < charIndex.size() ; i++) {
            intIndex[i] = charIndex.get(i);
        }
        return intIndex;
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
