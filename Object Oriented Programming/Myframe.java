package Umang;
import java.awt.*;

public class Myframe {
    public static void main(String[] args){
        Frame f=new Frame("Frame with all generally used components");
        f.setSize(1000,1000);
        f.setVisible(true);
        f.setLayout(null);
        f.setBackground(Color.blue);
        Button b=new Button("button");
        b.setBounds(100,100,50,50);
        Checkbox c=new Checkbox("C++");
        Checkbox c2=new Checkbox("Java");
        c.setBounds(100,150,150,50);
        c2.setBounds(100,200,150,50);
        Label l=new Label("First Label");
        l.setBounds(100,250,250,50);
        TextField t=new TextField("I am studyng OOPs in Java");
        t.setBounds(100,300,500,50);
        TextArea ta=new TextArea("Welcome to IIT Kharagpur" +
                "NPTEL");
        ta.setBounds(100,400,500,150);
        f.add(b);
        f.add(c);
        f.add(c2);
        f.add(l);
        f.add(t);
        f.add(ta);
    }
}
