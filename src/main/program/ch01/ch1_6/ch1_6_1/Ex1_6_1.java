package ch01.ch1_6.ch1_6_1;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class Ex1_6_1 extends Frame implements Runnable {
    Font messageFont1;
    Font messageFont2;
    String message;

    public static void main(String args[]) {
      Ex1_6_1 workStart=new Ex1_6_1();
    }
    
    public Ex1_6_1() {
        super("Ex1_6_1");
        setSize(350, 350);

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      messageFont1 = new Font("锟斤拷锟斤拷", Font.PLAIN, 30);
      messageFont2 = new Font("锟疥楷锟斤拷", Font.PLAIN, 30);
      message = "锟斤拷锟斤拷锟街凤拷锟斤拷";
      repaint();
    }

    public void paint(Graphics g) {
        g.setFont(messageFont1);
        g.setColor(Color.blue);
        g.drawString(message, 5, 50);

        g.setFont(messageFont2);
        g.setColor(Color.green);
        g.drawString(message, 5, 100);
    }
}





