/*This program converts a number from infix 
    to postfix and then evaluates the equation*/
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <math.h>
int ISP(char op){
    if(op=='^')                       return 3;
    else if(op=='*' || op=='/')       return 2;
    else if(op=='+' || op=='-')       return 1;
    else if(op=='(')                  return 0;
}
int ICP(char op){
    if(op=='^')                       return 4;
    else if(op=='*' || op=='/')       return 2;
    else if(op=='+' || op=='-')       return 1;
    else if(op=='(')                  return 4;
}

/*Normal pop operation*/
char pop(char stack[]){
    char out;
    int top=strlen(stack)-1;
    int num;
    out=stack[top];
    stack[top]='\0';
    return out;
}

/*push into a stack*/
int push(char val, char arr[]){
    int i;
    int top=strlen(arr);
    arr[top]=val;
    arr[top+1]='\0';
}

/*pops the elements till left bracket*/
char popall(char stack[],char output[]){
    int i=0;
    int top=strlen(stack)-1;
    while(stack[top]!='('){
        int num;
        push(stack[top],output);
        stack[top]='\0';
        top--;
    }
    stack[top]='\0';
}

/*Integer push*/
int pushInt(int val, int arr[],int* top){
    int i;
    //printf("%d",top);
    arr[*top]=val;
    arr[++*top]='\0';
}
/*Calculate the val of the postfix notation*/
void Calculator(char output[]){
    printf("Sum of (%s): ",output);
    int i=0,res=0,top=0;
    int slashzero=strlen(output);
    int numbers[25];
    while(i<slashzero){
        int digit1,digit2,dcount;
        char ch;
        
        ch=output[i];
        if (isdigit(ch)!=0){
            pushInt(ch-'0',numbers,&top);
        
        } else { //if(i==-1){
            digit2=numbers[--top];
            numbers[top]='\0';
            digit1=numbers[--top];
            numbers[top]='\0';
            
            switch(ch){
                case '*': res=digit1*digit2;
                        break;
                case '/': res=digit1/digit2;
                        break;
                case '+': res=digit1+digit2;
                        break;
                case '-': res=digit1-digit2;
                        break;
                case '^': res=pow(digit1,digit2);
                        break;
            }
            pushInt(res,numbers,&top);
        }
        
        ++i;
    }
    printf("%d",numbers[0]);
}

/* Converts the infix expression calling all the functions */
void Postfix(char s1[50]){
    int right=strlen(s1)-1 ,top=0 ,i=0 ;
    char stack[50]={'\0'}  ,output[50]={'\0'};
    char left,op,isp;
    
    while(s1[i]!='#'){
        left=s1[i];
        if(left=='('){
            push(left,stack);
            
        } else if ((isdigit(left)!=0)||(isalpha(left)!=0)){
            push(left,output);
            
        } else if (left=='*' || left=='/' || left=='-' || left=='+' || left=='^' ){
            isp=pop(stack);
            if(ICP(left)>ISP(isp)) {
                push(isp,stack);
                push(left,stack);                
            } else {
                push(isp,output);
                push(left,stack);
            }
        } else if(left==')'){
            popall(stack,output);
        }
        i++;
    }
    printf("Postfix: %s\n",output);
    for(i=0;output[i]!='\0';i++)
    {
        if(isalpha(output[i]))
        {
            printf("give me %c <--> ",output[i]);
            scanf(" %c",&output[i]);
        }
    }
    Calculator(output);
    //printf("stack: %s",stack);
}

/* Adding brackets at '(' begining and end ')' and also adding '#' at end */
char addbracket(char s1[50]){
    
    int slashzero=strlen(s1);
    s1[slashzero]=')';
    s1[++slashzero]='#';
    s1[++slashzero]='\0';
    for(int i=slashzero;i>=0;i--){
        s1[i+1]=s1[i];
    }
    s1[0]='(';
    //printf("Infix: %s\n",s1);
}

int main() {
    printf("Infix expression --> ");
    char s1[50];//="4/2+(5-3)*6";//="(a+b/c)/d+e"; //
    fgets(s1,50,stdin);
    //printf("\nInfix eq: %s\n",s1);
    addbracket(s1);
    Postfix(s1);
    return 0;
}