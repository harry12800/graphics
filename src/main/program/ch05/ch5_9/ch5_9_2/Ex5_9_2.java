package ch05.ch5_9.ch5_9_2;
import java.awt.*;
import java.awt.event.*;

public class Ex5_9_2 extends Frame {
    public Ex5_9_2() {
        super("Ex5_9_2");
        setSize(350, 350);
        setVisible(true);
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    }

    public void processWindowEvent(WindowEvent e) {
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
           System.exit(0);
          }
    }

    public static void main(String args[]) {
      Ex5_9_2 workStart=new Ex5_9_2();
    }
}





