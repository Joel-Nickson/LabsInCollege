import java.util.*;

class DLL{
	Node head=null,tail=null,temp=null;

	class Node{
		int data;
		Node next;
		Node prev;
		Node(int val){
			data=val;
		}
	}
	void pushEnd(int val){
		Node newNode = new Node(val);
		newNode.prev=tail;
		if(tail!=null)
			tail.next=newNode;
		else
			head=newNode;
		newNode.next=null;
		tail=newNode;
	}
	void popNum(int val){
	    if(head==null)
	        System.out.println("List is Empty");
	    else{
	        temp=head;
    		while((temp.data!=val)&&(temp.next!=null))
    			temp=temp.next;
    		if(temp.data==val){
        		System.out.println(temp.data+" is removed");
        		if(head==tail)
        		    head=tail=null;
        		else if(temp.prev==null){
        		    head=temp.next;
        		    head.prev=null;
        		}
        		else if(temp.next==null){
        		    tail=temp.prev;
        		    tail.next=null;
        		}
        		else{
        		    temp.prev.next=temp.next;
        		    temp.next.prev=temp.prev;
        		}
    		}
		    else 
		    	System.out.println("Value not found");
	    }
	}
	void disp(){
	    if(tail==null)
	        System.out.println("List is Empty");
	    else{
    		temp=head;
    		while(temp.next!=null){
    			System.out.print(temp.data+" <-> ");
    			temp=temp.next;
    		}
    		System.out.println(temp.data);
	    }
	}
}
public class Main{
	public static void main(String args[]){
		Scanner sc =new Scanner(System.in);
		DLL obj = new DLL();
		int choice,val,quit=0;

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
    				obj.pushEnd(val);
    				break;
    			case 3:System.out.print("What should I delete? : ");
    				val=sc.nextInt();
    			    obj.popNum(val);
    				break;
    			case 4:quit=1;
    			    break;
    			default:System.out.println("\n_____Menu_____");
            		System.out.println("1...display");
            	  	System.out.println("2...insert");
					System.out.println("3...delete front");
					System.out.println("4...quit");
    		}
    		
		    System.out.print("\nchoice: ");
	        choice=sc.nextInt();
		}
	}
}
