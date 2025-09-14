package edu.grinnell.csc207.speedreader;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.String;

public class WordGenerator {
    String filename;
    int count;
    int sentences;
    Scanner text;

    public static void main(String[] args) throws IOException{
        WordGenerator generator = new WordGenerator("text"); 
        for (int i=0; i<5; i++){
            System.out.println(generator.next());
        }
    }

    public WordGenerator(String filename) throws IOException {
        this.text = new Scanner(new File(filename));
        this.count = 0;
        this.sentences = 0;
    }

    public boolean hasNext() throws IOException {
        if (this.text.hasNext()){
            return true;
        } else {
            return false;
        }
    }  
    
    public String next() throws IOException {
        count++;
        if (this.text.next().contains(".") || 
            this.text.next().contains("?") ||
            this.text.next().contains("!") ||
            this.text.next().contains("!") ||
            this.text.next().contains("!"))
        {
            sentences++;
        }
        return this.text.next();
    }

    public int getWordCount() throws IOException {
        return this.count;
    }

    public int getSentenceCount() throws IOException {
        return this.sentences;
    }
}