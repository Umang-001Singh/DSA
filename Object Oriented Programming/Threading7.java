package Umang;

public class Threading7 {public static void main(String[] args) {
    Thread a= new Thread(new ClassA1());
    Thread b= new Thread(new ClassB1());
    Thread c=new Thread (new ClassC1());
    a.setPriority(Thread.MAX_PRIORITY);
    b.setPriority(c.getPriority()+1);
    c.setPriority(Thread.MIN_PRIORITY);
    a.start();
    b.start();
    c.start();
    System.out.println("Multithreading is over");//Main thread executes first.
}
}

class ClassA1 extends Thread{
    public void run(){
        try{
            for(int i=0;i<=5;i++)
            {
                System.out.println("From Thread A with i="+ -i);
            }}
        catch(Exception e){}
        System.out.println("Exiting from Thread A");
    }
}

class ClassB1 extends Thread{
    public void run(){
        try{
            for(int j=0;j<=5;j++){
                System.out.println("From Thread B with j="+ 2*j);
            }}
        catch(Exception e){}
        System.out.println("Exiting form Thread B");
    }
}

class ClassC1 extends Thread{
    public void run(){
        try{
            for(int k=0;k<=5;k++){
                System.out.println("From Thread c with k="+ 2*(k-1));
            }}
        catch(Exception e){}
        System.out.println("Exiting from Thread C");
    }
}

