import java.util.*;
public class RevNum{
	public static void main(String args[]){
		int a=512,b=0,rem=0;
		//Scanner sc= new Scanner(System.in)
		System.out.println("Enter a number: "+a );
		int i=0;
		while(a>0){
		    //System.out.println(a+" "+rem+" "+b );
		    rem=a%10;
		    b=(10*b)+rem;
		    a=a/10;
		}
		System.out.println("RevNum="+b );
		
	}
}