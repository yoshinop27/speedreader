package edu.grinnell.csc207.speedreader;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;

/**
 * The SpeedReader class runs a speed reading application.
 * It initializes a drawing panel and displays words from a WordGenerator.
 */
public class SpeedReader {
    // setting up our global variables
    public static int width;
    public static int height;
    public static int fontSize;
    public static int wpm;

    /**
     * Initializes speed reader by reading arguments and starting the display
     * @param args command-line arguments in the following order:
     *               <filename> – name of the text file with words (ex. silk_road.txt)
     *               <width> – drawing panel width
     *               <height> – drawing panel height
     *               <fontsize> – font size for displayed words
     *               <wpm> – words per minute speed
     */
     
    public static void main(String[] args) throws IOException, InterruptedException, IllegalArgumentException {

        // error checking
        if (args.length != 5){
            throw new IllegalArgumentException
                ("Five arguments are required. Please input <filename> <width> <height> <font size> <wpm> \n ");
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

            // sleep
            Thread.sleep(60000/wpm);
        }
    }
}
