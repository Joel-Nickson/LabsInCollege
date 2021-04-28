//import java.io.*;
public class Transpose{
	public static void main(String args[]){
		int m1[][]= {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Matrix Multipilcation of:");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(m1[i][j]+" " );
            }
            System.out.println();
        }
        System.out.println(";");

		int ans[][] = new int[3][3]; 
		for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                ans[i][j]=m1[j][i];
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(ans[i][j]+" " );
            }
            System.out.println();
        }

        
	}
}