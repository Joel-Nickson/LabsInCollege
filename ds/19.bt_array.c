#include <stdio.h>

#define n 65

int arr[n],stack[n/2],root,tmp=0,i,x=0,sz=0,last=0;
int R=0,L=0;

//searchkey without recurrsion
int searchkey2(int j,int key){
    int top=0,i=-1;
    tmp=arr[j];
    while(i!=-1 || j!=-1){
        if(tmp==key)
            return j;
        if(i>=0 && arr[2*j]==0 && arr[2*j+1]==0){
            j=stack[i];
            j=2*j+1;
            tmp=arr[j];
            --i;
        }
        else if(arr[2*j]==0 && arr[2*j+1]!=0){
            j=2*j+1;
            tmp=arr[j];
        }
        else if(arr[2*j+1]==0 && arr[2*j]!=0){
            j=2*j;
            tmp=arr[j];
        }
        else if(arr[2*j]!=0 && arr[2*j+1]!=0){
            i++;
            stack[i]=j;
            j=2*j;
            tmp=arr[j];
        }
        else
            j=-1;
        //printf("%d,%d\n",j,i);
    }
    return j;
}

// searckey using recurrsion
int searchkey(int i,int key){
   // if(j<=sz && arr[i]!=0){
        if(arr[i]==key)        
            return i;
    
        if(2*i<=sz)    
            x=searchkey(2*i,key);
        else                   
            return 0;
    
        if ((x==0) && (2*i+1<= sz))
            x=searchkey(2*i+1,key);
        else 
            return -1;
        return x;
//    }
}


void bt_deleaf(int node){
    i=searchkey2(1,node);
    if(i==-1)
        printf("Node does not exist\n");
    else if(arr[2*i]==0 && arr[2*i+1]==0){
        printf("%d is removed\n",arr[i]);
        arr[i]=0;
        sz--;
    }
    else
        printf("%d is not a leaf node\n",arr[i]);
}

void build_tree(int i, int item){
    sz++;
    arr[i]=item;
    R=0;
    L=0;
    printf("does [%d] have a left node (y-1/n-0) : ",item);
    scanf("%d",&L);
    if(L!=0){
        printf("left child value : ");
        scanf("%d",&x);
        build_tree(2*i,x);
    }

    printf("does [%d] have a right node (y-1/n-0) : ",item);
    scanf("%d",&R);
    if(R!=0){
        printf("right child value : ");
        scanf("%d",&x);
        build_tree(2*i+1,x);
    }    
}

void bt_insert(int node){
    i=searchkey2(1,node);
    int l=0,r=0,item;
    if(sz==0){
        build_tree(1,node);
        return ;
    }
    else if(i==-1)
        printf("%d is not an element of Btree\n",node);
    else if(arr[2*i]!=0 && arr[2*i+1]!=0)
        printf("%d has two children so insertion not possible\n", node);
    else{
        printf("enter the val to insert : ");
        scanf("%d",&item);
        if(arr[2*i]==0){

            printf("\nadd to the left of [%d] (1-yes/0-no) :",arr[i]);
            scanf("%d",&l);
            if(l!=0) {//&& 2*i<=sz){
                arr[2*i]=item;
                printf("%d was succesfully added to left\n",arr[2*i]);
            }
        }
        if(arr[2*i+1]==0 && l==0){

            printf("\nadd to the right of [%d] (1-yes/0-no) :",arr[i]);
            scanf("%d",&r);
            if(r!=0) {//&& 2*i+1<=sz)
                arr[2*i+1]=item;
                printf("%d was succesfully added to right\n",item);
            }
        }
    sz++;
    }
}

int j=0;
void dispinorder(int i){
    if(j<=sz && arr[i]!=0){
        dispinorder(2*i);
        printf("%d\t",arr[i]);
        j++;
        dispinorder(2*i+1);
    }
}
void dispreorder(int i){
    if(j<=sz && arr[i]!=0){
        j++;
        printf("%d\t",arr[i]);
        dispreorder(2*i);
        dispreorder(2*i+1);
    }
}
void dispostorder(int i){
    if(j<=sz && arr[i]!=0){
        dispostorder(2*i);
        dispostorder(2*i+1);
        printf("%d\t",arr[i]);
        j++;
    }
}
int main() {

    printf("lets build a tree\nstart with the root : ");
    scanf("%d",&root);

    build_tree(1,root);


    int choice, pos, node, item;
    printf("\n1...display\n");
    printf("2...insert_a_child\n");
    printf("3...delete_val\n");
    printf("4...quit\n");
    int quit=1;
    while(quit!=0){
        printf("\nOption : ");
        scanf("%d",&choice);
        switch(choice){
            case 1: if(sz!=0){
                    j=0;
                    printf("preorder : \t");
                    dispreorder(1);
                    j=0;
                    printf("\ninorder : \t");
                    dispinorder(1);
                    j=0;
                    printf("\npostorder : ");
                    dispostorder(1);
                    printf("\n");
                }
                else
                    printf("Empty tree\n");
                break;
            case 2: printf("enter the parent val : ");
                scanf("%d",&node);

                bt_insert(node);
                break;
            case 3: printf("enter the node val to delete : ");
                scanf("%d",&node);
                
                bt_deleaf(node);
                break;
            case 4: quit=0;
                break;
            default:
                printf("\n1...display\n");
                printf("2...insert_a_child\n");
                printf("3...delete_val\n");
                printf("4...quit\n");
        }
    }

    return 0;
}
  