package ch03.ch3_4.ch3_4_2;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Ex3_4_2 extends Frame implements Runnable {
    Image image;

    public static void main(String args[]) {
      Ex3_4_2 workStart=new Ex3_4_2();
    }
    
    public Ex3_4_2() {
        super("Ex3_4_2");
        setSize(350, 350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        image = tk.getImage("Sunset.jpg");

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      repaint();
    }

    public void paint(Graphics g) {
      g.drawImage(image, 0, 0, 200, 200, this);
    }
}





