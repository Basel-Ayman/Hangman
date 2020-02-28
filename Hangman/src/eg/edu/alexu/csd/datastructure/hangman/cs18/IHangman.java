package eg.edu.alexu.csd.datastructure.hangman.cs18;

import java.io.IOException;

public interface IHangman {

    String[] readFile() throws Exception;
    void setDictionary(String[] words) throws IOException;
    String selectRandomSecretWord();
    String guess(Character c);
    void setMaxWrongGuesses(Integer max);

}
