import java.io.*;
public class Main{
	public static void main(String args[])throws IOException{
		int a,b;
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 2 numbers : ");
		a=Integer.parseInt(br.readLine());
		b=Integer.parseInt(br.readLine());
		System.out.println("Sum of "+a+" and "+b+" ="+ (a+b));
	}
}