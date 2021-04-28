#include <stdio.h>
#include <stdlib.h>

int sz=0,array[20],i=0;

struct node{
    int data;
    struct node *rchild;
    struct node *lchild;
    struct node *dad;
} *root=NULL ,*tmp ,*parent ,*succ ,*succp ;

struct node *succparent(struct node *ptr){
    struct node *x,*par;
    par=ptr;

    if(par->rchild !=NULL){     //right subtree
        x=par->rchild;
        while(x->lchild != NULL){
            par=x;
            x=x->lchild;
        }
    }
    else{                       //left subtree
        x=par->lchild;
        while(x->rchild != NULL){
            par=x;
            x=x->rchild;
        }
    }

    return par;
}

struct node* succx(struct node *ptr){
    struct node* x;

    // if(ptr->rchild != NULL)
    //     ptr = succx(ptr->rchild);
    // else if(ptr->lchild != NULL)
    //     ptr = succx(ptr->lchild);

    if(ptr->rchild !=NULL){     //right subtree
        x=ptr->rchild;
        while(x->lchild != NULL)
            x=x->lchild;
    }
    else if(ptr->lchild !=NULL){                       //left subtree
        x=ptr->lchild;
        while(x->rchild != NULL)
            x=x->rchild;
    }
        
    return x;
}

void dispinorder(struct node *root){
    if(root != NULL){
        dispinorder(root->lchild);
        printf("%d\t",root->data);
        dispinorder(root->rchild);
    }
}
void dispreorder(struct node *root){
    if(root != NULL){
        printf("%d\t",root->data);
        dispreorder(root->lchild);
        dispreorder(root->rchild);
    }
}
void dispostorder(struct node *root){
    if(root != NULL){
        dispostorder(root->lchild);
        dispostorder(root->rchild);
        printf("%d\t",root->data);
    }
}

void insertbst(){
    int val;
    struct node *x;
    x=(struct node*)malloc(sizeof(struct node));
    
    printf("enter the val--");
    scanf("%d",&(x->data));
    x->rchild = NULL;
    x->lchild = NULL;
    
    array[i]=x->data;
    i++;

    if(root==NULL){
        x->dad=NULL;
        root=x;
    }
    else{
        tmp = root;
        while(tmp != NULL){
            parent=tmp;
            if(x->data < tmp->data)
                tmp=tmp->lchild;
            else if(x->data > tmp->data)
                tmp=tmp->rchild;
            else 
                tmp=NULL;
        }
        if(x->data == parent->data){
            free(x);// to prevent duplicates
            //sz--;
            return ;
        }
        // if(tmp!=NULL)
        //     parent=tmp->dad;
        if(x->data < parent->data)
            parent->lchild = x;
        else if(x->data > parent->data)
            parent->rchild = x;
        x->dad=parent;
    }
    sz++;
}
//deletoin case
void no_child(){
    if(root != tmp){
        if(parent->lchild == tmp)
            parent->lchild=NULL;
        else
            parent->rchild=NULL;
    }
    else
        root=NULL;            
}
void one_child(){
    if(root != tmp){
        if(parent->lchild == tmp){
            if(tmp->rchild == NULL){// && tmp->lchild != NULL)
                parent->lchild = tmp->lchild;
                tmp->lchild->dad=parent;
            }
            else if(tmp->lchild==NULL){// && tmp->rchild !=NULL)
                parent->lchild = tmp->rchild;
                tmp->rchild->dad=parent;
            }
        }
        else if(parent->rchild == tmp){ 
            if(tmp->rchild==NULL){// && tmp->lchild != NULL)
                parent->rchild = tmp->lchild;
                tmp->lchild->dad=parent;
            }
            else if(tmp->lchild==NULL){// && tmp->rchild !=NULL)
                parent->rchild = tmp->rchild;
                tmp->rchild->dad=parent;
            }
        }
    }
    else{
        if(tmp->lchild != NULL)
            root=tmp->lchild;
        else
            root=tmp->rchild;
    }
}
void two_child(){

    succ =succx(tmp); //will not have 2 child
    if(succ!=NULL){
        succp = succparent(tmp);
        //succp=succ->dad;
    }
    else
        succp=succ;
    
    //printf("succp=%d,succ=%d,tmp=%d,par=%d\n",succp->data,succ->data,tmp->data,parent->data);
    if(succ->dad==succp){
        if(succp->lchild == succ){ 
            if(succ->rchild!=NULL && succ->lchild==NULL){
                succp->lchild =succ->rchild;
                succp->lchild->dad=succp;
            }
            else if(succ->lchild!=NULL && succ->rchild==NULL){ 
                succp->lchild=succ->lchild;
                succp->lchild->dad=succp;
            }
            else if(succ->lchild==NULL && succ->rchild==NULL){
                succp->lchild=NULL;
            }
        }
        else if(succp->rchild == succ){ 
            if(succ->rchild!=NULL && succ->lchild==NULL){
                succp->rchild =succ->rchild;
                succp->rchild->dad=succp;
            }
            else if(succ->lchild!=NULL && succ->rchild==NULL){ 
                succp->rchild=succ->lchild;
                succp->rchild->dad=succp;
            }
            else if(succ->lchild==NULL && succ->rchild==NULL){
                succp->rchild=NULL;
            }
        }
        if(tmp->lchild != succ)
            succ->lchild = tmp->lchild;
        else
            succ->lchild = NULL;
            
        if(tmp->rchild != succ)
            succ->rchild = tmp->rchild;
        else
            succ->rchild = NULL;
            
        if (tmp->dad!=NULL)
            succ->dad = tmp->dad;
        else{
            succ->dad=NULL;
            root=succ;
        }
        if(succ->lchild!=NULL)
            succ->lchild->dad=succ;
        if(succ->rchild!=NULL)
            succ->rchild->dad=succ;
        
        //if(tmp->dad ==parent){
            if(parent->lchild == tmp)
                parent->lchild = succ;
            else if(parent->rchild == tmp)
                parent->rchild = succ;
        //}
        //tmp=succp;
    }
    else{
        if(succ==NULL)
            printf("empty tree");
        if(succ==succp){
            root=NULL;
            tmp=succ;
        }
    }
    //printf("succp=%d,succ=%d,tmp=%d,par=%d\n",succp->data,succ->data,tmp->data,parent->data);
}

void popitem(){
    int val, flag=0;
    printf("remove me--");
    scanf("%d",&val);
    //printf("1\n");
    
    for(int index=0;index<=i;index++)
        if(array[index]==val)
            flag=1;
    if(root!=NULL)
        tmp = root;
    //################finding tmp and parent
    while(flag==1 && tmp != NULL){
        if(val==tmp->data){
            flag=1;
            break;
        }
        else if(val < tmp->data){
            parent=tmp;
            tmp=tmp->lchild;
        }
        else if(val > tmp->data){
            parent=tmp;
            tmp=tmp->rchild;
        }
    }
    //########################################
    //printf("1\n");
    
    if(tmp->dad !=NULL)
        parent=tmp->dad;
    else
        parent=tmp;
        
    if(flag!=1)
        printf("Item not found\n");
    else{
        if(tmp->lchild==NULL && tmp->rchild==NULL)  // no child
            no_child();
        else if(tmp->lchild==NULL || tmp->rchild==NULL) // one child
            one_child();
        else                               // two children
            two_child();
        free(tmp);
        sz--;
    }

}

int main(){
    int choice;
    int pos;
    printf("1...traversal\n");
    printf("2...insert\n");
    printf("3...popitem\n");
    printf("4...quit\n");
    
    int quit=1;
    while(quit!=0){
        printf("\nOption : ");
        scanf("%d",&choice);
        switch(choice){
                case 1: if(root!=NULL){
                    printf("preorder : \t");
                    dispreorder(root);
                    printf("\ninorder : \t");
                    dispinorder(root);
                    printf("\npostorder : ");
                    dispostorder(root);
                    printf("\nsz=%d\n",sz);
                }
                else
                    printf("Empty tree\n");
                break;
            case 2: insertbst();
                break;
            case 3: 
                if(sz>0)
                    popitem();
                else
                    printf("no more elements to pop");
                break;
            case 4: quit=0;
                break;
            default:
                printf("\n1...traversal\n");
                printf("2...insert\n");
                printf("3...popitem\n");
                printf("4...quit\n");
        }
    }
    
    return 0;
}