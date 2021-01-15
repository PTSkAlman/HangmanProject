import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String word = pickRandomWord();
        System.out.println(word);
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
