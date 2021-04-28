import java.util.*;
import java.io.*;

class T_two extends Thread{
	int num;
	public T_two(int val){
		num = val;
	}
	public void run(){
		System.out.println("Two-sqr["+num+"] : "+num*num);
	}

}
class T_three extends Thread{
	int num;
	public T_three(int val){
		num = val;
	}
	public void run(){
		System.out.println("Three-cube["+num+"] : "+num*num*num);
	}

}
class T_one extends Thread{
	Random r;
	int one;

	public T_one(Random r){
		this.r=r;	}
	public void run(){
		try{
			for(int i=0;i<10;i++){
				one = r.nextInt(1000);
				if(one%2==0){
					T_two two = new T_two(one);
					two.start();
				}
				else {
					T_three three = new T_three(one);
					three.start();
				}
				Thread.sleep(1000);
			}
		}
		catch(Exception e){
			System.out.println("error: "+e);//.getMessage);
		}
	}
}


public class RandOddEvenSqrCube{
	public static void main(String args[]){
		Random rand = new Random();

		T_one one = new T_one(rand);
		one.start();
	}
}