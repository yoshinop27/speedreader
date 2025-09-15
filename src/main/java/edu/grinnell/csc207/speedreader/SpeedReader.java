package edu.grinnell.csc207.speedreader;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.String;
import java.awt.*;
import java.lang.Integer;

public class SpeedReader {
    // Main class will take filename, width, height, font-size, wpm
    public static void main(String[] args) throws IOException, InterruptedException {
        DrawingPanel panel = new DrawingPanel(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        Graphics g = panel.getGraphics();
        Font f = new Font("Courier", Font.BOLD, 46);
        g.setFont(f);

        WordGenerator generator = new WordGenerator("corpus/" + args[0]);

        while (generator.hasNext()) {
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
}
