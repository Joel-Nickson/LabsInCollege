#include <stdio.h>
#include <stdlib.h>

#define n 4
void showarr(int arr[]){
    printf("\n");
    for(int i=0 ;i<n ;i++){
        printf("%d\t",arr[i]);
    }
}
void linearSearch(int arr[], int key){
    printf("\n********Linear Search*********");
    showarr(arr);
	int i;
	for(i=0; i<n; i++){
		if(arr[i]==key)
			break;
	}
	if(key==arr[i])
		printf("\n-- key is found at a[%d] in unsorted array--\n", i);
	else
		printf("\n-- key not found --\n");
}

int cmpfunc (const void *a, const void *b) {
   return (*(int*)a > *(int*)b);
}
/*void sort(int arr[]){
	int tmp;
	for(int i=0 ;i<n-1 ;i++){
		for(int j=0 ;j<n-i-1 ;j++){
			if(arr[j]>arr[j+1]){
				tmp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=tmp;
			}
		}
	}
}*/
void binSerach(int arr[], int key){
    printf("\n********Binary Search*********");
	qsort(arr,n,sizeof(int),cmpfunc);
	//sort(arr);
	showarr(arr);

	int low=0 ,high=n-1 ,mid=0 ;
	while(key!=arr[mid] && low<high){
		if(key<arr[mid])
			high=mid-1;
		else
			low=mid+1;
		mid=(low+high)/2;
	}
	if(key==arr[mid])
		printf("\n-- key is found at a[%d] in sorted array--", mid);
	else
		printf("\n-- key not found --");
}

int main(){


	int arr[n], s;
	printf("Enter the array elements -->");
	for(int i=0 ;i<n ;i++){
		scanf("%d",&arr[i]);
	}

	printf("Enter the element to search for:");
	scanf("%d",&s);

	linearSearch(arr,s);
	binSerach(arr,s);
}