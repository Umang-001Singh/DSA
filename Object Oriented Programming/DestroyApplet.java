package Umang;
import java.applet.*;
import java.awt.*;

public class DestroyApplet extends Applet{
    StringBuffer strBuffer = null;
    public void init(){
        strBuffer= new StringBuffer();
        addItem("Intializing the Applet");
    }
    public void start(){
        addItem("Starting the Applet");
    }
    public void stop(){
        addItem("Stoping the Applet");
    }
    public void destroy(){
        addItem("Destroying the Applet after execution");
    }
    public void addItem(String word){
        System.out.println(word);
        strBuffer.append(word);
    }
    public void paints(Graphics g){
        g.drawRect(0,0,getWidth()-1, getHeight()-1);
        g.drawString(strBuffer.toString(), 5,10);
    }
}

/*
<html>
<body>
<applet code="DestroyApplet.class" codebase="D:\IntelliJJavaProject\src\Umang" width=500 height= 500>
</applet>
</body>
</html>
 */
