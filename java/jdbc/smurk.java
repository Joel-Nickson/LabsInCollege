import java.sql.*;
public class smurk{ 
	public static void main(String args[]){
		try{
            Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection("jdbc:postgresql://john.db.elephantsql.com:5432/acjgzxrx","acjgzxrx","EWb_5tR1V3-B-3B6rB-jxjQlaBFVZqaj");
			System.out.println("Connection ok");
			Statement stat = c.createStatement();

			System.out.println("Name \t\t\tsubject  \t\tmark");
			System.out.println("-----\t\t\t------  \t\t------");			
			ResultSet rs = stat.executeQuery("SELECT * FROM error400 ;");

			while(rs.next()){
				String name = rs.getString("name");
				String subject = rs.getString("subject");
				int mark = rs.getInt("mark");

				System.out.println(name+"\t"+subject+"\t"+String.valueOf(mark));
			}
			rs.close();
			stat.close();
		}
		catch(Exception e){
		    System.out.println("\nerror : "+e);
		}
	}
}
