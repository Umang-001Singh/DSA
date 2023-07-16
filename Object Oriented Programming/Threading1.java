package Umang;

public class Threading1 {
    public static void main(String args[]){
        Thread a= new Thread(new ThreadX());
        Thread b= new Thread(new ThreadY());
        Thread c= new Thread(new ThreadZ());
        a.start();
        b.start();
        c.start();
        System.out.println("Multitheading is over");//Will execute first because it is main thread.
    }
}

class ThreadX extends Thread{
    public void run(){
        for(int i=0;i<=5;i++)
            System.out.println("From Thread X with i="+ -i);
        System.out.println("Exiting from Thread X");
    }
}

class ThreadY extends Thread{
    public void run(){
        for(int j=0;j<=5;j++)
            System.out.println("From Thread Y with j="+ 2*j);
        System.out.println("Exiting from Thread Y");
    }

}

class ThreadZ extends Thread{
    public void run(){
        for(int k=0;k<=0;k++)
            System.out.println("From Thread Z with k"+ 2*(k-1));
        System.out.println("Exiting form Thread Z");
    }
}