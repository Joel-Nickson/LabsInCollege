import java.util.*;


class Palindrome {

  boolean isPal(String s){
    int i=0,j=s.length()-1;
    while(i<j){
      if(s.charAt(i)!=s.charAt(j))
        return false;
      i++;j--;
    }
    return true;
  }
  
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter a String");
    String s=sc.next();

    Palindrome p=new Palindrome();
    boolean pal=p.isPal(s);
    if(pal){
      System.out.println("\""+s+"\" is a Palindrome String");
    }
    else{
      System.out.println("\""+s+"\" is not a Palindrome String");
    }
    sc.close();
  }
}