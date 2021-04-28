import java.util.*;
public class String_Tokenizer{
	public static void main(String args[]){
		String s;
		int n,sum=0;
		Scanner sc = new Scanner(System.in);
		s= sc.nextLine();
		StringTokenizer tk = new StringTokenizer(s," ");
		System.out.print("Numbers: ");
		while(tk.hasMoreTokens()){
			n = Integer.parseInt(tk.nextToken());
			System.out.print(n+" ,");
			sum+=n;
		}
		System.out.println("\nsum: "+sum);	}
}