import java.sql.*;
import java.util.*;

public class StudentsUpdate{
	static String insert="insert into students (rollno, username, marks) values (32,'cini',60)";
	static String update="update students ";//set
	static String select="select * from students ";
	static String delete="delete from students ";
	static String set="";
	static String del="";
	static ResultSet rs;

	static void jdbcQuery(String query){
		try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://satao.db.elephantsql.com:5432/xntqejkq" , "xntqejkq", "WjtsAtg6payMqpd1C78pH0sn7q3Ys1dY");

            // System.out.println("Opened database");
            Statement st = c.createStatement();
            rs = st.executeQuery(query);
            c.close();
        }
         catch (Exception e) {
           System.err.println(e.getMessage());
        }
	}
	static void jdbcUpdate(String query){
		try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://satao.db.elephantsql.com:5432/xntqejkq" , "xntqejkq", "WjtsAtg6payMqpd1C78pH0sn7q3Ys1dY");

            // System.out.println("Opened database");
            Statement st = c.createStatement();
            st.executeUpdate(query);
            c.close();
        }
         catch (Exception e) {
           System.err.println(e.getMessage());
        }

	}	
	static void display(){
		try{
			System.out.println("Name\t\tmarks\t\trollno");
			System.out.println("----\t\t-----\t\t------");
			while(rs.next()){
				int rollno = rs.getInt("rollno");
				String username = rs.getString("username").trim();
				int marks = rs.getInt("marks");
				System.out.println(username+"\t\t"+marks+"\t\t"+rollno);
			}
	    }
	    catch(Exception e){
	    	System.out.println(e.getMessage());
	    }
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		boolean text = true;
		System.out.println("0.display");
		System.out.println("1.update rollno 12 to Neethu");
		System.out.println("2.delete name=\'cini\'");
		System.out.println("3.display students with marks > 70");
		System.out.println("4.calculate ranks and display");

		System.out.print("\nchoice: ");
		int choice = sc.nextInt();

		while(true){
			switch(choice){
				case 0: jdbcQuery(select);
					display();
					break;
				case 1: System.out.println("\nUpdating rollno to neethu");
					set = "set username='Neethu' where rollno =12";
					jdbcUpdate(update+set);
					break;				
				case -1: System.out.println("\nUpdating rollno  back to hello");
					jdbcUpdate(update+"set username='hello' where rollno =12");
					break;
				case 2: System.out.println("\ndeleting cini");
					del = "where username = 'cini'";
					jdbcUpdate(delete+del);
					break;
				case -2: System.out.println("\ninserting back cini");
					jdbcUpdate(insert); //
					break;
				case 3: System.out.println("\nDisplay students with marks > 70");
					jdbcQuery(select+" where marks > 70");
					display();
					break;
				case 4: System.out.println("\ncalculating ranks...");
					jdbcQuery(select+"order by marks desc");
					display();
					break;
				default :
					System.out.println("0.display");
					System.out.println("1.update rollno 12 to Neethu");
					System.out.println("2.delete name=\'cini\'");
					System.out.println("3.display students with marks > 70");
					System.out.println("4.calculate ranks and display");

			}

			System.out.print("\nchoice: ");
			choice = sc.nextInt();

		}
	}
}