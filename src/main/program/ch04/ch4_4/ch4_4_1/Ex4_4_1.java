package ch04.ch4_4.ch4_4_1;

import java.awt.*;
import java.awt.event.*;

public class Ex4_4_1 extends Frame implements Runnable {
    int num=0, flag, i;
    Image[] img;

    public static void main(String args[]) {
      Ex4_4_1 workStart=new Ex4_4_1();
    }
    
    public Ex4_4_1() {
        super("Ex4_4_1");
        setSize(350, 350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img = new Image[10];
        for(i=0; i<10; i++) {
           img[i] = tk.getImage("char" + i + ".png");
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





