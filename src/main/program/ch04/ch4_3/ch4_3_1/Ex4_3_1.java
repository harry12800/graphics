package ch04.ch4_3.ch4_3_1;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Graphics;

public class Ex4_3_1 extends Frame implements Runnable {
    int x=0, y=100;
    int dx=5, dy=5;
    Image img;

    public static void main(String args[]) throws IOException {
      Ex4_3_1 workStart=new Ex4_3_1();
    }
    
    public Ex4_3_1() throws IOException {
      super("Ex4_3_1");
      setSize(350, 350);

      Toolkit tk = Toolkit.getDefaultToolkit();
      img = ImageIO.read(getClass().getResourceAsStream("fly.gif"));

      setVisible(true);
      new Thread(this).start();
    }

    public void run() {
      while(true) {
        x = x + dx;
        y = y + dy;
        repaint();

        if(x<=0) dx = 5;
        else if((x + 50) >= getWidth()) dx = -5;

        if(y<=0) dy = 5;
        else if((y + 50) >= getHeight()) dy = -5;

        try{Thread.sleep(250);}
        catch(InterruptedException e) {;}
      }
    }

    public void paint(Graphics g) {
       g.drawImage(img, x, y, this);
    }
}





