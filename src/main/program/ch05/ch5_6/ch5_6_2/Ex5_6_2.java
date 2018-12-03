package ch05.ch5_6.ch5_6_2;
import java.awt.*;
import java.awt.event.*;

public class Ex5_6_2 extends Frame {
    public Ex5_6_2() {
        super("Ex5_6_2");
        setSize(350, 350);
        setVisible(true);
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }

    public void processMouseEvent(MouseEvent e) {
        if(e.getID() == MouseEvent.MOUSE_ENTERED) {
           System.out.println("ENTER DATA ::");
           System.out.println("getSource() : " + e.getSource());
           System.out.println("getID() : " + e.getID());
           System.out.println("getWhen() : " + e.getWhen());
           System.out.println("getX() : " + e.getX());
           System.out.println("getY() : " + e.getY());
           System.out.println("getClickCount() : " + e.getClickCount());
        }

        if(e.getID() == MouseEvent.MOUSE_EXITED) {
           System.out.println("EXIT DATA ::");
           System.out.println("getSource() : " + e.getSource());
           System.out.println("getID() : " + e.getID());
           System.out.println("getWhen() : " + e.getWhen());
           System.out.println("getX() : " + e.getX());
           System.out.println("getY() : " + e.getY());
           System.out.println("getClickCount() : " + e.getClickCount());
        }
    }

    public static void main(String args[]) {
      Ex5_6_2 workStart=new Ex5_6_2();
    }
}





