package ch13.ch13_2;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex13_2 extends Frame implements Runnable {
    int xs=100, ys=100;

    public static void main(String args[]) {
      Ex13_2 workStart=new Ex13_2();
    }
    
    public Ex13_2() {
        super("Ex13_2");
        setSize(350, 350);

        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        setVisible(true);
        new Thread(this).start();
    }

    public void processWindowEvent(WindowEvent e) {
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
           System.exit(0);
          }
    }

    public void run() {
      repaint();
    }

    public void paint(Graphics g) {
      g.drawLine(0,0,xs,ys);
    }
}





