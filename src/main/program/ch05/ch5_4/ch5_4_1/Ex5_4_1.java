package ch05.ch5_4.ch5_4_1;
import java.awt.*;
import java.awt.event.*;

public class Ex5_4_1 extends Frame {
    public Ex5_4_1() {
        super("Ex5_4_1");
        setSize(350, 350);
        setVisible(true);
        enableEvents(AWTEvent.COMPONENT_EVENT_MASK);
    }

    public void processComponentEvent(ComponentEvent e) {
        if(e.getID() == ComponentEvent.COMPONENT_MOVED) {
           System.out.println("getSource() : " + e.getSource());
           System.out.println("getID() : " + e.getID());
    
        }
    }

    public static void main(String args[]) {
      Ex5_4_1 workStart=new Ex5_4_1();
    }
}





