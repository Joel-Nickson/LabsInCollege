import java.awt.*;
import java.awt.image.*;
import java.applet.*;
import javax.swing.*;
import java.util.Scanner;


/*<applet code="AppletImg.class" width=300 height=200>	</applet>
*/

public class AppletImg extends Applet{
	Image img;
	ImageIcon icon;
	String f;
	public void init(){
		Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the File name: ");
		f = "photo.png";     //sc.nextLine();
    }
	public void start(){
	    try{
            icon = new ImageIcon(f);
            img = icon.getImage();
        }
        catch(Exception e){}   
	}
	public void paint(Graphics g){
		g.drawImage(img,100,50,Color.white,this);
	// g.drawString("hello",100,100);
	}
}
