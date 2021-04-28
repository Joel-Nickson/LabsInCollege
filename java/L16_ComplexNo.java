import java.util.*;

class Complex{
	int i,r;
	Complex(int a, int b){
		i=a;
		r=b;
	}
}
public class ComplexNo{
	static int real=0,img=0;
	static void complxAdd(Complex a, Complex b){
		real=a.r+b.r;
		img=a.i+b.i;
		System.out.println("\nComplex1->"+a.r+"+i"+a.i);
		System.out.println("Complex2->"+b.r+"+i"+b.i);
	}
	public static void main(String args[]){
		int a,b;
		Scanner sc =new Scanner(System.in);

		System.out.println("*****complex 1*****");    
		System.out.print("imaginary :");
		a=sc.nextInt();
		System.out.print("real :");
		b=sc.nextInt();
		Complex c1=new Complex(a,b);
		
		System.out.println("\n*****complex 2*****");    
		System.out.print("imaginary :");
		a=sc.nextInt();
		System.out.print("real :");
		b=sc.nextInt();
		Complex c2=new Complex(a,b);
		complxAdd(c1,c2);
		System.out.println("Complex Sum->"+real+"+i"+img);
    	sc.close();		
	}
}