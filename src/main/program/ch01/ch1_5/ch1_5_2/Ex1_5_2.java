package ch01.ch1_5.ch1_5_2;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class Ex1_5_2 extends Frame implements Runnable {
    Font messageFont;
    String message;

    public static void main(String args[]) {
      Ex1_5_2 workStart=new Ex1_5_2();
    }
    
    public Ex1_5_2() {
        super("Ex2_5_2");
        setSize(350, 350);

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      messageFont = new Font("TimesRoman", Font.PLAIN, 30);
      message = "This is a test string";
      repaint();
    }

    public void paint(Graphics g) {
        g.setFont(messageFont);
        g.setColor(Color.blue);
        g.drawString(message, 5, 50);
    }
}





