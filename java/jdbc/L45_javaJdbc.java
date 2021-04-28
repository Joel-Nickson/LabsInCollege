import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class javaJdbc{
	public static void main(String args[])throws Exception{
		try{
            Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection("postgres://acjgzxrx:EWb_5tR1V3-B-3B6rB-jxjQlaBFVZqaj@john.db.elephantsql.com:5432/acjgzxrx","acjgzxrx","EWb_5tR1V3-B-3B6rB-jxjQlaBFVZqaj");
			System.out.println("Connection ok");
			Statement stat = c.createStatement();

			System.out.println("Name\tsubject\tmark");
			System.out.println("------    --------    ------");			
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
