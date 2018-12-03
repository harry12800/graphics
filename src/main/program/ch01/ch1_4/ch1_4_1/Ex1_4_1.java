package ch01.ch1_4.ch1_4_1;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Font;

public class Ex1_4_1 extends Frame implements Runnable {
    Font messageFont;
    String message;

    public static void main(String args[]) {
      Ex1_4_1 workStart=new Ex1_4_1();
    }
    
    public Ex1_4_1() {
        super("Ex1_4_1");
        setSize(350, 350);

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      messageFont = new Font("TimesRoman", Font.PLAIN, 20);
      message = "This is a test string";
      repaint();
    }

    public void paint(Graphics g) {
        g.setFont(messageFont);
        g.drawString(message, 5, 50);
    }
}





