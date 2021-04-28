import java.util.*;
public class SearchArr{
	public static void main(String args[]){
		//int a=512,min=100,max=0;
		int []arr={5,6,7,9,5,4,1,3};
		//Scanner sc= new Scanner(System.in)
		int search=9,pos=0;
		System.out.println("Enter the array: "+arr[0] );
		for(int i=0;i<arr.length;i++){
		    
		    if(arr[i]==search){
		        pos=i;
		        break;
		    }
		    //System.out.println(a+" "+rem+" "+b );
		}
		System.out.println("positon of "+search+" is "+(pos+1) );
		
	}
}