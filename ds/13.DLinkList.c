//DLL

#include <stdio.h>
#include <stdlib.h>

static int size=0;

struct Node{
  int data;
  struct Node *next;
  struct Node *prev;
} *start=NULL ,*tail=NULL ,*temp;


void insertfront(int item){
  struct Node *p;
  p= (struct Node*)malloc(sizeof(struct Node));
  p->data=item;
  if(start==NULL){
    p->next=NULL;
    start=p;
    tail=p;
  }
  else{
    start->prev=p;
    p->next=start;
    start=p;
  }
  start->prev=NULL;
  size++;
}
void insertend(int item){
  struct Node *p;
  p= (struct Node*)malloc(sizeof(struct Node));
  p->data=item;
  p->next=NULL;
  if(start==NULL){
    start=p;
    tail=p;
    start->prev=NULL;
  }
  else{

    tail->next=p;
    tail->next->prev=tail;
    p->next=NULL;
    tail=p;
  }
  size++;
}
void insertany(int item,int pos){
  struct Node *p;
  p= (struct Node*)malloc(sizeof(struct Node));
  p->data=item;
  p->next=NULL;
  if(start==NULL){
    start=p;
        tail=p;
    start->prev=NULL;
  }
  else if(pos==0){
    start->prev=p;
    p->next=start;
    start=p;
  }
  else if(pos==size){
    tail->next=p;
    p->prev=tail;
    p->next=NULL;
    tail=p;
  }else if(pos==size-1){
      p->prev=tail->prev;
      p->prev->next=p;
      tail->prev=p;
      p->next=tail;
  }
  else{ 
    temp=start;
    for(int i=1 ;i<pos-1 ;i++)
      temp=temp->next;
    
    p->next=temp->next;
    temp->next->prev=p;
    
    temp->next=p;
    p->prev=temp;
  }
  size++;
}
void deletefront(){
  if(start==NULL)
    printf("List Empty\n");
  else{
    printf("%d is removed from front\n",start->data);
    if(size==1){
      temp=start;
      free(temp);
      start=NULL;
      tail=NULL;
    }
    else{
      temp=start;
      start=start->next;
      start->prev=NULL;
      free(temp);
    }
    size--;
  }
}
void deletend(){
  if(start==NULL)
    printf("List Empty\n");
  else{
    printf("%d is removed from end\n",tail->data);
        if(size==1){
          temp=start;
          free(temp);
          start=NULL;
          tail=NULL;
        }
        else{
        tail=tail->prev;
        temp=tail->next;
        tail->next=NULL;
        }
    free(temp);
    size--;
  }
}
void deleteany(int pos){
  if (pos<1){
    printf("%d is removed from front\n",start->data);
    if(size==1){
      temp=start;
      free(temp);
      start=NULL;
    }
    else{
      temp=start;
      start=start->next;
      start->prev=NULL;
      free(temp);
    }
  }
  else if(pos==size-1){
    printf("%d is removed from end\n",tail->data);
    tail=tail->prev;
    temp=tail->next;
    tail->next=NULL;

    free(temp);
  }
  else{
    temp=start;
    struct Node *loc;
    for(int i=1 ;i<pos-2 ;i++){
      temp=temp->next;
    }
    loc=temp->next;
    temp->next=temp->next->next;
    temp->next->prev=temp;

    printf("%d is removed from pos[%d]\n",loc->data,pos);

    free(loc);
  }   
  size--;
  
}
void display(){
  if(start==NULL)
    printf("List Empty\n");
  else{
    printf("\n\t___foreward list___\n");
    temp=start;
    while(temp->next!=NULL){
      printf("%d ->",temp->data);
      temp=temp->next;
    }
    printf("%d\n",temp->data);
  }
}
void revdisp(){
  if(start==NULL)
    printf("List Empty\n");
  else{
    printf("\n\t___reverse list___\n");
    temp=tail;
    while(temp->prev!=NULL){
      printf("%d ->",temp->data);
      temp=temp->prev;
    }
    printf("%d\n",temp->data);
  }
}

int main(){
  int choice,item,pos;    
  printf("-1...reverse display\n");
  printf("1...forward display\n");
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
        case -1: revdisp();
          break;
        case 1: display();
          break;


        case 2: printf("item: ");
            scanf("%d",&item);
          insertfront(item);
          break;


        case 3: printf("item: ");
            scanf("%d",&item);
          insertend(item);    
          break;


        case 4: printf("item: ");
            scanf("%d",&item);
            printf("position: ");
          scanf("%d",&pos);
          if(pos<=size)
              insertany(item,pos);
          else
              printf("Total size is %d\t [0-%d]\n",size,size);
          break;


        case 5: deletefront();
          break;


        case 6: deletend();   
          break;


        case 7: printf("position: ");
            scanf("%d",&pos);
            if(pos<=size-1)
              deleteany(pos);   
            else{
              if(size>0)
                printf("Total size: %d\t [0-%d]\n",size,size-1);
              else
                printf("Empty list\n");
            }
            break;


        case 8: quit=0;
            printf("*****Program aborted*****\n\n");
            break;


        default:
        printf("\n-1...reverse display\n");
        printf("1...forward display\n");
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