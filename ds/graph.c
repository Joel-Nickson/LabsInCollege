#include <stdio.h>
#include <stdlib.h>

int visit[20], count = 0, n = 0;

struct vertex{
  int data;
  struct vertex *link;
} *gptr = NULL;  // group of total pointers //initially null

struct node{
  struct vertex *data;
  struct node *link;
}*TOP = NULL,*FRONT = NULL, *REAR = NULL;


void push(struct vertex *vert){
  struct node *p = malloc(sizeof(struct node));
  p->data = vert;
  p->link = TOP;
  TOP = p;
}

struct vertex *pop(){
  if(TOP == NULL){
    return NULL;
  }
  else{
    struct node *temp = TOP;
    struct vertex *vert;
    vert = temp->data;
    TOP = TOP->link;
    free(temp);
    return vert;
  }
}

void enqueue(struct vertex *vert){
  struct node *p = malloc(sizeof(struct node));
  p->data = vert;
  p->link = NULL;
  if(FRONT == NULL && REAR == NULL){
    FRONT = p;
  }
  else{
    REAR->link = p;
  }
  REAR = p;
}

struct vertex *dequeue(){
  if(FRONT == NULL && REAR == NULL){
    return NULL;
  }
  else{
    struct node *temp = FRONT;
    struct vertex *vert = temp->data;
    if(FRONT == REAR){
      FRONT = NULL;
      REAR = NULL;
    }
    else{
      FRONT = FRONT->link;
    }
    free(temp);
    return vert;
  }
}


void init(){
  int i;
  for(i = 0; i < 20; i++){
    visit[i] = 0;
  }
  count = 0;
}

int visited(struct vertex *u){
  int i;
  for(i = 0; i < count; i++){
    if(visit[i] == u->data){
      return 1; 
    }
  }
  visit[count] = u->data;
  count++;
  return 0;
}


struct vertex *get_gptr(struct vertex *u){
  int i = 0;
  for(i = 0; i < n; i++){
    if(gptr[i].data == u->data){
      return &gptr[i];
    }
  }
}

void dfs(){
  if(gptr == NULL){
    printf("EMPTY GRAPH");
  }
  else{
    init();
    struct vertex *u, *ptr;
    printf("\nDFS:  ");
    push(&gptr[0]);
    while(TOP != NULL){
      u = pop();
      if(visited(u) == 0){
        printf("%d  ", u->data);
        ptr = get_gptr(u);
        ptr = ptr->link;
        while(ptr != NULL){
          push(ptr);
          ptr = ptr->link;
        }
      }
    }
  }
}

void bfs(){
  if(gptr == NULL){
    printf("EMPTY GRAPH");
  }
  else{
    init();
    struct vertex *u, *ptr;
    printf("\nBFS:  ");
    enqueue(&gptr[0]);
    while(FRONT != NULL && REAR != NULL){
      u = dequeue();
      if(visited(u) == 0){
        printf("%d  ", u->data);
        ptr = get_gptr(u);
        ptr = ptr->link;
        while(ptr != NULL){
          enqueue(ptr);
          ptr = ptr->link;
        }
      }
    }
  }
}
void create(){
  
  struct vertex *edge, *ptr;
  int i, j, e;

  printf("\nEnter number of vertices: ");
  scanf("%d", &n);

  gptr = malloc(sizeof(struct vertex) * n); // allocating pointer to hold all the vertices
  
  // Reading values of vertex
  for(i = 0; i < n; i++){
    printf("Enter gptr[%d]: ", i);
    scanf("%d", &gptr[i].data);
    gptr[i].link = NULL;
  }
  
  printf("\nVertices: ");
  for(i = 0; i < n; i++){
    printf("%d  ", gptr[i].data);
  }
  printf("\n");
  
  
  for(i = 0; i < n; i++){
    printf("No. of Edges/ Connections for Vertex '%d': ", gptr[i].data);
    scanf("%d", &e);
    ptr = &gptr[i];
    
    
    for(j = 0; j < e; j++){
      struct vertex *vert = malloc(sizeof(struct vertex));
      ptr->link = vert;
      vert->link = NULL;
      printf("  Enter Edge: ");
      scanf("%d", &vert->data);
      ptr = ptr->link;
    }
  }
  
  printf("\nGenerated Graph is: \n  ");
  for(i = 0; i < n; i++){
    ptr = &gptr[i];
    while(ptr != NULL){
      printf("%d-> ", ptr->data);
      ptr = ptr->link;
    }
    printf("NULL\n  ");
  }
  printf("\n");
}

void main(){
  printf("* GRAPH *");
  create();
  dfs();
  bfs();
  printf("\n");
}