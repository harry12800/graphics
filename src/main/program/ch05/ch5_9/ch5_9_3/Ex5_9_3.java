package ch05.ch5_9.ch5_9_3;
import java.awt.*;
import java.awt.event.*;

class Ex5_9_3 extends Frame {
   public Ex5_9_3() { 
      super("Ex5_9_3");
      setSize(350, 350);
      setVisible(true);  

      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent evt) {
              System.exit(0);
         }
      });
   }

    public static void main(String[] args) {
         Ex5_9_3 workstart = new Ex5_9_3();

    }
}
