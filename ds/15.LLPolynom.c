#include <stdio.h>
#include <stdlib.h>

//Decreacing order or polynomial

int size_a=0,size_b=0,size_sum=0;

struct polynode{
	int coeff;
	int power;
	struct polynode *next;
	//struct polynode *prev;
} *starta,*startb,*sumstart,*sumend=NULL,*t1=NULL,*t2=NULL;



struct polynode* insertpoly()
{
    struct polynode *start=NULL,*end=NULL;
	int cap;
  	printf("Enter the Poly1 capacity: ");
  	scanf("%d",&cap);
    for(int i=0; i<cap; i++){
        int powe,coff;
        struct polynode *p;
  		printf("\tpoly(%d/%d) ",i+1,cap);
  		p= (struct polynode*)malloc(sizeof(struct polynode));

    	printf("Enter an Power:");
    	scanf("%d",&powe);
    	p->power = powe;
    
    	printf("\tCoefficient of (X^%d):",powe);
    	scanf("%d",&coff);
        p->coeff = coff;
        
    	p->next = NULL;
    	
    	if(start==NULL){
    //      p->prev = NULL;
    		start=p;
    		end=p;
    	}
    	else {
    		end->next=p;
    //      end->next->prev=end;
    // 		p->next=NULL;
    // 		p->prev->next=p;
    		end=end->next;
    	}
	//	size_a++;
  	}
  	//printf(":(  ||");
  	return start;
	
}
void polyadd(){
    int c=0,ex,co;
	t1=starta;
	t2=startb;
	
	while(t1!=NULL && t2!=NULL){
		if(t1->power > t2->power){
			ex=t1->power;
			co=t1->coeff;
			t1=t1->next;
		}
		else if(t1->power < t2->power){
			ex=t2->power;
			co=t2->coeff;
			t2=t2->next;
		}
		else{
			ex=t2->power;
			co = t2->coeff + t1->coeff;
			t1=t1->next;
			t2=t2->next;
		}
		if(c==0)
		    printf("%d(X^%d) ",co,ex);
		else
		    printf("+%d(X^%d) ",co,ex);
		c++;
	}
	while(t1!=NULL){
		ex=t1->power;
		co=t1->coeff;
		printf("+%d(X^%d) ",co,ex);
	
		t1=t1->next;
	}
	while(t2!=NULL){
		ex=t2->power;
		co=t2->coeff;
		printf("+%d(X^%d)",co,ex);
	
		t2=t2->next;
	}
}

void showeach(struct polynode *start){
	int i=0;
	t1=start;
	while(t1->next!=NULL){
		printf("%d(X^%d) +",t1->coeff,t1->power);
		t1=t1->next;
		i++;
	}
	printf("%d(X^%d)",t1->coeff,t1->power);

}

void disp(){
	printf("\nPoly A: ");
	showeach(starta);

	printf("\nPoly B: ");
	showeach(startb);

	printf("\nSum: ");
	polyadd();
}

int main(){
	int cap;
  	printf("\n*****Polynomial 1***** \n");
	starta=insertpoly();

	t1=starta;
	while(t1->next!=NULL){
		printf("%d(X^%d) +",t1->coeff,t1->power);
		t1=t1->next;
	}
	printf("%d(X^%d)",t1->coeff,t1->power);
  	
  	printf("\n*****Polynomial 2***** \n");
	startb=insertpoly();
	
	t2=startb;
	while(t2->next!=NULL){
		printf("%d(X^%d) +",t2->coeff,t2->power);
		t2=t2->next;
	}
	printf("%d(X^%d)\n",t2->coeff,t2->power);
	
	disp();
    return 0;
}