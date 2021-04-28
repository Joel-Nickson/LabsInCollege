import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;
public class javaMouseListener extends JFrame implements MouseListener{  
    Label l;  
    javaMouseListener(){  
        l=new Label();   
          
        addMouseListener(this); 

        add(l);  

        l.setBounds(20,50,100,20);  
        setLayout(null);   
        setSize(300,300); 
        setVisible(true);  
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }  
    public void mouseClicked(MouseEvent e) {  
        l.setText("Mouse Clicked");  
    }  
    public void mouseEntered(MouseEvent e) {  
        l.setText("Mouse Entered");  
    }  
    public void mouseExited(MouseEvent e) {  
        l.setText("Mouse Exited");  
    }  
    public void mousePressed(MouseEvent e) {  
        l.setText("Mouse Pressed");  
    }  
    public void mouseReleased(MouseEvent e) {  
        l.setText("Mouse Released");  
    }  
    public static void main(String[] args) {  
        new javaMouseListener();  
    }  
}  