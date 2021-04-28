#include<stdio.h>
#include <stdlib.h>

int sz=0;//stack size
int n=4;
int v=4; 
int count,curr=-1,array[50],visited[4];
int graph[4][4] = {{0, 1, 1, 1},
				   {1, 0, 0, 1},
				   {1, 0, 0, 0},
				   {1, 1, 0, 0}};
                   

// struct stack{
//     int data;
//     struct stack *next;
//     struct stack *prev;
// } *temp ,*head=NULL ,*tail=NULL;

// void push(int item){
//     int val;
//     struct stack *p;
//     p=(struct stack*)malloc(sizeof(struct stack));
//     p->data = item;

//     if(head==NULL){
//         head=p;
//         head->next=NULL;
//         head->prev=NULL;

//         tail=p;
//     }
//     else{
//         tail->next=p;
//         p->prev=tail;//p.prev
//         tail=p;
//         tail->next=NULL;//p.next
//     }
//     sz++;
// }
// int pop(){
// 	int item=-1;
//     if(sz==0)//(temp==NULL)
//         printf("Stack Empty\n");
//     else{
//         temp=tail;
//         item = tail->data;
//         if(head==tail){
//             head=NULL;
//             tail=NULL;
//         }
//         else{
//             tail=tail->prev;
//             tail->next=NULL;
//         }
//         free(temp);
//         sz--;
//     }
//     return item;
// }
void push(int val) {
	curr++;
	array[curr] = val;	
}
int pop() {
	int val;
	if (curr > -1) {
		int val=array[curr];
	    curr--;
	    // printf("Top is poped");
 	 return val;

	} 
	else
		printf("stack Empty\n");
	return -1;
}

// queue
int que[50] ,front=-1 ,rear=-1 ;
void enqueue(int que[] ,int* front ,int* rear ,int item){
	if( *front ==-1 )
		*front=*front+1;
	*rear=*rear+1;
	que[*rear]=item;
	
	//printf("**%d,%d**",*front,*rear);
}

void dequeue(int que[] ,int* front ,int* rear ){
	int item;
	if( *front==-1 || *rear==-1 )
	    printf("Empty Queue\n");
	else{
    	item=que[*front];
		if( *front==*rear ){
			*rear=-1;
			*front=-1;
		}
		else
			*front=*front+1;
	}   
}

void printvis(int arr[]){
	printf("vis = ");
	for(int i=0;i<v;i++)
		printf("%d\t", arr[i]);
	//printf("\n");
}
// void dfs(int start ) { using
//     if(visited[start]==0){
//         visited[start]= 1;
//         enqueue(que,&front,&rear,start);
//         printf(" ->%d",que[front]);
//     }
//     int f= que[front];
//     // printf(" ->%d",f);
//     while(front!=-1) {
//     	f=que[front];
// 	    dequeue(que,&front,&rear);
// 	    for(int i=0;i<v;i++){ 
// 	        if (graph[f][i] == 1 && (visited[i]==0)) { 
// 	        	// printvis(visited);
// 	        	visited[i]= 1;
// 	        	// printvis(visited);
// 	        	// printf("%d\n", i);
// 	    		enqueue(que,&front,&rear,i);
// 	   // 		printf(" ->%d",i);
	    		
// 	    		bfs(i,visited);
// 	    	}
	    
//         }    
//   } 
//     //printf(" ->%d",que[front]);
// }
void bfs(int start){
    int f;
    visited[start]=1;
    enqueue(que,&front,&rear,start);

    while(front!=-1){
        f=que[front];
        for(int i=0;i<v;i++){ 
            if (graph[f][i] == 1 && (visited[i]==0)) { 
                // printvis(visited);
                visited[i]= 1;
                // printvis(visited);
                // printf("%d\n", i);
                enqueue(que,&front,&rear,i);
            }
        }
        printf(" ->%d",f);
        dequeue(que,&front,&rear);
    }

}
 
void dfs(int start){

    printf(" ->%d",start);
    visited[start]= 1;     //curr = top
    for(int i=0;i<v;i++){ 
        if ((graph[start][i]==1) && (visited[i]==0)) { 
            dfs(i);
        }
    }  
}

// void bfs(int start ){ //using  stack
//     visited[start]= 1;
//     push(start);
//     printf(" ->%d",start);
//     int j=0;
//     int t;
//     while(curr>-1) { 
//         t=pop();
//         for(int i=0;i<v;i++){ 
//             if ((graph[t][i]==1) && (visited[i]==0)) { 
//                 visited[i]= 1;
//                 push(i);
//                 printf(" ->%d",i);
//             }
//         }      
//         j++;
//     } 
// }

void displayMatrix(){
    printf("\tAdjcency Matrix\n");
    for(int i=0;i<v;i++){
        for(int j=0;j<v;j++){
            printf("%d\t",graph[i][j]);
        }
        printf("\n");
    }
}
void displayadjlist(){
    printf("\tAdjcency List\n");
    for(int i=0;i<v;i++){
        printf("%d :",i);
        for(int j=0;j<v;j++){
            if(graph[i][j]==1)
                printf(" ->%d",j);
        }
        printf("\n");
    }
}

void setvisitedtofalse(){
    for(int i=0;i<v;i++)
        visited[i]=0;
}


int main(){
    
    // int visited[4];
    int choice;
    int start;
    
    // displayadjlist();
    printf("1...display\n");
    printf("2...dfs\n");
    printf("3...bfs\n");
    printf("4...quit\n");
    
    int quit=1;
    while(quit!=0){
        setvisitedtofalse();
        printf("\nOption : ");
        scanf("%d",&choice);
    	switch(choice){
    		case 1: displayMatrix();
            displayadjlist();
    			break;
    		case 2:printf("enter the start element: ");
    		    scanf("%d",&start);
    		    printf("dfs[%d]",start);
    		    dfs(start);
    			break;
    		case 3:printf("enter the start element: ");
    		    scanf("%d",&start);
    		    printf("bfs[%d]",start);
    		    bfs(start);
    			break;
    		case 4: quit=0;
                break;
            default:
                printf("\n1...display\n");
                printf("2...dfs\n");
                printf("3...bfs\n");
                printf("4...quit\n");
    	}
    }
    return 0;
}