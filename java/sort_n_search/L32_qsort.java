import java.util.*;

class Main {  
    static int arr[];
    
    public static void swap(int i, int j){
        int tmp;
        tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    
    public static void printarr(int array[]){
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+"\t"); 
        System.out.println(); 
    }
    
    public static void quicksort(int first, int last){
        if(first<last){
            int i,j,pivot;
            i=first;
            j=last;
            pivot=arr[first];
            while(i<j){
                while(arr[i]<=pivot && i<last)
                    i++;
                while(arr[j]>=pivot && j>first)
                    j--;
                if(i<j){
                    swap(i,j);
                }
            }
            swap(j,first);
            System.out.println(Arrays.toString(arr));
            quicksort(first,j-1);
            quicksort(j+1,last);
        }
    }
    public static void main(String args[]) {
        int sz;
        Scanner sc=new Scanner(System.in);
        
        System.out.print("Enter the no of elements:"); 
        sz=sc.nextInt();
        arr=new int[sz];
        //arr=new int[]{4,5,8,3,6,1,9};
        System.out.print("Enter the array elements:"); 
        for(int i=0;i<sz;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("array before qsort:");
        System.out.println(Arrays.toString(arr));
        int len=arr.length;
        System.out.println();
        quicksort(0,len-1);
        
        System.out.print("\narray after qsort:");
        System.out.println(Arrays.toString(arr));
        
  } 
}