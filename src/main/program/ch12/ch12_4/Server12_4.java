package ch12.ch12_4;
import java.net.*;
import java.io.*;
import java.util.*;

public class Server12_4 {
  private static ServerSocket SS;
  private static int port=1234;
  private Hashtable ht = new Hashtable();
  Socket socket;

  public Server12_4() {
     try {
          SS = new ServerSocket(port);
          System.out.println("Server is created and waiting Client to connect...");
	
          while (true) {
              socket = SS.accept();
              System.out.println("Client IP = " +
                                socket.getInetAddress().getHostAddress());
				
              DataOutputStream outstream = new 
                                DataOutputStream(socket.getOutputStream());
              ht.put(socket, outstream);
              Thread thread = new Thread(new ServerRunnable(socket, ht));
              thread.start();
           }
      }
      catch (IOException e) {
           System.out.println(e.getMessage());
      }
   }

  public static void main(String[] args) {
      Server12_4 ServerStart=new Server12_4();
  }
}

class ServerRunnable implements Runnable {
  private Socket socket;
  private Hashtable ht;

  public ServerRunnable(Socket socket, Hashtable ht) {
     this.socket = socket;
     this.ht = ht;
  }

  public void run() {
     DataInputStream instream;

     try {
          instream = new DataInputStream(socket.getInputStream());
			
          while (true) {
              int message = instream.readInt();

              synchronized(ht) {
                   Enumeration en = ht.elements();
                   while(en.hasMoreElements()) {
                      DataOutputStream outstream = (DataOutputStream)en.nextElement();
			
                      try {
                           outstream.writeInt(message);
                       } 
                      catch (IOException e) {
                           System.out.println(e.getMessage());
                      }
                   }
              }
         }
     } 
     catch (IOException e) {
          System.out.println(e.getMessage());  
     }
     finally {
           synchronized(ht) {
                 System.out.println("Remove connection: " + socket);
                 ht.remove(socket);
                 try {
                      socket.close();
                 } 
                 catch (IOException e) {
                 }
            }
      }
  }
}
