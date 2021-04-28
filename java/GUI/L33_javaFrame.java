import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class javaFrame implements ActionListener{
    JLabel jl;  

    javaFrame(){
        JFrame f = new JFrame("Framey");
        JButton jb = new JButton("click");
        jl = new JLabel("welcome");

        jb.addActionListener(this);
        f.setSize(400,200);
        f.add(jl);
        f.add(jb);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ev){
        jl.setText("Hi");
    }
    
    public static void main(String args[]){  
        new javaFrame();
    }
}