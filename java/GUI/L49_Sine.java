import javax.swing.*;
import java.awt.*;
public class Sine extends JFrame{
	public Sine(){
		setSize(2000, 800);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void paint(Graphics g){
		super.paint(g);
		int x_prev = 0, y_prev = 0, x, y;
		// Drawing x - axis.
		g.drawLine(0, 200, 360, 200);
		// x ranges from 0 to 360 degrees
		for(x = 0; x < 360; x++){
		// Math.sin() takes angle in radians as argument.
		// To convert degrees to radians multiply by (3.14 / 180)
		y = (int) (Math.sin(x * Math.PI / 180) * 100);
		// Drawing sine wave as small lines.
		// 200 is added to shift down, else will not be fully visible.
		g.drawLine(x_prev, y_prev + 200, x, y + 200);
		x_prev = x;
		y_prev = y;
		}
	}
	public static void main(String[] args){
		new Sine();
	}
}