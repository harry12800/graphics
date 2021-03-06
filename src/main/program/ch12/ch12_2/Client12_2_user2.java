package ch12.ch12_2;

import java.awt.*;
import java.awt.event.*;
import java.math.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client12_2_user2 extends Frame implements Runnable {
    int x=150, y=235, dx, dy;
    int bx, by, dbx=0, dby=-5, bflag=0;
    Image img;

    Socket socket;
    static String iaddr;
    static int port;
    DataOutputStream  outstream;
    DataInputStream  instream;
    int x_send, y_send, bx_send, by_send, Ibflag=0, bflag_send, rcv;

    public static void main(String args[]) {
       if (args.length < 2){
         System.out.println("USAGE: java Client10_4_user2 [iaddr] [port]");	
         System.exit(1);
       }

       iaddr = args[0];
       port=Integer.parseInt(args[1]);
      Client12_2_user2 workStart=new Client12_2_user2();
    }
    
    public Client12_2_user2() {
        super("Client12_2_user2");
        setSize(350,350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img = tk.getImage("car090.gif");

        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        enableEvents(AWTEvent.KEY_EVENT_MASK);

        setVisible(true);
        try{
            socket=new Socket(InetAddress.getByName(iaddr),port);
            outstream = new DataOutputStream(socket.getOutputStream());
            instream = new DataInputStream(socket.getInputStream()); 
            new Thread(this).start();
         }
         catch (Exception e) {
            e.printStackTrace();
         }
    }

    public void processWindowEvent(WindowEvent e) {
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
           System.exit(0);
          }
    }

    public void processKeyEvent(KeyEvent e) {
        if(e.getID() == KeyEvent.KEY_PRESSED) {
              switch(e.getKeyCode()) {
                   case KeyEvent.VK_RIGHT:
                          dx = 5; dy = 0;
                          break;
                   case KeyEvent.VK_LEFT:
                          dx = -5; dy = 0;
                          break;
                   case KeyEvent.VK_UP:
                          dx = 0; dy = -5; 
                          break;
                   case KeyEvent.VK_DOWN:
                          dx = 0; dy = 5;
                          break;
                   case KeyEvent.VK_SPACE:
                          dx = 0; dy = 0;
                          bx = x + 30;
                          by = y - 5;
                          Ibflag = 1;
                          break;
                   default:
                          dx = 0; dy = 0;
              }
              try{
                 x = x + dx;
                 y = y + dy;

                 x_send = x * 100 + 0;
                 y_send = y * 100 + 1;
                 bx_send = bx * 100 + 2;
                 by_send = by * 100 + 3;
                 bflag_send = Ibflag * 100 + 4;

                 outstream.writeInt(x_send);
                 outstream.writeInt(y_send);
                 outstream.writeInt(bx_send);
                 outstream.writeInt(by_send);
                 outstream.writeInt(bflag_send);
              }
              catch (Exception f) {
                 f.printStackTrace();
              }
        }
    }

    public void run() {
      while(true) {
        try {
             rcv = instream.readInt();

             if (rcv % 100 == 0) 
                x = (rcv - 0) / 100;
             else if (rcv % 100 == 1) 
                y = (rcv - 1) / 100;
             else if (rcv % 100 == 2) 
                bx = (rcv - 2) / 100;
             else if (rcv % 100 == 3) 
                by = (rcv - 3) / 100;
             else if (rcv % 100 == 4) 
                bflag = (rcv - 4) / 100;

             while(bflag==1) {
               if(by <= -10) bflag = 0;
               by = by + dby;

               repaint();
               Thread.sleep(5);
              }
           repaint();
         }
         catch (Exception f) {
            f.printStackTrace();
         }
      }
    }

    public void paint(Graphics g) {
          g.drawImage(img, x, y, this);
          g.fillRect(bx, by, 3, 5);
    }
}





