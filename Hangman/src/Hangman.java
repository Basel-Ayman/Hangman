import eg.edu.alexu.csd.datastructure.hangman.cs18.IHangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Hangman implements IHangman {
    int maxGuessed;
    public  Dictionary<Integer, String> dictionary = new Hashtable<>();
    public String[] readFile() throws IOException {
        File file = new File("Words.txt");
        BufferedReader input = new BufferedReader(new FileReader(file));
        String a;
        int i = 0;
        String[] words = new String[20];
        while ((a = input.readLine()) != null) {
            words[i] = a;
            i++;
        }
        return words;
    }
    public void setDictionary(String[] words) throws IOException {
        words = readFile();
        for (int i=0; i<20; i++) {
            dictionary.put(i,words[i]);
        }
    }
    public String selectRandomSecretWord() {
        String secretWord;
        int randomWordNumber = (int) (Math.random() * 20);
        secretWord = dictionary.get(randomWordNumber);
        return secretWord;
    }
    public String guess(Character c) {
        String word = selectRandomSecretWord();
        char[] filler = new char[word.length()];
        int i = 0;
        while (i<word.length()) {
            filler[i] = '-';
            i++;
        }
        String guessed = new String(filler);
        System.out.print(filler);
        System.out.println("         Guesses remaining = " + maxGuessed);
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> list = new ArrayList<Character>();
        while (maxGuessed > 0) {
            char x = scanner.next().charAt(0);
            if (list.contains(x)){
                System.out.println("Already entered");
                continue;
            }
            list.add(x);
            if (word.contains(x+"")) {
                for (int y=0; y<word.length(); y++) {
                    if (word.charAt(y) == x) {
                        filler[y] = x;
                    }
                }
                guessed = new String(filler);
            }else {
                maxGuessed--;
            }
            if (word.equals(String.valueOf(filler))) {
                System.out.println(filler);
                System.out.println("YOU WON.");
                break;
            }
            System.out.print(filler);
            System.out.println("         Guesses remaining = " + maxGuessed);
        }
        if (maxGuessed == 0){
            System.out.println("YOU LOSE.");
        }
        return guessed;
    }
    public void setMaxWrongGuesses(Integer max) {
        if (max <= 0){
            maxGuessed = 1;
        }else {
            maxGuessed = max;
        }
    }
}