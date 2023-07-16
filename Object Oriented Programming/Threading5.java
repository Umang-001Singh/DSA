package Umang;

import java.sql.SQLOutput;

public class Threading5 {
    public static void main(String[] args) {
        Thread a= new Thread(new ClassA());
        Thread b= new Thread(new ClassB());
        Thread c=new Thread (new ClassC());
        a.start();
        b.start();
        c.start();
        System.out.println("Multithreading is over");
    }
}

class ClassA extends Thread{
    public void run(){
        try{
        for(int i=0;i<=5;i++)
        {
            if (i==1)
                yield();
            System.out.println("From Thread A with i="+ -i);
        }}
        catch(Exception e){}
        System.out.println("Exiting from Thread A");
    }
}

class ClassB extends Thread{
    public void run(){
        try{
        for(int j=0;j<=5;j++){
            if(j==2)
                stop();
            System.out.println("From Thread B with j="+ 2*j);
        }}
        catch(Exception e){}
        System.out.println("Exiting form Thread B");
    }
}

class ClassC extends Thread{
    public void run(){
        try{
        for(int k=0;k<=5;k++){
            if (k==3)
                sleep(1000);
            System.out.println("From Thread c with k="+ 2*(k-1));
        }}
        catch(Exception e){}
        System.out.println("Exiting from Thread C");
    }
}