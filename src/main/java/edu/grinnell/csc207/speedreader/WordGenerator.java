package edu.grinnell.csc207.speedreader;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.String;
import java.awt.*;

public class WordGenerator {
    String filename;
    int count;
    int sentences;
    Scanner text;

    public static void main(String[] args) throws IOException, InterruptedException{
        // WordGenerator generator = new WordGenerator("text"); 
        // for (int i=0; i<5; i++){
        //     System.out.println(generator.next());
        // }
        DrawingPanel panel = new DrawingPanel(400, 300);
        Graphics g = panel.getGraphics();
        Font f = new Font("Courier", Font.BOLD, 46);
        g.setFont(f);

        WordGenerator generator = new WordGenerator("text"); 

        while(generator.hasNext()) {
            String word = generator.next();

            // clear panel
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 400, 300);

            // print word
            g.setColor(Color.BLACK);
            g.drawString(word, 100, 100);

            Thread.sleep(1000);
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
        String word = this.text.next();
        if (word.contains(".") || 
            word.contains("?") ||
            word.contains("!"))
        {
            sentences++;
        }
        return word;
    }

    public int getWordCount() throws IOException {
        return this.count;
    }

    public int getSentenceCount() throws IOException {
        return this.sentences;
    }
}