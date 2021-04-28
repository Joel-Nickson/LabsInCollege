import java.io.*;

public class MatrixMul{
    public static void main(String args[]){
        int m1[][]= {{1,2,3},{4,5,6},{7,8,9}};
        int m2[][]= {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println();
		System.out.println("Matrix Multipilcation of:");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(m1[i][j]+" " );
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(m2[i][j]+" " );
            }
            System.out.println();
        }
		int ans[][] = new int[3][3]; 
  
        System.out.println("------------is----------");
        // Multiply the two marices 
        for (int i=0; i<3;i++) { 
            for (int j=0; j<3 ; j++) { 
                for (int k=0; k<3; k++) 
                    ans[i][j] += m1[i][k] * m2[k][j]; 
            } 
        } 
        System.out.println();
		for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(ans[i][j]+" " );
            }
            System.out.println();
        }
	}

}