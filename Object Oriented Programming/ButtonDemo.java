package Umang;
import java.awt.*;

public class ButtonDemo extends Frame{
    ButtonDemo() {
        Frame frame = new Frame("Frame with Button");
        Button b = new Button("Click");
        b.setBounds(30, 100, 80, 300);
        frame.add(b);
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }

public static void main(String[] args){
    ButtonDemo b=new ButtonDemo();
}
}
