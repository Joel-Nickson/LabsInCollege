import java.io.*;
class Even extends Thread {
    public void run() {
      try {
        FileInputStream fin = new FileInputStream("f1.txt");
        FileOutputStream feven = new FileOutputStream("even.txt");
        for(int i=fin.read();(i!=-1);i=fin.read()) {
          if(i%2==0 && Character.isDigit(i)) {
            feven.write(i);
            feven.write('\n');
          }
        }
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }
}
class Odd extends Thread {
    public void run() {
      try {
        FileInputStream fin = new FileInputStream("f1.txt");
        FileOutputStream fodd = new FileOutputStream("odd.txt");
        for(int i=fin.read();(i!=-1);i=fin.read()) {
          if (i%2!=0 && Character.isDigit(i)) {
            fodd.write(i);
            fodd.write('\n');
          }
        }
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }
}
class Main {
  public static void main(String[] args) {
      Even e = new Even();
      Odd o = new Odd();
      e.start();
      o.start();
      System.out.println("\n file is read from \'f1.txt\' and written to \'odd.txt\' and \'even.txt\' ! ");
  }
}