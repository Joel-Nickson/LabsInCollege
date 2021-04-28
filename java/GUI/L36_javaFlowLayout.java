import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class javaFlowLayout implements ActionListener{
    JButton jb;

    javaFlowLayout(){
        JFrame f = new JFrame("Framey");

        jb = new JButton("click");
        jb.addActionListener(this);

        f.setSize(400,200);
        f.add(jb);

        f.setLayout(new FlowLayout(FlowLayout.CENTER));
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ev){
        jb.setText("Hi");
    }
    
    public static void main(String args[]){  
        new javaFlowLayout();
    }
}