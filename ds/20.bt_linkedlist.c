#include <stdio.h>
#include <stdlib.h>

#define n 65

int i,x=0,sz=0,key,R,L;


struct node{
    int data;
    struct node *rchild;
    struct node *lchild;
    struct node *dad;
} *root=NULL ,*tmp ,*t2 ,*parent ,*leaf ,*leafp ,*arr[50];

struct node* searchkey2(){
    int top=0,i=-1;
    tmp=root;
    while(i!=-1 || tmp!=NULL){
        if(tmp->data==key)
            return tmp;
        if(i>=0 && tmp->lchild==NULL && tmp->rchild==NULL){
            tmp=arr[i];
            tmp=tmp->rchild;
            --i;
        }
        else if(tmp->lchild==NULL && tmp->rchild!=NULL)
            tmp=tmp->rchild;
        else if(tmp->rchild==NULL && tmp->lchild!=NULL)
            tmp=tmp->lchild;
        else if(tmp->lchild!=NULL && tmp->rchild!=NULL){
            i++;
            arr[i]=tmp;
            tmp=tmp->lchild;
        }
        else
            tmp=NULL;
    }
    if(tmp!=NULL)
         printf("searchkey2 ---------- %d\n",tmp->data);
    return tmp;
}

// struct node* searchkey(struct node *t){
//     if(t!=NULL && t->data==key)        
//         return t;

//     if(tmp==NULL && t2==NULL && t->lchild!=NULL)    
//         tmp=searchkey(t->lchild);
//     else if(tmp==NULL && t2==NULL && t->rchild!=NULL)
//         t2=searchkey(t->rchild);
//     else 
//         return NULL;
    
//     if(t2!=NULL){
//         //printf("searchkey ---------- %d\n",t2->data);
//         return t2;
//     }
//     if(tmp!=NULL){
//         //printf("searchkey ---------- %d\n",tmp->data);
//         return tmp;
//     }
//     return  NULL;
// }


void bt_deleaf(int pdata){
    key=pdata;
    leaf=searchkey2();
    if(leaf!=NULL){
        leafp=leaf->dad;
        //printf("searchleafpar ---------- %d\n",leafp->data);
    }
    
    if(leaf==NULL)
        printf("Node does not exist\n");
    else if(leaf->lchild==NULL && leaf->rchild==NULL){
        if(root->data!=leaf->data){
            if(leafp->lchild ==leaf)
                leafp->lchild =NULL;
            else if(leafp->rchild ==leaf)
                leafp->rchild =NULL;
        }
        else
            root=NULL;
        printf("%d is removed\n",leaf->data);
        free(leaf);
        sz--;
    }
    else
        printf("%d is not a leaf node\n",pdata);
}

void build_tree(struct node *par){
    sz++;

    printf("does [%d] have a left node(y-1/n-0):",par->data);
    scanf("%d",&L);
    if(L!=0){
        struct node *child;
        child=(struct node*)malloc(sizeof(struct node));
        
        printf("left child value : ");
        scanf("%d",&(child->data));
        // child->lchild=NULL;
        // child->rchild=NULL;
        
        par->lchild=child;
        child->dad=par;
        build_tree(child);
    }

    printf("does [%d] have a right node(y-1/n-0):",par->data);
    scanf("%d",&R);
    if(R!=0){
        struct node *child;
        child=(struct node*)malloc(sizeof(struct node));
        
        printf("right child value : ");
        scanf("%d",&(child->data));
        child->lchild=NULL;
        child->rchild=NULL;
        
        par->rchild=child;
        child->dad=par;
        build_tree(child);
    }    
}

void bt_insert(int pdata){
    int l=0,r=0;
    struct node *ptr;
    ptr=(struct node*)malloc(sizeof(struct node));
    ptr->lchild=NULL;
    ptr->rchild=NULL;
    
    key=pdata;
    parent=searchkey2();
    if(sz==0){
        printf("root : %d\n",pdata);
        ptr->data=pdata;
        ptr->dad=NULL;
        root=ptr;
        ptr->lchild=NULL;
        ptr->rchild=NULL;
        build_tree(root);
    }
    else if(parent==NULL){
        printf("%d is not an element of Btree\n",pdata);
        free(ptr);
    }
    else if(parent->lchild!=NULL && parent->rchild!=NULL){
        printf("%d has two children so insertion not possible\n", pdata);
        free(ptr);
    }
    else{

        printf("enter the val to insert : ");
        scanf("%d",&ptr->data);
        if(parent->lchild==NULL){

            printf("\nadd to the left of [%d] (1-yes/0-no) :",parent->data);
            scanf("%d",&l);
            if(l!=0) {//&& node->lchild<=sz){
                parent->lchild=ptr;
                ptr->dad=parent;
                printf("%d was succesfully added to left\n",ptr->data);
            }
        }
        if(parent->rchild==NULL && l==0){

            printf("\nadd to the right of [%d] (1-yes/0-no) :",parent->data);
            scanf("%d",&r);
            if(r!=0) {//&& node->rchild<=sz)
                parent->rchild=ptr;
                ptr->dad=parent;
                printf("%d was succesfully added to right\n",ptr->data);
            }
        }
    sz++;
    }
}

int j=0;
void dispinorder(struct node *t){
    if(j<sz && t!=NULL){
        j++;
        dispinorder(t->lchild);
        printf("%d\t",t->data);
        dispinorder(t->rchild);
    }
}
void dispreorder(struct node *t){
    if(j<sz &&t!=NULL){
        j++;
        printf("%d\t",t->data);
        dispreorder(t->lchild);
        dispreorder(t->rchild);
    }
}
void dispostorder(struct node *t){
    if(j<sz){
        j++;
        if(t->lchild!=NULL && t->lchild->data!=0)
            dispostorder(t->lchild);
        if(t->rchild!=NULL && t->rchild->data!=0)
            dispostorder(t->rchild);
        printf("%d\t",t->data);
    }
}
int main() {

    struct node *ptr;
    ptr=(struct node*)malloc(sizeof(struct node));
    printf("lets build a tree\nstart with the root : ");
    scanf("%d",&(ptr->data));
    ptr->dad=NULL;
    root=ptr;
    ptr->lchild=NULL;
    ptr->rchild=NULL;
    build_tree(root);


    int choice, pos, pdata, item;
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
                    //tmp=root
                    dispreorder(root);
                    j=0;
                    printf("\ninorder : \t");
                    //tmp=root
                    dispinorder(root);
                    j=0;
                    printf("\npostorder : ");
                    //tmp=root
                    dispostorder(root);
                    printf("\nsz=%d\n",sz);
                }
                else
                    printf("Empty tree\n");
                break;
            case 2: printf("enter the parent val : ");
                scanf("%d",&pdata);

                bt_insert(pdata);
                break;
            case 3: printf("enter the node val to delete : ");
                scanf("%d",&pdata);
                if(root!=NULL)
                    bt_deleaf(pdata);
                else
                    printf("Btree empty\n");
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
