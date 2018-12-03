package ch05.ch5_5.ch5_5_1;
import java.awt.*;
import java.awt.event.*;

public class Ex5_5_1 extends Frame {
    public Ex5_5_1() {
        super("Ex5_5_1");
        setSize(350, 350);
        setVisible(true);
        enableEvents(AWTEvent.KEY_EVENT_MASK);
    }

    public void processKeyEvent(KeyEvent e) {
        if(e.getID() == KeyEvent.KEY_PRESSED) {
           System.out.println("getSource() : " + e.getSource());
           System.out.println("getID() : " + e.getID());
           System.out.println("getWhen() : " + e.getWhen());
           System.out.println("getKeyCode() : " + e.getKeyCode());
        }
    }

    public static void main(String args[]) {
      Ex5_5_1 workStart=new Ex5_5_1();
    }
}





