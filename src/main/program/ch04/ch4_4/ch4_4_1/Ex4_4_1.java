package ch04.ch4_4.ch4_4_1;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ex4_4_1 extends Frame implements Runnable {
    int num=0, flag, i;
    Image[] img;

    public static void main(String args[]) throws IOException {
      Ex4_4_1 workStart=new Ex4_4_1();
    }
    
    public Ex4_4_1() throws IOException {
        super("Ex4_4_1");
        setSize(350, 350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img = new Image[10];
        for(i=0; i<10; i++) {
           img[i] =ImageIO.read(getClass().getResourceAsStream("char" + i + ".png"));  
        }

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      while(true) {
         flag = num % 10;
         repaint();
         num = num + 1;         
 
         try{Thread.sleep(250);}
         catch(InterruptedException e) {;}
      }
    }

    public void paint(Graphics g) {
        g.drawImage(img[flag], 50, 50, this);
    }
}





