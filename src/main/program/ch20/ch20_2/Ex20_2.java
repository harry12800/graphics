package ch20.ch20_2;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.applet.*;


public class Ex20_2 extends Applet {
  Font messageFont1 = new Font("TimesRoman", Font.PLAIN, 30);
  Font messageFont2 = new Font("锟斤拷锟斤拷", Font.PLAIN, 30);
  Font messageFont3 = new Font("锟疥楷锟斤拷", Font.PLAIN, 30);

  String messageEnglish = "English test string";
  String messageChinese = "锟斤拷锟侥诧拷锟斤拷锟街凤拷锟斤拷";
  
  public void paint(Graphics g) {
    g.setFont(messageFont1);
    g.setColor(Color.red);
    g.drawString(messageEnglish, 10, 50);

    g.setFont(messageFont2);
    g.setColor(Color.green);
    g.drawString(messageChinese, 10, 100);

    g.setFont(messageFont3);
    g.setColor(Color.blue);
    g.drawString(messageChinese, 10, 150);
  }
}
