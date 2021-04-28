import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;
public class javaMouseMotionListener extends JFrame implements MouseMotionListener{  
    Label l;  
    javaMouseMotionListener(){  
        l=new Label();   
          
        addMouseMotionListener(this); 

        add(l);  
  
        setLayout(new FlowLayout());   
        setSize(300,300); 
        setVisible(true);  
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }  
    public void mouseMoved(MouseEvent e) {  
        l.setText("Mouse Moved");  
    }  
    public void mouseDragged(MouseEvent e) {  
        l.setText("Mouse Dragged");  
    }  
    public static void main(String[] args) {  
        new javaMouseMotionListener();  
    }  
}  