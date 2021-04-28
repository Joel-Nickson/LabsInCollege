import AdMath.PackageFact;
import java.util.*;

public class PackageFact2{
	public static void main(String args[]){
		PackageFact obj =new PackageFact();
		Scanner sc =new Scanner(System.in);
		System.out.print("Number :");
		int n=sc.nextInt();
		int factVal=obj.fact(n);
		System.out.println("Factorial of "+n+" :"+factVal);
	}
}