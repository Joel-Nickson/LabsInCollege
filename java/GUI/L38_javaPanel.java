import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class javaPanel{
	javaPanel(){
		JFrame f = new JFrame("Framey");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp = new JPanel();
		JButton b1 = new JButton("buttn1");
		JButton b2 = new JButton("buttn2");

		jp1.setBackground(Color.green);
		jp1.add(b1);
		// f.add(jp1);

		jp2.setBackground(Color.red);
		jp2.add(b2);
		// f.add(jp2);

		jp.setBackground(Color.yellow);
		jp.add(jp1);
		jp.add(jp2);
		f.add(jp);

        f.setSize(300,200);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]){
		new javaPanel();
	}
}