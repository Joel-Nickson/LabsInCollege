import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrafficLight extends JFrame implements ActionListener{

	JPanel jpbuttn;
	JRadioButton jbgreen,jbyellow,jbred;
	boolean red,green,yellow;	       
	Color grey = new Color(100, 100, 100); 

	TrafficLight(){		
		ButtonGroup bg = new ButtonGroup();

		jpbuttn = new JPanel();

		jbgreen = new JRadioButton("Green");
		jbyellow = new JRadioButton("Yellow");
		jbred = new JRadioButton("Red");

		jbgreen.addActionListener(this);
		jbyellow.addActionListener(this);
		jbred.addActionListener(this);

		jpbuttn.add(jbgreen);	
		jpbuttn.add(jbyellow);
		jpbuttn.add(jbred);

		// setLayout(new FlowLayout());
		setLayout(new BorderLayout());
		add(jpbuttn,BorderLayout.SOUTH);
		
		setSize(900,400);		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bg.add(jbred);
		bg.add(jbyellow);
		bg.add(jbgreen);	

	}
	public void paint(Graphics g){

		g.drawRoundRect(250,50,95,260,150,100);
		g.drawOval(270,60,60,60);
		g.drawOval(270,150,60,60);
		g.drawOval(270,240,60,60);

		g.setColor( Color.black );
		g.fillRoundRect(250,50,95,260,150,100);
		g.setColor( grey );//Color.white );		
		g.fillOval(270,60,60,60);				//green
		g.fillOval(270,150,60,60);				//yellow
		g.fillOval(270,240,60,60);				//red

		if(green == true){
			g.setColor( Color.green );
			g.fillOval(270,60,60,60);
		}	
		else if(yellow == true){
			g.setColor( Color.yellow );
			g.fillOval(270,150,60,60);
		}	
		else if(red == true){
			g.setColor( Color.red );
			g.fillOval(270,240,60,60);
		}	

	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jbgreen){
			green = true;
			yellow = false;
			red = false;
		}		
		else if(e.getSource()==jbyellow){
			green = false;
			yellow = true;
			red = false;
		}
		else if(e.getSource()==jbred){
			green = false;
			yellow = false;
			red = true;
		}
		repaint();
	
	}
	public static void main(String args[]){
		new TrafficLight();
	}

}