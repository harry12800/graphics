package ch01.ch1_4.ch1_4_2;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Font;

public class Ex1_4_2 extends Frame implements Runnable {
    Font messageFont;
    String message;

    public static void main(String args[]) {
      Ex1_4_2 workStart=new Ex1_4_2();
    }
    
    public Ex1_4_2() {
        super("Ex1_4_2");
        setSize(350, 350);

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      messageFont = new Font("TimesRoman", Font.PLAIN, 20);
      message = "This is a test string";

      System.out.println("getName() : " + messageFont.getName());
      System.out.println("getStyle() : " + messageFont.getStyle());
      System.out.println("getSize() : " + messageFont.getSize());
      System.out.println("isBold() : " + messageFont.isBold());
      System.out.println("isItalic() : " + messageFont.isItalic());
      System.out.println("isPlain() : " + messageFont.isPlain());

      repaint();
    }

    public void paint(Graphics g) {
        g.setFont(messageFont);
        g.drawString(message, 5, 50);
    }
}





