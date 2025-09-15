package edu.grinnell.csc207.speedreader;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.String;
import java.awt.*;
import java.lang.Integer;

public class SpeedReader {
    // setting up our global variables
    public static int width;
    public static int height;
    public static int fontSize;
    public static int wpm;

    // Main class will take filename, width, height, font-size, wpm
    static void main(String[] args) throws IOException, InterruptedException, IllegalArgumentException {

        // error checking
        if (args.length != 5){
            throw new IllegalArgumentException("Five arguments are required.");
        }

        // initialize are vars using cml args
        width = Integer.parseInt(args[1]);
        height = Integer.parseInt(args[2]);
        fontSize = Integer.parseInt(args[3]);
        wpm = Integer.parseInt(args[4]);

        // create drawing panel and graphics
        DrawingPanel panel = new DrawingPanel(width, height);
        Graphics g = panel.getGraphics();
        Font f = new Font("Courier", Font.BOLD, fontSize);
        g.setFont(f);

        // create generator
        WordGenerator generator = new WordGenerator("corpus/" + args[0]);

        // read words and draw
        while (generator.hasNext()) {
            String word = generator.next();

            // clear panel
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);

            // print word
            g.setColor(Color.BLACK);
            g.drawString(word, width/2, height/2);

            Thread.sleep(wpm);
        }
    }
}
