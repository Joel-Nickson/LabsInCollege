import java.sql.*;
import java.io.*;
public class jdbc {
    public static void main(String[] args) {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://ziggy.db.elephantsql.com/" , "jvhdatnt", "QVGQUWMGkuEPmTNQ6QBrTqEZtvftVeg4");

            System.out.println("Opened database");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM test");
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID ="+id);
                System.out.println("Name = "+name);
            }
            c.close();
        }
         catch (Exception e) {
           //TODO: handle exception
           System.err.println(e.getMessage());
        }
       
    }
    
}


// import java.sql.*;
// import java.io.*;
// public class jdbc {
//     public static void main(String[] args) {
//     	Connection c = null;
//         try {
//             Class.forName("org.postgresql.Driver");
//             c = DriverManager.getConnection(" jdbc:postgresql://ziggy.db.elephantsql.com/" , "jvhdatnt", "QVGQUWMGkuEPmTNQ6QBrTqEZtvftVeg4");
//             System.out.println("Opened database");
//             Statement st = c.createStatement();
//             ResultSet rs = st.executeQuery("SELECT * FROM test");
//             while(rs.next())
//             {
//                 int id = rs.getInt("id");
//                 String name = rs.getString("name");
//                 System.out.println("ID ="+id);
//                 System.out.println("Name = "+name);
//             }
//         } catch (Exception e) {
//            //TODO: handle exception
//            System.err.println(e.getMessage());
//         }
       
//     }
    
// }