package ch02.ch2_4;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex2_4 extends Frame implements Runnable {
    public static void main(String args[]) {
      Ex2_4 workStart=new Ex2_4();
    }
    
    public Ex2_4() {
        super("Ex2_4");
        setSize(350, 350);

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      repaint();
    }

    public void paint(Graphics g) {
      g.drawRect(90,50,150,100);
      g.fillRect(90,200,150,100);
    }
}





