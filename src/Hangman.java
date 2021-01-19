import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String word = pickRandomWord();
        System.out.println(letterCount());
    }

    private static String letterCount() {
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
        return wordViewer;
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
