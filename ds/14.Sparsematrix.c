#include <stdio.h>

#define n 3
#define m 3
int arr[n][m];

int insertVal(int arr[][]){
	int k=0;
	printf("Input the array values\n");
	for(int i=0;i<n;i++){
		for(int j=0;j<m;j++){
		    printf("a[%d][%d] :",i ,j);
		    scanf("%d",&a[i][j]);
		    if(a[i][j]!=0){
		    	k++;
		    }
	    }
	}
	return k;
}

*int sparsthrough(int arr[][] ,int k){

	int spar[k+1][3];
	spar[0][0]=n;
	spar[0][1]=m;
	spar[0][2]=k;
	count=1;
	for(int i=;i<n;i++){
		for(int j=0 ;j<m ;j++){
			if(arr[i][j]!=0){
				spar[count][0]=i;
				spar[count][1]=j;
				spar[count][2]=a[i][j];
			}
		}
	}
	return spar;
}

void main(){
	int k;
	k=insertVal(arr);
	spar[][]=sparsthrough(arr,k);


}