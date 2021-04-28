import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaGridCalculate implements ActionListener{

    JTextField tf;  
    JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb0
    ,jbplus,jbminus,jbmulti,jbdiv,jbmod,jbequal,jbclear;     

    int num2=0,num1=0,sum=0,top=0;
    String result="",showtext="",bettershow="";
    char op='?';

    JavaGridCalculate(){
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

    public void jCalc(int first,int second){
        System.out.println("first="+first+" second="+second);
        if(op=='+')
            sum=first+second;
        else if(op=='-')
            sum=first-second;
        else if(op=='*')
            sum=first*second;
        else if(op=='/'){
            if(second==0)  {
                tf.setText("error : division by zero");
                sum=0;
                num1=0;
                num2=0;
                showtext="";
                result="";
                bettershow="";
                op='?';
            }
            sum=first/second;
        }
        else if(op=='%')
            sum=first%second;
        else
            if(first==0)
                sum=second;
            else if(second==0)
                sum=first;
    }

    public void actionPerformed(ActionEvent ev){

        // number buttons in jpanel
        if(ev.getSource()==jb1 || ev.getSource()==jb2 || ev.getSource()==jb3 || ev.getSource()==jb4 || ev.getSource()==jb5 || ev.getSource()==jb6 || ev.getSource()==jb7 || ev.getSource()==jb8 || ev.getSource()==jb9 || ev.getSource()==jb0){
            
            JButton jbNumbers=(JButton)ev.getSource();
            result+=jbNumbers.getText();
            showtext+=jbNumbers.getText();
            bettershow+=jbNumbers.getText();
            tf.setText(bettershow);
        } 
        // buttons with operation
        else if(ev.getSource()==jbplus || ev.getSource()==jbminus || ev.getSource()==jbmulti || ev.getSource()==jbdiv || ev.getSource()==jbmod){ 
            
            JButton jbOper=(JButton)ev.getSource();
            num1=sum;
            if(result.compareTo("")!=0)
                num2=Integer.parseInt(result);
            else
                num2=0;            
            jCalc(num1,num2);
            showtext=String.valueOf(sum);
            showtext+=jbOper.getText();
            result = "";
            bettershow+=jbOper.getText();
            // tf.setText(showtext);
            tf.setText(bettershow);
            op=jbOper.getText().charAt(0);

        }
        else if(ev.getSource()==jbequal){ //          =
            num1=sum;
            if(result.compareTo("")!=0)
                num2=Integer.parseInt(result);
            else
                num2=0;
            jCalc(num1,num2);           
            if(num2!=0) 
                tf.setText(String.valueOf(sum));
            showtext=String.valueOf(sum);
            result="";
            result=String.valueOf(sum);
            bettershow=result;
            op='?'; 

        }
        else if(ev.getSource()==jbclear){ //          Clear
            sum=0;
            num1=0;
            num2=0;
            showtext="";
            result="";
            bettershow="";
            tf.setText(showtext);
            // tf.setText(result);
            op='?';
        }
    }
    
    public static void main(String args[]){  
        new JavaGridCalculate();
    }
}