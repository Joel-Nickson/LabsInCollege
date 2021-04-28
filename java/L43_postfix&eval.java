import java.util.*;

public Class PostfixEval{
    PostfixEval obj = new PostfixEval();

    Vector v = new Vector(10,5);
    int vSize=-1;
    int ISP(char op){
        if(op=='^')                                 return 3;
        else if(op=='*' || op=='/' || op=='%')      return 2;
        else if(op=='+' || op=='-')                 return 1;
        else if(op=='(')                            return 0;
    }
    int ICP(char op){
        if(op=='^')                                 return 4;
        else if(op=='*' || op=='/' || op=='%')      return 2;
        else if(op=='+' || op=='-')                 return 1;
        else if(op=='(')                            return 4;
    }

    //push = v.addElement(item)

    /*Normal pop operation*/
    char pop(){
        char out;
        int last = v.size()-1 ;
        out=v.elementAt(last);
        v.remove(last);
        return out;
    }

    /*pops the elements till left bracket*/
    char popall(char output[],int sz){
        int i=0;
        int top = v.size()-1;
        while(v.elementAt(top)!='('){
            push(v.elementAt(top),output);
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
    void Calculator(String output){
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
    void Postfix(String s1){
        int right=strlen(s1)-1 ,sz=0 ,i=0 ;
        char postfx[]=new char[20];
        char icp,op,isp;
        
        while(i<s1.length()){
            icp=s1.charAt(i);

            if(icp=='('){
                // push(icp,stack);
                v.addElement(icp);
                
            } else if ((Character.isDigit(icp)!=0)||(Character.isAlphabetic(icp)!=0)){
                // push(icp,postfx);
                postfx[sz++] = icp;

            } else if (icp=='*' || icp=='/' || icp=='-' || icp=='+' || icp=='^' ){
                // isp=pop(stack);
                isp = obj.pop();
                if(ICP(icp)>ISP(isp)) {
                    // push(isp,stack);
                    // push(icp,stack);
                    v.addElement(isp);
                    v.addElement(icp);                
                } else {
                    // push(isp,postfx);
                    // push(icp,stack);
                    postfx[sz++] = isp;
                    v.addElement(icp);  
                }
            } else if(icp==')'){
                obj.popall(postfx);
            }
            i++;
        }
        printf("Postfix: %s\n",postfx);
        for(i=0;postfx[i]!='\0';i++)
        {
            if(isalpha(postfx[i]))
            {
                printf("give me %c <--> ",postfx[i]);
                scanf(" %c",&postfx[i]);
            }
        }
        String post = new String(postfx)
        Calculator(post);
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

    public static void main(String args[]) {
        Scanner sc =new Scanner(System.in);
        printf("Infix expression --> ");
        String s1="4/2+(5-3)*6";//="(a+b/c)/d+e"; //

        addbracket(s1);
        Postfix(s1);
        return 0;
    }
}