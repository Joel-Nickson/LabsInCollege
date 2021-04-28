import java.util.*;
class Throwablecls{
	public void disp( int num ) throws Exception{
		if (num == 0)
			throw new Exception("Zero is passed as value");
		else if (num <0)
			throw new Exception("Negative number caught ("+num+")");
		else{
			System.out.println("Number "+num+" is ok.");
		}
	}
}
public class Main{
	public static void main(String args[]){
		Throwablecls obj = new Throwablecls();
		Scanner sc=new Scanner(System.in);
		int val,i=0,quit=0;
		while(quit==0){  //infinite loop
		    System.out.print("\nvalue :");
		    val=sc.nextInt();
    		try{
    			obj.disp(val);
    		}
    		catch(Exception e){
    			System.out.println("error_"+i+" :"+e);
    		}
    		finally{
    		    i++;
    			System.out.println("Reached finally");
    		}
		}
	}
}