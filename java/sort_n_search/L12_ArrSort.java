//selection sort
import java.util.*;
public class ArrSort{
	public static void main(String args[]){
		//int a=512,min=100,max=0;
		int []arr={5,6,7,9,5,4,1,3};
		//Scanner sc= new Scanner(System.in)
		int temp=0;
		//System.out.println("Enter the array: "+arr[0] );
		for(int i=0;i<arr.length;i++){
		    for(int j=i+1;j<arr.length;j++){
		        if(arr[i]>arr[j]){
		            temp=arr[i];
		            arr[i]=arr[j];
		            arr[j]=temp;
		        }    
		    }
		    System.out.print(arr[i]+" ");
		    //System.out.println(a+" "+rem+" "+b );
		}
		//System.out.println("positon of "+search+" is "+(pos+1) );
		
	}
}

//bubble sort
import java.util.*;
public class BBArrSort{
	public static void main(String args[]){
		int []arr={5,6,7,9,5,4,1,3};
		int temp=0;
		for(int i=0;i<arr.length-1;i++){
		    for(int j=0;j<arr.length-i-1;j++){
		        if(arr[j]>arr[j+1]){
		            temp=arr[j];
		            arr[j]=arr[j+1];
		            arr[j+1]=temp;
		        }    
		    }
		}
		for(int i=0;i<arr.length-1;i++)
		    System.out.print(arr[i]+" ");
		
	}
}


















// Java implementation of Counting Sort 
class CountingSort { 
	void sort(char arr[]) 
	{ 
		int n = arr.length; 
		char output[] = new char[n]; 

		int count[] = new int[256]; 
		for (int i = 0; i < 256; ++i) 
			count[i] = 0; 
		
		for (int i = 0; i < n; ++i) 
			++count[arr[i]]; 
		
		for (int i = 1; i <= 255; ++i) 
			count[i] += count[i - 1]; 

		for (int i = n - 1; i >= 0; i--) { 
			output[count[arr[i]] - 1] = arr[i]; 
			--count[arr[i]]; 
		} 

		for (int i = 0; i < n; ++i) 
			arr[i] = output[i]; 
	} 

	public static void main(String args[]) 
	{ 
		CountingSort ob = new CountingSort(); 
		char arr[] = { 'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's' }; 

		ob.sort(arr); 

		System.out.print("Sorted character array is "); 
		for (int i = 0; i < arr.length; ++i) 
			System.out.print(arr[i]); 
	} 
} 
