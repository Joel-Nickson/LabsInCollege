import java.util.*;

interface StackInter{
	void push(int val);
	void pop();
	void disp();
}

class Stack implements StackInter{
	int top=-1,st[],size;
	public void getsize(int n){
		size=n;
		st=new int[n];
	}

	public void push(int val){
		if(top<size-1){
		    top++;
			st[top]=val;
		}
		else
			System.out.println("Stack Overflow");
	}

	public void pop(){
		if (top>=0){
		    System.out.println(st[top]+" is removed");
		    top--;
		}
		else
			System.out.println("Stack Underflow");
	}

	public void disp(){
		int i;
		if (top<0)
			System.out.println("Stack Empty");
		else{
		    if(top>0)
			    for(i=0;i<top;i++)
				    System.out.print(st[i]+" ->");
			System.out.println(st[top]);
		}
	}
}

class Main extends Stack{
	public static void main(String args[]){
		Scanner sc =new Scanner(System.in);
		Stack obj = new Stack();
		int choice,val,quit=0;

		System.out.print("Total Size of list: ");
		val=sc.nextInt();
		obj.getsize(val);
		System.out.println("_____Menu_____");
		System.out.println("1...display");
	  	System.out.println("2...insert");
		System.out.println("3...delete");
		System.out.println("4...quit");
		System.out.print("\n choice: ");
		choice=sc.nextInt();
        while(quit==0){
    		switch(choice){
    			case 1: obj.disp();
    				break;
    			case 2: System.out.print("What should I push? : ");
    				val=sc.nextInt();
    				obj.push(val);
    				break;
    			case 3: obj.pop();
    				break;
    			case 4:quit=1;
    			    break;
    			default:System.out.println("\n_____Menu_____");
            		System.out.println("1...display");
            	  	System.out.println("2...insert");
            		System.out.println("3...delete");
            		System.out.println("4...quit");
    		}
    		
		    System.out.print("\nchoice: ");
	        choice=sc.nextInt();
		}
	}
}