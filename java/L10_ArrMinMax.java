import java.util.*;
public class ArrMinMax{
	public static void main(String args[]){
		int a=512,min=100,max=0;
		int []arr={5,6,7,9,5,4,1,3};
		//Scanner sc= new Scanner(System.in)
		System.out.println("Enter the array: "+arr[0] );
		//int i=0;
		for(int i=0;i<arr.length;i++){
		    
		    if(arr[i]>max)
		        max=arr[i];
		    if(arr[i]<min)
		        min=arr[i];
		    //System.out.println(a+" "+rem+" "+b );
		}
		System.out.println("max="+max+"\nmin="+min );
		
	}
}