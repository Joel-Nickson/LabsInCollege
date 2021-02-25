#include <stdio.h>

//inserting in array
void inserter(int* n, int array[]){
  int i,pos,val;
  printf("\nEnter the position to insert a value[1<x<%d]: ",*n+1);
	scanf("%d",&pos);

  if(pos==*n+1){
    printf("value to insert: ");
    scanf("%d",&val);

    array[pos-1]=val;
    *n+=1;

    printf("\nArray after insertion --> ");
    for(i=0;i<*n-1;i++){
      printf("%d , ",array[i]);
    }printf("%d\n",array[*n-1]);
  }
	else if(pos>=1 && pos<=*n){
    printf("value to insert: ");
    scanf("%d",&val);
    
    for(i=*n;i>pos-1;i--){
      array[i]=array[i-1];
    }
    array[i]=val;
    *n+=1;
    printf("\nArray after insertion --> ");
    for(i=0;i<*n-1;i++){
      printf("%d , ",array[i]);
    }printf("%d\n",array[*n-1]);
  }
  else
		printf("Array index out of bound!");
}

//deleting an element from array
void deleter(int *n,int array[]){
  int i,pos;
  printf("\nEnter the position to be deleted[1<x<%d]: ",*n);
	scanf("%d",&pos);

	if(pos>=1 && pos<=*n){
    for(i=pos-1;i<*n-1;i++){
      array[i]=array[i+1];
    }
    *n-=1;
    printf("Array after deletion --> ");
    for(i=0;i<*n-1;i++){
      printf("%d , ",array[i]);
    }printf("%d\n",array[*n-1]);
  }
  else
		printf("Array index out of bound!");
}

int main(){
  int ans=1;
  printf("Enter the array capacity: ");
  int n;
  scanf("%d",&n);
  int array[n];
  int i;
	printf("\nThen carry on with the elements now\n");
	for(i=0;i<n;i++){
		scanf("%d",&array[i]);
	}
	
	printf("Current Array--> ");
	for(i=0;i<n-1;i++){
		printf("%d , ",array[i]);
	}
	printf("%d\n",array[n-1]);
  while(ans!=0){
    inserter(&n,array);
    deleter(&n,array);
    printf("\n***********press 0 to exit or press any to continue*************\n");
    scanf("%d",&ans);
  }
}