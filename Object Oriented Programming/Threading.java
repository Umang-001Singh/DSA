package Umang;




import java.io.DataInputStream;

import static java.lang.Thread.sleep;


public class Threading {
    public static void main(String[] args) {
        Thread t1= new Thread(new ThreadA());
        Thread t2 = new Thread(new ThreadB());
        Thread t3 = new Thread(new ThreadC());
        t1.start();
        t2.start();
        t3.start();
    }
}

class ThreadA implements Runnable {
    public void run() {
        float a=0;
        float b=0;
        float s=0;
        System.out.println("Enter two numbers for thread A");
        try {
            DataInputStream in = new DataInputStream(System.in);
            String tempstring;
            System.out.flush();
            tempstring = in.readLine();
            a = Float.valueOf(tempstring);
            System.out.flush();
            tempstring = in.readLine();
            b = Float.valueOf(tempstring);
            s=a+b;
        }
        catch(Exception e){}
        System.out.println("Sum ="+s);

    }
}

class ThreadB implements Runnable{
    public void run(){
        float c=0;
        float d=0;
        float p=0;
        System.out.println("Enter two numbers for thread B");
        try{
            DataInputStream in = new DataInputStream(System.in);
            String tempstring;
            System.out.flush();
            tempstring=in.readLine();
            c=Float.valueOf(tempstring);
            System.out.flush();
            tempstring = in.readLine();
            d=Float.valueOf(tempstring);
        }
        catch(Exception e){}
        p=c*d;
        System.out.println("Product ="+p);

    }
}

class ThreadC implements Runnable {
    public void run() {
        try {

            sleep(2000);
            float q;
            float p=0;
            float s=0;
            q = p / s;
            System.out.println("p/s=" + q);
        } catch (Exception e) {
        }
    }
}







