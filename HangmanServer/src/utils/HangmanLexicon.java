/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import acm.util.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author davgeek
 */
public class HangmanLexicon {
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private ArrayList <String> wordList = new ArrayList <String> ();
    
    public HangmanLexicon(String lexiconFilePath) {
        try {
            BufferedReader hangmanWords = new BufferedReader(new FileReader(lexiconFilePath));
            while(true) {
                    String line = hangmanWords.readLine();
                    if(line == null) break;
                    wordList.add(line);
            }
            hangmanWords.close();
        } catch (IOException ex) {
                throw new ErrorException(ex);
        }
    }
    
    /**
     * Returns the word at the specified index.
     */
    private String getWord(int index) {
        return wordList.get(index);
    }

    /**
     * Returns the number of words in the lexicon.
     */
    private int getWordCount() {
        return wordList.size();
    }
    
    
    public String pickWord() {
        int randomWord = rgen.nextInt(0, getWordCount()-1); 
        return getWord(randomWord);
    }
    
}
