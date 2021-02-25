//SLL

#include <string.h>
#include <stdio.h>
#include <stdlib.h>

static int size=0;

struct Node {
	int data;
	struct Node *link;
} *start=NULL ,*temp ; 	


void insertfront(int item){
	struct Node *p;
	p= (struct Node*)malloc(sizeof(struct Node));
	p->data=item;
	if(start==NULL){
		p->link=NULL;
		start=p;
	}
	else{
		p->link=start;
		start=p;
	}
	size++;
}
void insertend(int item){
	struct Node *p;
	p= (struct Node*)malloc(sizeof(struct Node));
	p->data=item;
	p->link=NULL;
	if(start==NULL){
		start=p;
	}
	else{
		temp=start;
		while(temp->link!=NULL){
			temp=temp->link;
		}
		temp->link=p;
	}
	size++;
}
void insertany(int item,int pos){
	struct Node *p;
	p= (struct Node*)malloc(sizeof(struct Node));
	p->data=item;
	p->link=NULL;
	if(start==NULL){
		start=p;
	}
  	else if(pos<=1){
	    p->link=start;
	    start=p;
	}
	else{
		temp=start;
		for(int i=1 ;i<pos-1 ;i++)
			temp=temp->link;

		p->link=temp->link;
		temp->link=p;
	}
	size++;
}
void deletefront(){
	if(start==NULL)
		printf("List Empty\n");
	else{
	    if(size==1){
          temp=start;
          start=NULL;
	    }
	    else{
    		temp=start;
    		start=start->link;
	    }
	    
		printf("%d is removed from front\n",temp->data);
		free(temp);
		size--;
	}
}
void deletend(){
	if(start==NULL)
		printf("List Empty\n");
	else{
	    if(size==1){
          printf("%d is removed from end\n",start->data);
          temp=start;
          start=NULL;
          free(temp);
	    }
	    else{
    		temp=start;
    		struct Node *loc;
    		loc=temp->link;
    		while(loc->link!=NULL)
    			loc=loc->link;
    			temp=temp->link;
    		printf("%d is removed from end\n",loc->data);
    		temp->link=NULL;
    		free(loc);
    		size--;
	    }
	}
}
void deleteany(int pos){
	if(start==NULL || size==0)
		printf("List Empty\n");
    else if (pos<1){
        printf("%d is removed from front\n",start->data);
        if(size==1){
          temp=start;
          free(temp);
          start=NULL;
        }
        else{
          temp=start;
          start=start->link;
          free(temp);
        }
    }
    else if(pos==size-1){
        
	    if(size==1){
          temp=start;
          start=NULL;
          printf("%d is removed from end\n",temp->data);
          free(temp);
	    }
	    else{
    		temp=start;
    		struct Node *loc;
    		loc=temp->link;
    		while(loc->link!=NULL)
    			loc=loc->link;
    			temp=temp->link;
    		printf("%d is removed from end\n",loc->data);
    		temp->link=NULL;
            free(loc);
	    }
    }
	else{
	    if(size==1){
          temp=start;
          start=NULL;
          printf("%d is removed from front\n",temp->data);
          free(temp);
	    }
	    else{
    		temp=start;
    		struct Node *loc;
    		loc=temp->link;
    		for(int i=1; i<pos-1; i++){
    			loc=loc->link;
    			temp=temp->link;
    		}
    		printf("%d is removed \n",loc->data);
    		temp->link=loc->link;
    
    		free(loc);
	    }
	}		
	size--;
}
void display(){
	if(start==NULL)
		printf("List Empty\n");
	else{
		printf("");
		temp=start;
		while(temp->link!=NULL){
			printf("%d ->",temp->data);
			temp=temp->link;
		}
		printf("%d\n",temp->data);
	}
}

int main(){
	int choice,item,pos;    
	printf("1...display\n");
  printf("2...insertfront\n");
	printf("3...insertend\n");
	printf("4...insertany\n");
  printf("5...deletefront\n");
	printf("6...deletend\n");
	printf("7...deleteany\n");
  printf("8...quit\n");
	printf("else...menu\n");

    int quit=1;
    while(quit!=0){
        printf("\nOption : ");
        scanf("%d",&choice);
    	switch(choice){
    		case 1: display();
    			break;
    		case 2:	printf("item: ");
    		    scanf("%d",&item);
    			insertfront(item);
    			break;
    		case 3: printf("item: ");
    		    scanf("%d",&item);
    			insertend(item);		
    			break;
    		case 4:	printf("item: ");
    		    scanf("%d",&item);
    		    printf("position: ");
    			scanf("%d",&pos);
    			if(pos<=size)
    			    insertany(item,pos);
    			else
    			    printf("total size: %d\t [%d : %d)\n",size,0,size);
    			break;
    		case 5:	deletefront();
    			break;
    		case 6: deletend();		
    			break;
    		case 7: printf("position: ");
    		    scanf("%d",&pos);
    		    if(pos<=size-1 || size==0)
    			    deleteany(pos);		
    			else
    			    printf("total size: %d\t [%d : %d]\n",size,0,size-1);
    			break;
    		case 8: quit=0;
    		    printf("*****Program aborted*****");
    		    break;
    		default:
				  printf("\n1...display\n");
			    printf("2...insertfront\n");
				  printf("3...insertend\n");
				  printf("4...insertany\n");
			    printf("5...deletefront\n");
				  printf("6...deletend\n");
				  printf("7...deleteany\n");
			    printf("8...quit\n");
			    printf("else...menu\n");

    	}
    }   
    
    return 0;
	
} 