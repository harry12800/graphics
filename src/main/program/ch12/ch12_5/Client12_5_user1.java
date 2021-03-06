package ch12.ch12_5;

import java.awt.*;
import java.awt.event.*;
import java.math.*;

import java.io.*;
import java.net.*;
import java.util.*;

import java.applet.*;

public class Client12_5_user1 extends Frame implements Runnable {
    int x1=150, y1=225, dx1, dy1;
    int x2=150, y2=35, dx2, dy2;
    int bx1, by1, dbx1=0, dby1=-5, bflag1=0;
    int bx2, by2, dbx2=0, dby2=5, bflag2=0;
    Image img1, img2, img3, img4, bufferPage=null;

    Socket socket;
    static String iaddr;
    static int port;
    DataOutputStream  outstream;
    DataInputStream  instream;
    int x1_send, y1_send, bx1_send, by1_send, Ibflag1=0, bflag1_send, rcv;
    int x2_send, y2_send, bx2_send, by2_send, blfag2_send;

    int hitflag1=0, hitflag2=0;
    AudioClip sound1, sound2, soundexplode;
    String message="";

    public static void main(String args[]) {
       if (args.length < 2){
         System.out.println("USAGE: java Client10_4_User1 [iaddr] [port]");	
         System.exit(1);
       }

       iaddr = args[0];
       port=Integer.parseInt(args[1]);
       Client12_5_user1 workStart=new Client12_5_user1();
    }
    
    public Client12_5_user1() {
        super("Client12_5_user1");
        setSize(350,350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        img1 = tk.getImage("car090.gif");
        img2 = tk.getImage("car180.gif");
        img3 = tk.getImage("hit1.gif");
        img4 = tk.getImage("hit2.gif");

        sound1 = Applet.newAudioClip(getClass().getResource("sound1.au"));
        sound2 = Applet.newAudioClip(getClass().getResource("sound2.au"));
        soundexplode = Applet.newAudioClip(getClass().getResource("soundexplode.au"));

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
                          dx1 = 5; dy1 = 0;
                          break;
                   case KeyEvent.VK_LEFT:
                          dx1 = -5; dy1 = 0;
                          break;
                   case KeyEvent.VK_UP:
                          dx1 = 0; dy1 = -5; 
                          break;
                   case KeyEvent.VK_DOWN:
                          dx1 = 0; dy1 = 5;
                          break;
                   case KeyEvent.VK_SPACE:
                          dx1 = 0; dy1 = 0;
                          bx1 = x1 + 30;
                          by1 = y1 - 5;
                          Ibflag1 = 1;
                          sound1.play();
                          break;
                   default:
                          dx1 = 0; dy1 = 0;
              }
              try{
                 x1 = x1 + dx1;
                 y1 = y1 + dy1;

                 x1_send = x1 * 100 + 0;
                 y1_send = y1 * 100 + 1;
                 bx1_send = bx1 * 100 + 2;
                 by1_send = by1 * 100 + 3;
                 bflag1_send = Ibflag1 * 100 + 4;

                 outstream.writeInt(x1_send);
                 outstream.writeInt(y1_send);
                 outstream.writeInt(bx1_send);
                 outstream.writeInt(by1_send);
                 outstream.writeInt(bflag1_send);
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
                x1 = (rcv - 0) / 100;
             else if (rcv % 100 == 1) 
                y1 = (rcv - 1) / 100;
             else if (rcv % 100 == 2) 
                bx1 = (rcv - 2) / 100;
             else if (rcv % 100 == 3) 
                by1 = (rcv - 3) / 100;
             else if (rcv % 100 == 4) 
                bflag1 = (rcv - 4) / 100;

             if (rcv % 100 == 5) 
                x2 = (rcv - 05) / 100;
             else if (rcv % 100 == 6) 
                y2 = (rcv - 6) / 100;
             else if (rcv % 100 == 7) 
                bx2 = (rcv - 7) / 100;
             else if (rcv % 100 == 8) 
                by2 = (rcv - 8) / 100;
             else if (rcv % 100 == 9) 
                bflag2 = (rcv - 9) / 100;

             while((bflag1==1)&&(bflag2==0)) {
               if(by1 <= -10) bflag1 = 0;
               by1 = by1 + dby1;
               if ((bx1>=x2)&&(bx1<=x2+60)&&(by1<=y2)&&(message=="")){
                   hitflag2=1;
                   soundexplode.play();
                   message="User1 Win!!";
               }
               repaint();
               Thread.sleep(3);
              }

             while((bflag1==0)&&(bflag2==1)) {
               if(by2 >= 360) bflag2 = 0;
               by2 = by2 + dby2;
               if ((bx2>=x1)&&(bx2<=x1+60)&&(by2>=y1)&&(message=="")){
                   hitflag1=1;
                   soundexplode.play();
                   message="User2 Win!!";
               }
               repaint();
               Thread.sleep(3);
              }

             while((bflag1==1)&&(bflag2==1)) {
               if(by1 <= -10) bflag1 = 0;
               if(by2 >= 360) bflag2 = 0;
               by1 = by1 + dby1;
               by2 = by2 + dby2;
               if ((bx1>=x2)&&(bx1<=x2+60)&&(by1<=y2)&&(message=="")){
                   hitflag2=1;
                   soundexplode.play();
                   message="Both Died!!";
               }
               if ((bx2>=x1)&&(bx2<=x1+60)&&(by2>=y1)&&(message=="")){
                   hitflag1=1;
                   soundexplode.play();
                   message="Both Died!!";
               }
               repaint();
               Thread.sleep(3);
              }

           repaint();
         }
         catch (Exception f) {
            f.printStackTrace();
         }
      }
    }

    public void update(Graphics g) {
         paint(g);
    }

    public void paint(Graphics g) {
       Graphics bufferg;
       if(bufferPage == null)
          bufferPage = createImage(350, 350);
       bufferg = bufferPage.getGraphics();

       if (hitflag1==1) img1=img3;
       if (hitflag2==1) img2=img4;

       bufferg.drawString(message, 20, 20);

       bufferg.drawImage(img1, x1, y1, this);
       bufferg.drawImage(img2, x2, y2, this);

       if(bflag1==1) {
          bufferg.setColor(Color.black);  
          bufferg.fillRect(bx1, by1, 3, 5);
          bufferg.setColor(Color.white);  
          bufferg.fillRect(bx1, by1+5, 3, 5);
       }

       if (bflag2==1) {
          bufferg.setColor(Color.black); 
          bufferg.fillRect(bx2, by2, 3, 5);
          bufferg.setColor(Color.white); 
          bufferg.fillRect(bx2, by2-5, 3, 5);
       }

       bufferg.dispose();
       g.drawImage(bufferPage, getInsets().left, getInsets().top, this);
    }
}





