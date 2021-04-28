import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class javaCardNext implements ActionListener{
	JButton b1,b2;
	JLabel jl1,jl2,jl3,jl4;
	CardLayout card;
	JFrame f;
	JPanel jp,jp1,jp2,jp3,jp4,jbPanel;

	javaCardNext(){
		f = new JFrame("Framey");

		jp = new JPanel();
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jbPanel = new JPanel();

		b1 = new JButton("next");
		b2 = new JButton("previous");
		jbPanel.add(b1);
		jbPanel.add(b2);

		jl1=new JLabel("1");
		jl2=new JLabel("2");
		jl3=new JLabel("3");
		jl4=new JLabel("4");
		
		jp1.add(jl1);
		jp2.add(jl2);
		jp3.add(jl3);
		jp4.add(jl4);

		card = new CardLayout();
		jp.add(jp1);
		jp.add(jp2);
		jp.add(jp3);
		jp.add(jp4);
        jp.setLayout(card);

        f.setLayout(new BorderLayout());

		b1.addActionListener(this);
		b2.addActionListener(this);

		// f.add(b2);
		// f.add(b1);
		f.add(jbPanel,BorderLayout.SOUTH);
		f.add(jp,BorderLayout.NORTH);

        f.setSize(300,200);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1){
			card.next(jp);
		}
		if(e.getSource()==b2){
			card.previous(jp);
		}

	}
	public static void main(String args[]){
		new javaCardNext();
	}
}

// import java.awt.*;  
// import java.awt.event.*;  
// import javax.swing.*; 
// import javax.swing.JFrame; 
//  class javaCardNext extends JFrame implements ActionListener
// {  

// CardLayout card;
// JButton b1,b2,b3,b4;
// JFrame fr;
// JLabel l1,l2,l3,l4;

// Container c;
// javaCardNext()
// {
// c=getContentPane();
// fr=new JFrame("PANEL");

// card=new CardLayout(50,60);
// c.setLayout(card);

// JPanel p1=new JPanel();
// l1=new JLabel("PANEL1");
// p1.add(l1);

//  JPanel p2=new JPanel();
// l2=new JLabel("PANEL2");
// p2.add(l2);

// JPanel p3=new JPanel();
// l3=new JLabel("PANEL3");
// p3.add(l3);

// JPanel p4=new JPanel();
// l4=new JLabel("PANEL4");
// p4.add(l4);

// JPanel p5=new JPanel();
// b1=new JButton("NEXT");
// b1.addActionListener(this);
// b2=new JButton("PREV");
// b2.addActionListener(this);
// b3=new JButton("FIRST");
// b3.addActionListener(this);
// b4=new JButton("Last");
// b4.addActionListener(this);

// p5.add(b1);
// c.add(p1);
// c.add(p2);
// c.add(p3);
// c.add(p4);
// fr.add(c);
// fr.add(p5,BorderLayout.SOUTH);
// fr.setSize(300,300);
// fr.setVisible(true);
// fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// }
// public void actionPerformed(ActionEvent i)
// {
//  card.next(c);
//  }
 
//  public static void main(String [] args){
//  new javaCardNext();
 
//  }


// }