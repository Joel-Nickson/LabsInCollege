import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RadioButtn implements ActionListener{
	
	JTextField tf1,tf2,tf3;
	JRadioButton b1,b2;
	JLabel l1,l2,l3,l4;

	RadioButtn(){
		JFrame f = new JFrame("Framey");
		ButtonGroup g=new ButtonGroup();

		l1 = new JLabel("name : ");
		l2 = new JLabel("  gender : ");
		l3 = new JLabel("  details : ");

		tf1=new JTextField("",13);
		tf2=new JTextField("",13);

		tf1.addActionListener(this);

		b1=new JRadioButton("male");
		b2=new JRadioButton("female");

		b1.addActionListener(this);
		b2.addActionListener(this);

		f.setSize(250,300);
		f.setVisible(true);
		f.setLayout(new FlowLayout());		
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // name
        f.add(l1);
        f.add(tf1);

        // gender
        f.add(l2);
		f.add(b1);
		f.add(b2);

		// details
		f.add(l3);
        //f.add(tf2); //

        // Button grouping
		g.add(b1);
		g.add(b2);

	}
	public void actionPerformed(ActionEvent e){

		String s1,s2,s3;
		s1="";
		s2="";
		s3="details : ";

		s1=tf1.getText();

		if(e.getSource()==tf1)
			s1=tf1.getText();

		if(b1.isSelected())  			//isSelected()
			s2="male";
		else if(e.getSource()==b2)		//getSource()
			s2="female";
		
		int c=s1.compareTo("");
		if(c!=0 && s2!="")
			// tf2.setText(s1+" "+s2);
			l3.setText(s3+s1+" is a "+s2);

	}
	public static void main(String args[]){
		new RadioButtn();
	}
}