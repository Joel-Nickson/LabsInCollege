import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class javaGridCalculatorPostfix implements ActionListener{

    // Vector stack = new Vector(10,5);
    int vSize=-1;

    int sz=0 ,i=0 ;
    char postfx[]=new char[20];
    char icp,isp;

    Vector stack = new Vector(10,5);


    JTextField tf;  
    JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb0
    ,jbplus,jbminus,jbmulti,jbdiv,jbmod,jbequal,jbclear;     

    int num2=0,num1=0,sum=0,top=0;
    String result="",showtext="";
    char op='?';

    javaGridCalculatorPostfix(){
        JFrame f = new JFrame("Framey");

        JPanel jpbttn = new JPanel();

        Color grey = new Color(200, 200, 200);        
        Color transparentgrey = new Color(200, 200, 200, 0);

        tf = new JTextField("hello");
        jb1 = new JButton("1");
        jb2 = new JButton("2");
        jb3 = new JButton("3");
        jb4 = new JButton("4");
        jb5 = new JButton("5");
        jb6 = new JButton("6");
        jb7 = new JButton("7");
        jb8 = new JButton("8");
        jb9 = new JButton("9");
        jb0 = new JButton("0");
        jbplus = new JButton("+");
        jbminus = new JButton("-");
        jbmulti = new JButton("*");
        jbdiv = new JButton("/");
        jbmod = new JButton("%");
        jbequal = new JButton("=");
        jbclear = new JButton("C");

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);
        jb7.addActionListener(this);
        jb8.addActionListener(this);
        jb9.addActionListener(this);
        jb0.addActionListener(this);
        jbplus.addActionListener(this);
        jbminus.addActionListener(this);
        jbmulti.addActionListener(this);
        jbdiv.addActionListener(this);
        jbmod.addActionListener(this);
        jbequal.addActionListener(this);
        jbclear.addActionListener(this);
        
        // jb1.setBounds(150,100,30,30);
        // jb2.setBounds(150,130,30,30);
        // jb3.setBounds(150,160,30,30);
        // jb4.setBounds(180,190,30,30);
        // jb5.setBounds(180,130,30,30);
        // jb6.setBounds(180,160,30,30);
        // jb7.setBounds(210,190,30,30);
        // jb8.setBounds(210,130,30,30);
        // jb9.setBounds(210,160,30,30);
        // jb0.setBounds(240,100,30,30);


        f.setSize(300,400);
        f.setLayout(new BorderLayout());


        // row1
        jpbttn.add(jb1);
        jpbttn.add(jb2);
        jpbttn.add(jb3);
        jpbttn.add(jbplus);

        // row2
        jpbttn.add(jb4);
        jpbttn.add(jb5);
        jpbttn.add(jb6);
        jpbttn.add(jbminus);

        // row3
        jpbttn.add(jb7);
        jpbttn.add(jb8);
        jpbttn.add(jb9);
        jpbttn.add(jbmulti);

        // row4
        jpbttn.add(jbdiv);
        jpbttn.add(jb0);
        jpbttn.add(jbmod);
        jpbttn.add(jbclear);

        // row5
        jpbttn.add(jbequal);
        jpbttn.setLayout(new GridLayout(5,4));

        // frame add
        f.add(tf,BorderLayout.NORTH);
        tf.setBackground(grey);
        tf.setPreferredSize(new Dimension(300, 40));

        f.add(jpbttn,BorderLayout.CENTER);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // public static int ISP(char op){
    //     if(op=='^')                                 return 3;
    //     else if(op=='*' || op=='/' || op=='%')      return 2;
    //     else if(op=='+' || op=='-')                 return 1;
    //     else if(op=='(')                            return 0;
    // }
    // public static int ICP(char op){
    //     if(op=='^')                                 return 4;
    //     else if(op=='*' || op=='/' || op=='%')      return 2;
    //     else if(op=='+' || op=='-')                 return 1;
    //     else if(op=='(')                            return 4;
    // }

    // //push = stack.addElement(item)

    // /*Normal pop operation*/
    // public static char pop(){
    //     char out;
    //     int last = stack.size()-1 ;
    //     out=v.elementAt(last);
    //     stack.remove(last);
    //     return out;
    // }

    // /*pops the elements till left bracket*/
    // public static char popall(char output[],int sz){
    //     int i=0;
    //     int top = stack.size()-1;
    //     while(v.elementAt(top)!='('){
    //         push(v.elementAt(top),output);
    //         stack[top]='\0';
    //         top--;
    //     }
    //     stack[top]='\0';
    // }

    // /*Integer push*/
    // public static int pushInt(int val, int arr[],int top){
    //     int i;
    //     //System.out.println("%d",top);
    //     arr[top]=val;
    //     arr[++top]='\0';
    // }
    // /*Calculate the val of the postfix notation*/
    // public static void Calculator(String output){
    //     System.out.println("Sum of (%s): ",output);
    //     int i=0,res=0;
    //     int slashzero=strlen(output);
    //     int numbers[]=new int[25];
    //     while(i<slashzero){
    //         int digit1,digit2,dcount;
    //         char ch;
            
    //         ch=output[i];
    //         if (Character.isDigit(ch)!=0){
    //             pushInt(ch-'0',numbers,top);
            
    //         } else { //if(i==-1){
    //             digit2=numbers[--top];
    //             numbers[top]='\0';
    //             digit1=numbers[--top];
    //             numbers[top]='\0';
                
    //             jCalc(ch);
    //             res=sum;

    //             pushInt(res,numbers,top);
    //         }
            
    //         ++i;
    //     }
    //     System.out.println("%d",numbers[0]);
    // }

    // /* Converts the infix expression calling all the functions */
    // public static void Postfix(String s1){
    //     int right=strlen(s1)-1 ,sz=0 ,i=0 ;
    //     char postfx[]=new char[20];
    //     char icp,op,isp;
        
    //     while(i<s1.length()){
    //         icp=s1.charAt(i);

    //         if(icp=='('){
    //             // push(icp,stack);
    //             stack.addElement(icp);
                
    //         } else if ((Character.isDigit(icp)!=false)||(Character.isAlphabetic(icp)!=false)){
    //             // push(icp,postfx);
    //             postfx[sz++] = icp;

    //         } else if (icp=='*' || icp=='/' || icp=='-' || icp=='+' || icp=='^' ){
    //             // isp=pop(stack);
    //             isp = obj.pop();
    //             if(ICP(icp)>ISP(isp)) {
    //                 // push(isp,stack);
    //                 // push(icp,stack);
    //                 stack.addElement(isp);
    //                 stack.addElement(icp);                
    //             } else {
    //                 // push(isp,postfx);
    //                 // push(icp,stack);
    //                 postfx[sz++] = isp;
    //                 stack.addElement(icp);  
    //             }
    //         } 
    //         i++;
    //     }
    //     System.out.println("Postfix: %s\n",postfx);
    //     for(i=0;postfx[i]!='\0';i++)
    //     {
    //         if(Character.isAlphabetic(postfx[i]))
    //         {
    //             System.out.println("give me %c <--> ",postfx[i]);
    //             sc.nextInt(postfx[i]);
    //         }
    //     }
    //     String post = new String(postfx);
    //     Calculator(post);
    //     //System.out.println("stack: %s",stack);
    // }

    public void jCalc(int first,int second){
        if(op=='+')
            sum=first+second;
        else if(op=='-')
            sum=first-second;
        else if(op=='*')
            sum=first*second;
        else if(op=='/')
            sum=first/second;
        else if(op=='%')
            sum=first%second;
        else
            sum=first+second;
    }

     public static int ISP(char op){
        if(op=='^')                                 return 3;
        else if(op=='*' || op=='/' || op=='%')      return 2;
        else if(op=='+' || op=='-')                 return 1;
        else if(op=='(')                            return 0;
        return -1;
    }
    public static int ICP(char op){
        if(op=='^')                                 return 4;
        else if(op=='*' || op=='/' || op=='%')      return 2;
        else if(op=='+' || op=='-')                 return 1;
        else if(op=='(')                            return 4;
        return -1;
    }
    
    static int evaluatePostfix(String exp) 
    { 
        //create a stack 
        Stack<Integer> stack=new Stack<>(); 
          
        // Scan all characters one by one 
        for(int i=0;i<exp.length();i++) 
        { 
            char c=exp.charAt(i); 
              
            // If the scanned character is an operand (number here), 
            // push it to the stack. 
            if(Character.isDigit(c)) 
            stack.push(c - '0'); 
              
            //  If the scanned character is an operator, pop two 
            // elements from stack apply the operator 
            else
            { 
                int val1 = stack.pop(); 
                int val2 = stack.pop(); 
                  
                switch(c) 
                { 
                    case '+': 
                    stack.push(val2+val1); 
                    break; 
                      
                    case '-': 
                    stack.push(val2- val1); 
                    break; 
                      
                    case '/': 
                    stack.push(val2/val1); 
                    break; 
                      
                    case '*': 
                    stack.push(val2*val1); 
                    break; 
              } 
            } 
        } 
        return stack.pop();     
    } 

    /* Converts the infix expression calling all the functions */
    public void postfix(String s1){
        
        while(i<s1.length()){
            icp=s1.charAt(i);

            if(icp=='('){
                // push(icp,stack);
                stack.addElement(icp);
                
            } else if ((Character.isDigit(icp)!=false)||(Character.isAlphabetic(icp)!=false)){
                // push(icp,postfx);
                postfx[sz++] = icp;

            } else if (icp=='*' || icp=='/' || icp=='-' || icp=='+' || icp=='^' ){
                // isp=pop(stack);

                isp = (char)stack.get(stack.size());
                stack.remove(stack.size()-1);

                if(ICP(icp)>ISP(isp)) {
                    // push(isp,stack);
                    // push(icp,stack);
                    stack.addElement(isp);
                    stack.addElement(icp);                
                } else {
                    // push(isp,postfx);
                    // push(icp,stack);
                    postfx[sz++] = isp;
                    stack.addElement(icp);  
                }
            } 
            i++;
        }
        // System.out.println("Postfix: %s\n",postfx);
        // for(i=0;postfx[i]!='\0';i++)
        // {
        //     if(Character.isAlphabetic(postfx[i]))
        //     {
        //         System.out.println("give me %c <--> ",postfx[i]);
        //         postfx[i]=sc.next();
        //     }
        // }
        String post = new String(postfx);
        // Calculator(post);
        tf.setText(post);
        System.out.println("\n\npostfix: "+post);
    }
    public void actionPerformed(ActionEvent ev){

        // number buttons in jpanel
        if(ev.getSource()==jb1){
            result+=jb1.getText();
            showtext+=jb1.getText();
            // tf.setText(showtext);
            tf.setText(result);
        }
        else if(ev.getSource()==jb2){
            result+=jb2.getText();
            showtext+=jb2.getText();
            // tf.setText(showtext);
            tf.setText(result);
        }
        else if(ev.getSource()==jb3){
            result+=jb3.getText();
            showtext+=jb3.getText();
            // tf.setText(showtext);
            tf.setText(result);
        }
        else if(ev.getSource()==jb4){
            result+=jb4.getText();
            showtext+=jb4.getText();
            // tf.setText(showtext);
            tf.setText(result);
        }
        else if(ev.getSource()==jb5){
            result+=jb5.getText();
            showtext+=jb5.getText();
            // tf.setText(showtext);
            tf.setText(result);
        }
        else if(ev.getSource()==jb6){
            result+=jb6.getText();
            showtext+=jb6.getText();
            // tf.setText(showtext);
            tf.setText(result);
        }
        else if(ev.getSource()==jb7){
            result+=jb7.getText();
            showtext+=jb7.getText();
            // tf.setText(showtext);
            tf.setText(result);
        }
        else if(ev.getSource()==jb8){
            result+=jb8.getText();
            showtext+=jb8.getText();
            // tf.setText(showtext);
            tf.setText(result);
        }
        else if(ev.getSource()==jb9){
            result+=jb9.getText();
            showtext+=jb9.getText();
            // tf.setText(showtext);
            tf.setText(result);
        }
        else if(ev.getSource()==jb0){
            result+=jb0.getText();
            showtext+=jb0.getText();
            // tf.setText(showtext);
            tf.setText(result);

        } // buttons with operation
        else if(ev.getSource()==jbplus){ //          +
            // num1=sum;
            // if(result.compareTo("")!=0)
            //     num2=Integer.parseInt(result);
            // else
            //     num2=0;
            // jCalc(num1,num2);
            // showtext=String.valueOf(sum);
            // showtext+="+";
            // result = "+";
            result+="+";
            // tf.setText(showtext);
            tf.setText(result);
            op='+';

        }
        else if(ev.getSource()==jbminus){ //          -
            // num1=sum;
            // if(result.compareTo("")!=0)
            //     num2=Integer.parseInt(result);
            // else
            //     num2=0;            
            // jCalc(num1,num2);
            // showtext=String.valueOf(sum);
            // showtext+="-";
            // result = "-";
            result+="-";
            // tf.setText(showtext);
            tf.setText(result);
            op='-';

        }
        else if(ev.getSource()==jbmulti){ //          *
            // num1=sum;
            // if(result.compareTo("")!=0)
            //     num2=Integer.parseInt(result);
            // else
            //     num2=0;
            // jCalc(num1,num2);
            // showtext=String.valueOf(sum);
            // showtext+="*";
            // result = "*";
            result+="*";
            // tf.setText(showtext);
            tf.setText(result);
            op='*';

        }
        else if(ev.getSource()==jbdiv){ //            /
            // num1=sum;
            // if(result.compareTo("")!=0)
            //     num2=Integer.parseInt(result);
            // else
            //     num2=0;
            // jCalc(num1,num2);
            // showtext=String.valueOf(sum);
            // showtext+="/";
            // result = "/";
            result+="/";
            // tf.setText(showtext);
            tf.setText(result);
            op='/';

        }
        else if(ev.getSource()==jbmod){ //            %
            // num1=sum;
            // if(result.compareTo("")!=0)
            //     num2=Integer.parseInt(result);
            // else
            //     num2=0;
            // jCalc(num1,num2);
            // showtext=String.valueOf(sum);
            // showtext+="%";
            // result = "%";
            result+="%";
            // tf.setText(showtext);
            op='%';

        }
        else if(ev.getSource()==jbequal){ //          =
            // num1=sum;
            // if(result.compareTo("")!=0)
            //     num2=Integer.parseInt(result);
            // else
            //     num2=0;
            // jCalc(num1,num2);            
            // // tf.setText(String.valueOf(sum));
            // showtext=String.valueOf(sum);
            // result="";
            // sum=Postfix(result);
            String s="("+result+")";
            postfix(s);
            result=String.valueOf(sum);
            tf.setText(result);
            op='?'; 

        }
        else if(ev.getSource()==jbclear){ //          Clear
            sum=0;
            // num1=0;
            // num2=0;
            // showtext="";
            result="";
            // tf.setText(showtext);
            tf.setText(result);
            op='?';

        }
    }
    
    public static void main(String args[]){  
        new javaGridCalculatorPostfix();
    }
}