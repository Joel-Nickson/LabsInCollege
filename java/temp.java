
import java.util.*;
import java.io.*;
public class temp{
	public static void main(String agrs[]){
		Random rand = new Random();
	
		for(int i=0;i<20;i++){
			int n=rand.nextInt(7);//0-6
			System.out.println("n="+n);
		}
	}
}
