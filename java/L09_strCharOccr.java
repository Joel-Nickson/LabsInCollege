 import java.util.*;

 public class CharOccr{
 	int count=0;
 	public void OccrCheck(String str ,char ch){
 		for(int i=0; i<str.length(); i++){
 			if(str.charAt(i)==ch)
 				count++;
 		}

	 	System.out.print("count of "+ch+": "+count);
 	}
 	public static void main(String args[]){

	 	Scanner sc =new Scanner(System.in);
	 	CharOccr obj= new CharOccr();
	 	System.out.print("Enter the string: ");
	 	String str=  sc.nextLine();
	 	System.out.print("Character: ");
	 	char c=sc.next().charAt(0);
	 	obj.OccrCheck(str,c);	 

	}
 }