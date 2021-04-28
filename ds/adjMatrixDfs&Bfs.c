#include<stdio.h>
#include <stdlib.h>

int sz=0;//stack size
int n=4;
int v=4;
int count;
int graph[4][4] = {{0, 1, 0, 1},
				   {1, 0, 0, 0},
				   {0, 0, 0, 1},
				   {1, 0, 1, 0}};
// stack
struct stack{
    int data;
    struct stack *next;
    struct stack *prev;
} *temp ,*head=NULL ,*tail=NULL;

void push(int item){
    int val;
    struct stack *p;
    p=(struct stack*)malloc(sizeof(struct stack));
    p->data = item;

    if(head==NULL){
        head=p;
        head->next=NULL;
        head->prev=NULL;
        tail=head;
    }
    else{
        tail->next=p;
        tail->next->prev=tail;//p.prev
        tail=p;
        tail->next=NULL;//p.next
    }
    sz++;
}
void pop(){
    if(sz==0)//(temp==NULL)
        printf("Stack Empty\n");
    else{
        if(head==tail){
            head=NULL;
            tail=NULL;
        }
        else{
            temp=tail;
            tail=tail->prev;
            tail->next=NULL;
            free(temp);
        }
        sz--;
    }
}
void bfs(int start, int visited[]){
    visited[start]= 1;
    push(start);
    while(head!=NULL) { 
    	for(int i=0;i<v;i++){ 
	        if ((graph[tail->data][i]==1) && (visited[i]==0)) { 
	        	visited[i]= 1;
	        	push(i);
	        }
        } 
        printf(" ->%d",tail->data);
        pop();
    } 
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

void dfs(int start, int visited[]) {
    visited[start]= 1;
    enqueue(que,&front,&rear,start);
    
    while(front!=-1) {
	    for(int i=0;i<v;i++){ 
	        if (graph[front][i] == 1 && (visited[i]==0)) { 
	        	visited[i]= 1;
	    		enqueue(que,&front,&rear,i);
	    	}
        } 
	    printf(" ->%d",que[front]);
	    dequeue(que,&front,&rear);
    } 
} 
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

void setvisitedtofalse(int visited[]){
    for(int i=0;i<v;i++)
        visited[i]=0;
}


int main(){
    
    int visited[4];
    int choice;
    int start;
    
    // displayadjlist();
    printf("1...display\n");
    printf("2...dfs\n");
    printf("3...bfs\n");
    printf("4...quit\n");
    
    int quit=1;
    while(quit!=0){
        setvisitedtofalse(visited);
        printf("\nOption : ");
        scanf("%d",&choice);
    	switch(choice){
    		case 1: displayadjlist();
    			break;
    		case 2:printf("enter the start element: ");
    		    scanf("%d",&start);
    		    printf("dfs[%d]",start);
    		    dfs(start,visited);
    			break;
    		case 3:printf("enter the start element: ");
    		    scanf("%d",&start);
    		    printf("bfs[%d]-",start);
    		    bfs(start,visited);
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