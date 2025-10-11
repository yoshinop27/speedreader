package edu.grinnell.csc207.speedreader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * The WordGenerator class reads words from a text file.
 * It provides methods to get each word one at a time, check if more
 * words are available, and count how many words and sentences have been read.
 */
public class WordGenerator {
    String filename;
    int count;
    int sentences;
    Scanner text;

    /**
     * Initializes a WordGenerator
     * @param filename - name of the file to be processed
     */
    public WordGenerator(String filename) throws IOException {
        this.text = new Scanner(new File(filename));
        this.count = 0;
        this.sentences = 0;
    }

    /**
     * Checks if there are more words to be read
     * @return false if we have reached the end of the file, true if not
     */
    public boolean hasNext() throws IOException {
        if (this.text.hasNext()){
            return true;
        } else {
            return false;
        }
    }  
    
    /**
     * Returns the next word from the input and updates the word and sentence counts.
     * @return the next word as a string
     */
    public String next() throws IOException {
        count++;
        String word = this.text.next();
        if (word.contains(".") || 
            word.contains("?") ||
            word.contains("!"))
        {
            sentences++;
        }
        return word;
    }

    /**
     * Returns the word count.
     * @return the word count, an integer
     */
    public int getWordCount() throws IOException {
        return this.count;
    }
    
    /**
     * Returns the sentence count.
     * @return the sentence count, an integer
     */
    public int getSentenceCount() throws IOException {
        return this.sentences;
    }
}