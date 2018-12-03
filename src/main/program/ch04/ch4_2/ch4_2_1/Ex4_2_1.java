package ch04.ch4_2.ch4_2_1;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex4_2_1 extends Frame implements Runnable {
    int x=0, y=160;
    int dx=5, dy=0;

    public static void main(String args[]) {
      Ex4_2_1 workStart=new Ex4_2_1();
    }
    
    public Ex4_2_1() {
      super("Ex4_2_1");
      setSize(350, 350);
      setVisible(true);
      new Thread(this).start();
    }

    public void run() {
      while(true) {
        x = x + dx;
        y = y + dy;
        repaint();

        try{Thread.sleep(250);}
        catch(InterruptedException e) {;}
      }
    }

    public void paint(Graphics g) {
      g.setColor(Color.red);
      g.fillOval(x, y, 50, 50);
    }
}





