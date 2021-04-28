import java.util.*;
public class MatrixAdd{
	public static void main(String args[]){
		//int a=512,min=100,max=0;
		int [][]mat1={{5,6,7},{9,5,4},{1,3,2}};
		int [][]mat2={{1,1,1},{1,1,1},{1,1,1}};
		int [][]matrix =new int[3][3];
		//Scanner sc= new Scanner(System.in)
		int temp=0;
		//System.out.println("Enter the array: "+arr[0] );
		for( int i=0 ;i<3 ;i++ ){
		    for( int j=0 ;j<3 ;j++ ){
		        matrix[i][j]=mat1[i][j]+mat2[i][j];
		    }
		    //System.out.println(a+" "+rem+" "+b );
		}
		for( int i=0 ;i<3 ;i++ ){
		    for( int j=0 ;j<3 ;j++ ){
		        
		        System.out.print(matrix[i][j]+" ");
		    }
		    System.out.println();
		}
		
	}
		//System.out.println("positon of "+search+" is "+(pos+1) );
}