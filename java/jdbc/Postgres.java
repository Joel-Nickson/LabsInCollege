import java.sql.*;


public class Postgres{
	public static void main(String args[])throws Exception{
		try{
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://satao.db.elephantsql.com:5432/xntqejkq" , "xntqejkq", "WjtsAtg6payMqpd1C78pH0sn7q3Ys1dY");

			System.out.println("Connection ok");
			Statement stat = c.createStatement();

			System.out.println("Rollno\t\tName\t\tmark");
			System.out.println("------\t\t----\t\t------");			
			ResultSet rs = stat.executeQuery("SELECT * FROM students ;");

			while(rs.next()){
				int rollno = rs.getInt("rollno");
				String name = rs.getString("username").trim();
				int mark = rs.getInt("marks");

				System.out.println(rollno+"\t\t"+name+"\t\t"+mark);
			}
			rs.close();
			stat.close();
		}
		catch(Exception e){
		    System.out.println("\nerror : "+e);
		}
	}
}
