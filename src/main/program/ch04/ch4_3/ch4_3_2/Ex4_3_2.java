package ch04.ch4_3.ch4_3_2;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ex4_3_2 extends Frame implements Runnable {
    int num=0, flag;
    int x=0, y=100, dx=5, dy=5;
    Image img0, img1, img2;

    public static void main(String args[]) throws IOException {
      Ex4_3_2 workStart=new Ex4_3_2();
    }
    
    public Ex4_3_2() throws IOException {
        super("Ex4_3_2");
        setSize(350, 350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img0 = ImageIO.read(getClass().getResourceAsStream("fly0.gif"));
        img1 = ImageIO.read(getClass().getResourceAsStream("fly1.gif"));
        img2 = ImageIO.read(getClass().getResourceAsStream("fly2.gif"));

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      while(true) {
         x = x + dx;
         y = y + dy;
         flag = num % 3;
         repaint();
         num = num + 1;         

         if(x <= 0) dx = 5;
         else if((x+60) >= 350) dx = -5;

         if(y<=0) dy = 5;
         else if((y + 50) >= getHeight()) dy = -5;
 
         try{Thread.sleep(250);}
         catch(InterruptedException e) {;}
      }
    }

    public void paint(Graphics g) {
       if(flag == 0)
          g.drawImage(img0, x, y, this);
       else if(flag == 1)
          g.drawImage(img1, x, y, this);
       else if(flag == 2)
          g.drawImage(img2, x, y, this);
    }
}





