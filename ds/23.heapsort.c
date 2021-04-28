#include<stdio.h>
#include <math.h>

int array[50] ,len, sz, start=1;


void printarray(int arr[] ,int start ,int len){
	for(int i=start ;i<=len ;i++){
		printf("%d\t",arr[i]);
	}
}

void swap(int i,int j,int arr[]){
	int tmp;
	tmp=arr[i];
	arr[i]=arr[j];
	arr[j]=tmp;
}

/*void rise(int  arr[], int i){	//maxheap recursion
	if(i>1 && arr[i]>arr[i/2]){
		swap(i , i/2 , arr);
        // printf("\t\t");
        // printarray(arr,1,len+1);
        // printf("\n");

		rise(arr , i/2);
	}
}
void fall(int arr[], int i){
	if(2*i+1<len){
		if( arr[2*i]>arr[(2*i)+1]&&arr[2*i]>arr[i] )
			i=2*i;
		else if( arr[2*i]<arr[(2*i)+1]&&arr[(2*i)+1]>arr[i])
			i=(2*i)+1;
	}
	else if(2*i<len&&arr[2*i]>arr[i])
		i=2*i;

    // printf("\t\t");
    // printarray(arr,1,len);
    // printf("\n");
	if( i>1 && arr[i]>arr[i/2] ){
		swap(i , i/2 , arr);
		fall(arr , i);
	}
}*/

void fall(int arr[], int i){
	while(i<len){
		if( 2*i+1<=len ){
			if( arr[2*i]>arr[2*i+1] && arr[2*i]>arr[i] )
				i=2*i;
			else if( arr[2*i]<arr[2*i+1] && arr[2*i+1]>arr[i] )
				i=2*i+1;
		}
		else if( 2*i<=len && arr[2*i]>arr[i] )
			i=2*i;
		
// 		printf("\t\t");
//      printarray(arr,1,len);
//      printf("\n");
		if( arr[i]>arr[i/2] && i>1)
			swap(i ,i/2 ,arr);
		else
			break;
	}

}

int heappop(int arr[]){
    int hpop=arr[1];
    swap(1,len,arr);
    len--;
    fall(arr,1);
    
    return hpop;
}

void heapify(int arr[]){
	int i=len/2;
	while(i>=1){	    
    // 	printf("\t");
    // 	printarray(arr,1,len);
    // 	printf("\n");
    	if(arr[i]<arr[2*i] || arr[i]<arr[2*i+1])
		    fall(arr,i);
		i--;
	}
}

void rise(int  arr[], int i){	//maxheap
	while(i>1 && arr[i/2]<arr[i]){
		swap(i ,i/2 ,arr);
		i=i/2;
	}
}

void heappush(int arr[] ,int val){
    len++;
    arr[len]=val;
    rise(arr,len);
}

void heapsort(int arr[]){
	int i = len, j, lchild, rchild;
	while(i > 1){
// 		printf("\n\tsort order : ");
//         printarray(arr,1,len);
		if(arr[1] > arr[i]){
// 			printf("\n\tSwap %d <-> %d", arr[1], arr[i]);
			swap(1,i,arr);
		}
		i--;
		j = 1;
		while(j < i){
			lchild = 2 * j;
			rchild = 2 * j + 1;
			if(lchild < i){
				if(rchild < i){
					if((arr[lchild] > arr[j]) && (arr[lchild] > arr[rchild])){
				// 		printf("\n\t swap %d <-> %d", arr[j], arr[lchild]);
						swap(j,lchild,arr);
						j = lchild;
					}
					else if((arr[rchild] > arr[j]) && (arr[rchild] > arr[lchild])){
				// 		printf("\n\t swap %d <-> %d", arr[j], arr[rchild]);
						swap(j,rchild,arr);
						j = rchild;
					}
				}
				else{
					if(arr[lchild] > arr[j]){
				// 		printf("\n\t swap %d <-> %d", arr[j], arr[lchild]);
						swap(j,lchild,arr);
						j = lchild;
					}
				}
			}
		}
	}
// 	printf("\n\n\t");
	printf("sort order: ");
    printarray(arr,1,len);
	printf("\n");
}

int main(){
	len=7;
	int array[]={-1000,5,3,8,2,7,9,1};
// 	printf("enter the array size : ");
// 	scanf("%d",&len);
	
// 	printf("enter the array elements : ");
// 	for(int i=1;i<=len;i++)
// 	    scanf("%d",&array[i]);
	heapify(array);
	sz=len;
	
    int choice, val;

    //printf("\n1...heapify\n");
    printf("\n0...display\n");
    printf("1...heap sort\n");
    printf("2...heap insert\n");
    printf("3...heap pop\n");
    printf("4...quit\n");

    int quit=1;
    while(quit!=0){
        printf("\nOption : ");
        scanf("%d",&choice);
        switch(choice){
            // case -1: heapify(array);
            //     printf("elements are heapsorted\n");
            //     break;
            case 0: printf("heap order: ");                
                printarray(array,1,len);
                printf("\n");
                break;

            case 1:heapsort(array);
            	heapify(array); 
                break;  

            case 2: if(len<sz){
                    printf("what do i insert ? ");
                    scanf("%d",&val);
                    heappush(array,val);
                }
                else
                    printf("heaparray is full\n");
                break;

            case 3: if(len>=1){
                    val=heappop(array);
                    printf("%d is removed\n",val);
                }
                else
                    printf("Heap empty\n");
                break;
            
            case 4: printf("***program terminated*** ");
                quit=0;
                break;
            default:
                // printf("\n1...heapify\n");
			    printf("\n0...display\n");
			    printf("1...heap sort\n");
			    printf("2...heapinsert\n");
			    printf("3...heapdelete\n");
			    printf("4...quit\n");
        }
    }
}

/*
#include<stdio.h>

//int arr[50] ,b[50];
int array[50] ,len, sz, start=1;


void rise(int  arr[], int i){	//maxheap
	while(i>1){
		if(i>1 && arr[i/2]<arr[i]){
			swap(i , i/2 , arr);
			i=i/2;
		}
		else
			break;
		
	}
}
void fall(int arr[], int i){
	while(i<len){
		if( 2*i+1<=len ){
			if( arr[2*i]>arr[(2*i)+1]&&arr[2*i]>arr[i] )
				i=2*i;
			else if( arr[2*i]<arr[(2*i)+1]&&arr[(2*i)+1]>arr[i] )
				i=2*i+1;
		}
		else if( 2*i<=len&&arr[2*i]>arr[i] )
			i=2*i;
		
// 		printf("\t\t");
//      printarray(arr,1,len);
//      printf("\n");
		if( arr[i]>arr[i/2] )
			swap(i ,i/2 ,arr);
		else
			break;
	}

}

*/