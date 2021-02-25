#include <stdio.h>
#include <stdlib.h>

int sz=0;

struct que{
    int data;
    struct que *next;
    struct que *prev;
} *temp ,*head=NULL ,*tail=NULL;

void display(){
    temp=head;
    if(sz==0)//(temp==NULL)
        printf("Queue Empty");
    else{
        printf("%d ",temp->data);
        temp=temp->next;
        while(temp!=NULL){
            printf("->%d ",temp->data);
            temp=temp->next;
        }
    }
    printf("\n");
}
void revdisp(){
    temp=tail;
    if(sz==0)//(temp==NULL)
        printf("Queue Empty");
    else{
        printf("%d",temp->data);
        temp=temp->prev;
        while(temp!=NULL){
            printf("<- %d",temp->data);
            temp=temp->prev;
        }
    }
    printf("\n");
}

void append(){
    int val;
    struct que *p;
    p=(struct que*)malloc(sizeof(struct que));
    
    printf("Enter the val: ");
    scanf("%d",&(p->data));
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

void popleft(){
    if(sz==0)//(temp==NULL)
        printf("Queue Empty\n");
    else{
        printf("%d is removed\n",head->data);
        if(head==tail){
            head=NULL;
            tail=NULL;
        }
        else{
            temp=head;
            head=head->next;
            head->prev=NULL;
            free(temp);
        }
        sz--;
    }
}

int main(){
    int choice;
    int pos;
    printf("1...display\n");
    printf("2...append\n");
    printf("3...popleft\n");
    printf("4...quit\n");
    
    int quit=1;
    while(quit!=0){
        printf("\nOption : ");
        scanf("%d",&choice);
    	switch(choice){
    		case 1: display();
    			break;
    		case 2:	append();
    			break;
    		case 3: popleft();
    			break;
    		case 4: quit=0;
    		    printf("Exiting from program");
    		    break;
    		default:
                printf("\n1...display\n");
                printf("2...append\n");
                printf("3...popleft\n");
                printf("4...quit\n");
    	}
    }

    return 0;
}