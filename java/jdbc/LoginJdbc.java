import java.sql.*;

public class LoginJdbc {
    public static void main(String[] args) {
    	String select="select * from logintable ";
    	String j="jol";
    	String w="where username='";
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://satao.db.elephantsql.com:5432/mkdqeluv" , "mkdqeluv", "5KnjTGDyXPpyliFd8UExf1I2BR2p1M3Y");

            System.out.println("Opened database");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(select+w+j+"'");
            while(rs.next())
            {
                String name = rs.getString("name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Name ="+name);
                System.out.println("Username = "+username);
                System.out.println("password = "+password);
            }
            c.close();
        }
         catch (Exception e) {
           System.err.println(e.getMessage());
        }
       
    }
    
}
// String insert="insert into logintable(name,username,password) ";
// String value=
// String select="select * from logintable" 