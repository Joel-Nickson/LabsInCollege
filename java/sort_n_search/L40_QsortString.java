import java.util.*;

class QsortString {  
    static String arr[];
    
    public static void swap(int i, int j){
        String tmp;
        tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    
    public static void printarr(String array[]){
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+"\t"); 
        System.out.println(); 
    }
    
    public static void quicksort(int first, int last){
        if(first<last){
            int i,j;
            String pivot;
            i=first;
            j=last;
            pivot=arr[first];
            while(i<j){
                while((arr[i].toLowerCase()).compareTo(pivot.toLowerCase())<=0 && i<last)
                    i++;
                while((arr[j].toLowerCase()).compareTo(pivot.toLowerCase())>=0 && j>first)
                    j--;
                if(i<j){
                    swap(i,j);
                }
            }
            swap(j,first);
            // System.out.println(Arrays.toString(arr));
            quicksort(first,j-1);
            quicksort(j+1,last);
        }
    }
    public static void main(String args[]) {
        int sz;
        Scanner sc=new Scanner(System.in);
        
        System.out.print("\nEnter the no of elements:"); 
        sz=sc.nextInt();

        arr=new String[sz];
        System.out.print("Enter the array elements:"); 
        for(int i=0;i<sz;i++){
            arr[i]=sc.next();
        }
        // arr=new String[4]{"hello","joel","animal","nickson"};

        System.out.print("\narray before qsort:");
        System.out.println(Arrays.toString(arr));

        int len=arr.length;
        quicksort(0,len-1);
        
        System.out.print("array after qsort:");
        System.out.println(Arrays.toString(arr));
        
  } 
}