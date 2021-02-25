#include <stdio.h>

#define n 3
int que[n] ,front=-1 ,rear=-1 ;


void enqueue(int que[] ,int* front ,int* rear ){
	if( (*rear+1)%n == *front)
	{
		printf("Queue is full\n");	
		return;
	}
	if( *front ==-1 )
	{
		*front=(*front+1)%n;
	}
	int item; 
	printf("What should I insert? :  ");
    scanf("%d",&item);
	
	*rear=(*rear+1)%n;
	que[*rear]=item;
	
	//printf("**%d,%d**",*front,*rear);
}

void dequeue(int que[] ,int* front ,int* rear ){
	int item;
	if( *front==-1 && *rear==-1 ){
	    printf("Empty Queue\n");
	}
	else{
    	item=que[*front];
		if( *front==*rear ){
			*rear=-1;
			*front=-1;
		}
		else{
    		//que[*front]='\0';
			*front=(*front+1)%n;
		}
        printf("%d is removed\n",item); 
	}   
	//printf("**%d,%d**",*front,*rear);
}

void display(int que[] ,int front ,int rear){
	if( front==-1 && rear==-1 ){
		printf("Queue is empty\n");
	}
	else
	{
	    int i=front;
	    if((i+1)%n==(rear+n-1)%n)
	    {
	        while((i+1)%n!=rear)
	        {
				printf("%d\t",que[i]);
				if(i==(front+n-1)%n)
				    break;
				i=(i+1)%n;
			}
	    }
		while((i+1)%n!=(rear+n-1)%n)
		{
			printf("%d\t",que[i]);
			if(i==(front+n-1)%n)
			    break;
			i=(i+1)%n;
		}
		printf("\n");
	}
	//printf("**%d,%d**",front,rear);
}

int main(){
	//printf("Enter the total size of the Queue : ");
    //int n=3;
    //scanf("%d", & n);
    int choice;
    int item=0;
    printf("1...display\n");
    printf("2...enque\n");
    printf("3...deque\n");
    printf("4...quit\n");
    
    int quit=1;
    while(quit!=0){
        printf("\nOption : ");
        scanf("%d",&choice);
    	switch(choice){
    		case 1: display(que,front,rear);
    			break;
    		case 2:	enqueue(que,&front,&rear);
    			break;
    		case 3: dequeue(que,&front,&rear);			
    			break;
    		case 4: quit=0;
    		    printf("*****Program aborted*****");
    	}
    }   
    return 0; 
}