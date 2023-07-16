package Umang;

public class Threading6 {
    public static void main (String[] args){
        Thread t1= new Thread(new Thread1());
        Thread t2= new Thread(new Thread2());
        t1.start();
        t2.start();
        try {
            System.out.println("Resume second thread if it was suspended");
            t2.resume();
            System.out.println("Second thread starts running again");
            t2.sleep(1000);
            System.out.println("Second thread starts running again after 1000 ms");
        }
        catch(Exception e){}
        System.out.println("End of execution");
    }
}

class Thread1 extends Thread{
    public void run() {
        try {
            System.out.println("First thread starts running");
            sleep(1000);
            System.out.println("First thread finishes running");
        } catch (Exception e) {
        }
    }
}

class Thread2 extends Thread{
    public void run() {
        try {
            System.out.println("Second thread starts running");
            suspend();
            System.out.println("Second suspended");
        } catch (Exception e) {}
    }
}
