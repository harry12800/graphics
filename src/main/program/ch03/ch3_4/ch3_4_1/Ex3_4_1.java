package ch03.ch3_4.ch3_4_1;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Graphics;

public class Ex3_4_1 extends Frame implements Runnable {
    Image image;

    public static void main(String args[]) throws IOException {
      Ex3_4_1 workStart=new Ex3_4_1();
    }
    
    public Ex3_4_1() throws IOException {
        super("Ex3_4_1");
        setSize(350, 350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        image = ImageIO.read(getClass().getResourceAsStream("Sunset.jpg"));

        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
      repaint();
    }

    public void paint(Graphics g) {
      g.drawImage(image, 0, 0, this);
    }
}





