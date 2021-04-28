import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// password = setEchoChar('any char")

public class LoginFrame implements ActionListener{//extends JFrame implements ActionListener{
	//.setText("<html><h1>header1 text</h1></html>");
	static String insert="insert into logintable(name,username,password) ";
	static String select="select * from logintable ";
	static JFrame f;
	static JButton signin ,sinbutton ,signup ,supbutton ,retry;
	static JTextField name ,user ,pass;
	static JPanel s_up ,s_uppage ,s_upbutton ,s_in ,s_inpage ,s_inbutton ,s_login ,s_loginbutton ,s_frame;
	static ResultSet rs;
	static String database_name, username, password ,n ,u ,p;

	LoginFrame(){
		f = new JFrame("Framey");

		name = new JTextField("",13);
		user = new JTextField("",13);
		pass = new JTextField("",13);

		signin = new JButton("Sign In");
		signin.addActionListener(this);
		signup = new JButton("Sign Up");
		signup.addActionListener(this);
		sinbutton = new JButton("Sign in");
		sinbutton.addActionListener(this);
		supbutton = new JButton("Sign up");
		supbutton.addActionListener(this);
		retry = new JButton("retry");
		retry.addActionListener(this);
		
		s_frame = loginpage();
		f.add(s_frame);

		f.setLayout(new FlowLayout());
        f.setSize(300,200);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}	
	public void actionPerformed(ActionEvent e){

		f = new JFrame("Framey");
		JPanel newJpanel = new JPanel();

		if(e.getSource()==signin){								//go to signinpage
			newJpanel = signinpage();

		}
		else if(e.getSource()==signup){							//go to signuppage
			newJpanel = signuppage();

		}
		else if(e.getSource()==supbutton){						//check info to create
			n= new String(name.getText().trim());
			u= new String(user.getText().trim());
			p= new String(pass.getText().trim());
			String query = new String("where username='"+u+"';");
			jdbc(select+query);	
			boolean nauth=false;
			int ul=u.length();	
			if(username!=null){
				// nauth = username.regionMatches(true,0,u,0,ul);
				nauth = username.trim().equals(u);
			}
			// System.out.println("\tuser="+nauth);
			if(nauth)
				newJpanel = userexists();
			else{
				query = new String("values('"+n+"','"+u+"','"+p+"');");
				jdbc(insert+query);
				newJpanel = success();
			}

		}
		else if(e.getSource()==sinbutton){						//check info to login
			u= new String(user.getText().trim());
			p= new String(pass.getText().trim());
			int ul,pl;
			String query = new String("where username='"+u+"';");
			jdbc(select+query);

			ul=u.length();
			pl=p.length();
			boolean nauth=false,pauth=false;
			if(username!=null)	{
				// nauth = username.regionMatches(true,0,u,0,ul);
				// pauth = password.regionMatches(true,0,p,0,pl);
				nauth = username.trim().equals(u);
				pauth = password.trim().equals(p);
			}			
			// System.out.println("\tuser="+nauth+"\tpass="+pauth);
			// System.out.println("\tuser="+u+"\tpass="+p);
			if(nauth && pauth)
				newJpanel = welcome();
			else
				newJpanel = wrongpass();

		}			
		else if(e.getSource()==retry){
			newJpanel = loginpage();

		}
		f.add(newJpanel);
		f.setLayout(new FlowLayout());
        f.setSize(300,200);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	static void jdbc(String query){
		try {
            // database_name = "";
            // username = "";
            // password = "";
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://satao.db.elephantsql.com:5432/mkdqeluv" , "mkdqeluv", "5KnjTGDyXPpyliFd8UExf1I2BR2p1M3Y");

            // System.out.println("Opened database");
            Statement st = c.createStatement();
            rs = st.executeQuery(query);
            if(rs.next())
            {
                database_name = new String(rs.getString("name"));
                username = new String(rs.getString("username"));
                password = new String(rs.getString("password"));
                // System.out.println("Name ="+database_name);
                // System.out.println("Username = "+username);
                // System.out.println("password = "+password);
            }
            c.close();
        }
         catch (Exception e) {
           System.err.println(e.getMessage());
        }

	}	
	static JPanel loginpage() {
		s_login = new JPanel();
		s_loginbutton = new JPanel();
		JLabel label = new JLabel();
		label.setText("<html><h1> Login Page </h1></html>");

		s_login.setLayout(new BorderLayout());
		s_loginbutton.setLayout(new FlowLayout());

		s_loginbutton.add(signup);
		s_loginbutton.add(signin);
		s_login.add(label,BorderLayout.CENTER);
		s_login.add(s_loginbutton,BorderLayout.SOUTH);
		return s_login;

	}
	static JPanel signuppage() {
		s_up = new JPanel();
		s_up.setLayout(new GridLayout(3,2));
		JLabel nname = new JLabel("Name: ");
		s_up.add(nname);
		s_up.add(name);
		JLabel usern = new JLabel("Username: ");
		s_up.add(usern);
		s_up.add(user);
		JLabel passw = new JLabel("Password: ");
		s_up.add(passw);
		s_up.add(pass);

		s_upbutton = new JPanel();
		s_upbutton.setLayout(new FlowLayout());
		s_upbutton.add(supbutton);

		s_uppage = new JPanel();
		s_uppage.setLayout(new BorderLayout());
		s_uppage.add(s_up,BorderLayout.CENTER);
		s_uppage.add(s_upbutton,BorderLayout.SOUTH);
		return s_uppage;

	}
	static JPanel signinpage() {
		s_in = new JPanel();
		s_in.setLayout(new GridLayout(2,2));

		JLabel usern = new JLabel("Username: ");
		s_in.add(usern);
		s_in.add(user);
		JLabel passw = new JLabel("Password: ");
		s_in.add(passw);
		s_in.add(pass);

		s_inbutton = new JPanel();
		s_inbutton.setLayout(new FlowLayout());
		s_inbutton.add(sinbutton);

		s_inpage = new JPanel();
		s_inpage.setLayout(new BorderLayout());
		s_inpage.add(s_in,BorderLayout.CENTER);
		s_inpage.add(s_inbutton,BorderLayout.SOUTH);
		return s_inpage;

	}
	static JPanel success() {
		String text = n+" has successfully registered.";
		JLabel label = new JLabel();
		label.setText(text);

		JPanel jfinal = new JPanel();
		jfinal.setLayout(new BorderLayout());
		jfinal.add(label,BorderLayout.CENTER);
		jfinal.add(retry,BorderLayout.SOUTH);
		return jfinal;
	}
	static JPanel userexists() {
		String text = database_name.trim()+" already exists in the system.";
		JLabel label = new JLabel();
		label.setText(text);

		JPanel jfinal = new JPanel();
		jfinal.setLayout(new BorderLayout());
		jfinal.add(label,BorderLayout.CENTER);
		jfinal.add(retry,BorderLayout.SOUTH);
		return jfinal;

	}
	static JPanel welcome() {
		String text = "Welcome \n"+database_name.trim();
		JLabel label = new JLabel();
		label.setText(text);

		JPanel jfinal = new JPanel();
		jfinal.setLayout(new BorderLayout());
		jfinal.add(label,BorderLayout.CENTER);
		jfinal.add(retry,BorderLayout.SOUTH);
		return jfinal;

	}
	static JPanel wrongpass() {
		String text = "Wrong Username/Password.";
		JLabel label = new JLabel();
		label.setText(text);

		JPanel jfinal = new JPanel();
		jfinal.setLayout(new BorderLayout());
		jfinal.add(label,BorderLayout.CENTER);
		jfinal.add(retry,BorderLayout.SOUTH);
		return jfinal;

	}
	public static void main(String args[]){
		new LoginFrame();

	}
}