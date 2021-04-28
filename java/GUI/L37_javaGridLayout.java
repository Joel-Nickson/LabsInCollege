import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class javaGridLayout{    

    javaGridLayout(){
        JFrame f = new JFrame("Framey");
        JButton jb1,jb2,jb3,jb4;

        jb1 = new JButton("1");
        jb2 = new JButton("2");
        jb3 = new JButton("3");
        jb4 = new JButton("4");
        //jb.addActionListener(this);

        f.setSize(400,200);
        f.add(jb1);
        f.add(jb2);
        f.add(jb3);
        f.add(jb4);

        f.setLayout(new GridLayout(3,2));
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String args[]){  
        new javaGridLayout();
    }
}