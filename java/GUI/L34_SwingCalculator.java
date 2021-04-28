import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SwingCalculator implements ActionListener{
	
	JTextField jt1,jt2,jt3;
	JButton b1,b2,b3,b4;

	SwingCalculator(){
		JFrame f = new JFrame("Framey");
		JLabel jl = new JLabel("\nresult:");

		jt1=new JTextField("100");
		jt2=new JTextField("100");
		jt3=new JTextField("10000");

		b1=new JButton("+");
		b2=new JButton("-");
		b3=new JButton("*");
		b4=new JButton("/");

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		f.setSize(600,400);
		f.setVisible(true);
		f.setLayout(new FlowLayout());		
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(jt1);
        f.add(jt2);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(jl);
        f.add(jt3);

	}
	public void actionPerformed(ActionEvent e){

		String s1,s2,s3;

		s1=jt1.getText();
		s2=jt2.getText();

		int a=Integer.parseInt(s1);
		int b=Integer.parseInt(s2);
		int c=0;

		if(e.getSource()==b1)
			c=a+b;
		else if(e.getSource()==b2)
			c=a-b;
		else if(e.getSource()==b3)
			c=a*b;
		else if(e.getSource()==b4)
			c=a/b;

		s3=String.valueOf(c);
		jt3.setText(s3);

	}
	public static void main(String args[]){
		new SwingCalculator();
	}
}