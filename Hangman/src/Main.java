import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Hangman hangman = new Hangman();
        String[] arr = new String[20];
        hangman.setDictionary(arr);
        hangman.setMaxWrongGuesses(5);
        System.out.println("S >> Start");
        Scanner scanner = new Scanner(System.in);
        char x = scanner.next().charAt(0);
        x = Character.toLowerCase(x);
        if (x == 's'){
            hangman.guess(x);
        }else {
            System.out.println("Please enter S to Start.");
        }
    }
}
