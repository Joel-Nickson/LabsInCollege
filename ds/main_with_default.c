#include <stdio.h>
#include <stdlib.h>

int sz=0;

struct node{
    int data;
    struct node *rchild;
    struct node *lchild;
} *root=NULL ,*tmp ,*parent ,*succ;


void displayinorder(){

}

void insertbst(){
    sz++;
}
void popitem(){
    sz--;
}

int main(){
    int choice;
    int pos;
    printf("1...display\n");
    printf("2...insert\n");
    printf("3...popitem\n");
    printf("4...quit\n");
    
    int quit=1;
    while(quit!=0){
        printf("\nOption : ");
        scanf("%d",&choice);
    	switch(choice){
    		case 1: displayinorder();
    			break;
    		case 2:	insertbst();
    			break;
    		case 3: popitem();
    			break;
    		case 4: quit=0;
                break;
            default:
                printf("\n1...display\n");
                printf("2...insert\n");
                printf("3...popitem\n");
                printf("4...quit\n");
    	}
    }
    
    return 0;
}