import java.util.*;

public class BinSearch{

	boolean bSearch(int arr[],int key){
		int lo=0 ,hi=arr.length-1 ,mid=(hi+lo)/2;
		showArr(arr);

		while( lo<=hi ){
			if (arr[mid]>key)
				hi=mid-1;
			else if (arr[mid]<key)
				lo=mid+1;
			else if (arr[mid]==key)
				return true;
			mid=(lo+hi)/2;
		}
		return false;
	}

	void showArr(int arr[]){
		for(int i:arr){
			System.out.print(i+"\t");
		}
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int sz,arr[],key;
		System.out.print("Enter the size of arr: ");
		sz=sc.nextInt();
		arr=new int[sz];
		System.out.println("\nEnter the arr elements");
		for(int i=0 ;i<sz ;i++)
			arr[i]=sc.nextInt();
		System.out.print("\nEnter the key to find: ");
		key = sc.nextInt();		
		
		// arr=new int[]{5,5,3,4,7,8,1};
		// key=1;

		BinSearch ob=new BinSearch();
		Arrays.sort(arr);

		boolean check=ob.bSearch(arr,key);
		if(check)
			System.out.println("Key found");
		else
			System.out.println("Key not found");
	}
}