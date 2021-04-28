#include <stdio.h>

#define n 3
#define m 4
int l=0,k=0;

struct polynom{
	int coeff;
	int powr;
} p1[20] ,p2[20] ,sum[20];

void sort(struct polynom poly[] ,int len){
	int t1,t2;
	for(int i=0;i<len-1;i++){
		for(int j=0;j<len-i-1;j++){
			if(poly[j].powr < poly[j+1].powr){
				
				t1=poly[j].powr;
				t2=poly[j].coeff;

				poly[j].powr =poly[j+1].powr;
				poly[j].coeff=poly[j+1].coeff;

				poly[j+1].powr = t1;
				poly[j+1].coeff=t2;
			}
		}
	}
}

void insertpoly(struct polynom poly[],int len){
	int co,exp;
	for(int i=0 ;i<len ;i++){
		printf("\texponent: ");
		scanf("%d",&exp);
		poly[i].powr=exp;
		printf("\tcoefficient of X^%d: ",exp);
		scanf("%d",&co);
		poly[i].coeff=co;
	}
}
int polyadd(){
	int i=0,sc=0;
	while(l<n && k<m){
		if(p1[l].powr>p2[k].powr){
			sum[i].powr = p1[l].powr;
			sum[i].coeff=p1[l].coeff;
			l++;sc++;
		}
		else if(p1[l].powr<p2[k].powr){
			sum[i].powr = p2[k].powr;
			sum[i].coeff=p2[k].coeff;
			k++;sc++;
		}
		else{
			sum[i].powr = p1[l].powr;
			sum[i].coeff= p1[l].coeff + p2[k].coeff;
			l++;
			k++;
            sc++;
		}
		i++;
	}	
	while(l<n){
		sum[sc].powr=p1[l].powr;
		sum[sc].coeff=p1[l].coeff;
		l++;sc++;
	}
	while(k<m){
		sum[sc].powr=p2[k].powr;
		sum[sc].coeff=p2[k].coeff;
		k++;sc++;
	}  
  return sc;
}

void disp(int sumc){
  int i=0;
	printf("Poly A: ");
	for(i=0 ;i<n-1 ;i++){
		printf("%d(X^%d) +",p1[i].coeff,p1[i].powr);
	}
	printf("%d(X^%d)\n",p1[i].coeff,p1[i].powr);

	printf("Poly B: ");
	for(i=0 ;i<m-1 ;i++){
		printf("%d(X^%d) +",p2[i].coeff,p2[i].powr);
	}
	printf("%d(X^%d)\n",p2[i].coeff,p2[i].powr);

	printf("\nSum: ");
	for(i=0 ;i<sumc-1 ;i++){
		printf("%d(X^%d) +",sum[i].coeff,sum[i].powr);
	}
	printf("%d(X^%d)\n",sum[i].coeff,sum[i].powr);


}

int main(){
  printf("*****Polynomial 1***** \n");
	insertpoly(p1,n);
	sort(p1,n);
  printf("*****Polynomial 2***** \n");
	insertpoly(p2,m);
	sort(p2,m);
	int sumc=polyadd();
	disp(sumc);

}