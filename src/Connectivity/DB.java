package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;


public class DB 
{
    public static Connection Con()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localHost/librarysystem","root","0703");
            return con;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
}
