import java.io.*;

class Checker {
    public void display(String msg) {
        System.out.println("["+msg);
        
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        System.out.println("]");
    }
}
class Synchronizer implements Runnable {
    String s;
    Checker objch;
    Thread t;
    public Synchronizer(Checker ch ,String msg){
        objch=ch;
        s=msg;
        t=new Thread(this);
        t.start();
    }
    public void run() {
        synchronized(objch) {
            objch.display(s);
        }
    }
}
class Main {
    public static void main(String[] args) {
        Checker cobj =new Checker();
        Synchronizer first= new Synchronizer(cobj,"first");
        Synchronizer second=new Synchronizer(cobj,"second");
        Synchronizer third= new Synchronizer(cobj,"third");    
      
        /*try{
            first.t.join();
            second.t.join();
            third.t.join();
        }
        catch(Exception e){
            System.out.println(e);
        }*/
    }
}