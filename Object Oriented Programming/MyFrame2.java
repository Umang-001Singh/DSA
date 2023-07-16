package Umang;
import java.awt.*;

public class MyFrame2 {
    MyFrame2(){
        Frame f=new Frame("Frame with components");
        f.setSize(1000,1000);
        f.setLayout(null);
        f.setVisible(true);
        f.setBackground(Color.blue);
        List l=new List(5);
        l.add("Item 1");
        l.add("Item 2");
        l.add("Item 3");
        l.add("Item 4");
        l.add("Item 5");
        l.setBounds(100,100,500,100);
        f.add(l);
        Choice c=new Choice ();
        c.add("Choice 1");
        c.add("Choice 2");
        c.add("Choice 3");
        c.add("Choice 4");
        c.add("Choice 5");
        c.setBounds(100,250,250,50);
        f.add(c);
        Scrollbar s=new Scrollbar();
        s.setBounds(600,100,50,100);
        f.add(s);
    }
    public static void main(String [] args){
        new MyFrame2();
    }
}
