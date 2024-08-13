package librarysystem;

import Connectivity.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class CrudMethod 
{
    //method to add book to the database
    public boolean add(BooksInfo book)
    {
        boolean check = false;
        Connection con = DB.Con(); //getting connection from Database
        
        try
        {
            String query = "insert into books(author,title,isbn,quantity) values(?,?,?,?)";
            PreparedStatement p = con.prepareStatement(query);
            
            p.setString(1, book.getauthor());
            p.setString(2, book.gettitle());
            p.setString(3, book.getisbn());
            p.setInt(4, book.getquantity());
            
            p.executeUpdate();
            check = true;
            
        }catch(Exception e)
        {
            System.out.println(e);
        } 
        return check;
    }
    //METHOD TO DISPLAY THE AVAILABLE BOOKS
    public void display()
    {
        Connection con = DB.Con();
        try
        {
        String query = "select * from  books";
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(query);
        
        while(rs.next())
        {
            System.out.println
            (
            "Author   : "+rs.getString(1)+"\n"+
            "Title    : "+rs.getString(2)+"\n"+
            "ISBN     : "+rs.getString(3)+"\n"+
            "Quantity : "+rs.getString(4)+"\n"
            );
            System.out.println("*********************");
        }
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    //METHOD TO UPDATE THE BOOK DETAILS with strings
    public boolean update(String isbn,String newUpdated, int choice, BooksInfo book)
    {
        Connection con = DB.Con();
        boolean check = false;
        
        try
        {
            if(choice == 1)
            {
                String query = "update books set title=? where isbn=?";
                PreparedStatement p = con.prepareStatement(query);
            
                p.setString(1,newUpdated);
                p.setString(2,isbn);
                p.execute();
            
               check = true;
            }
            else if(choice == 2)
            {
                String query = "update books set author=? where isbn=?";
                PreparedStatement p = con.prepareStatement(query);
            
                p.setString(1,newUpdated);
                p.setString(2,isbn);
                p.execute();
            
                check = true;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return check;
    }
    
    //METHOD TO DELECTE BOOK RECORD FROM THE RECORDS/DATABASE
    public boolean delete(String isbn)
    {
        Connection con = DB.Con();
        boolean check = false;
        
        try
        {
            String query = "delete from books where isbn="+isbn;
            PreparedStatement p = con.prepareStatement(query);
            p.execute();
            
            check = true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return check;
    }
    //METHOD TO SEARCH BOOKS AVAILABLE BOOKS IN THE DATABASE
    public void search(int choice, String searchKey)
    {
        Connection con = DB.Con();
        
        String sqlQuary =""; // Initializes an empty SQL query string.
        //switch (choice) { ... }: Based on the value of choice, it assigns the appropriate SQL query to sqlQuery.
        switch(choice)
        {
            case 1: sqlQuary = "SELECT * FROM books WHERE author LIKE ?"; //If choice is 1, the query searches for books by author.
                break;
            case 2: sqlQuary = "SELECT * FROM books WHERE title LIKE ?"; //If choice is 2, the query searches for books by title.
                break;
            case 3: sqlQuary = "SELECT * FROM books WHERE isbn LIKE ?";//If choice is 3, the query searches for books by isbn.
              break;
            default:
                System.out.println("Invalid search choice.");
        }
        
        try
        {
            PreparedStatement p = con.prepareStatement(sqlQuary);
            p.setString(1,"%"+ searchKey + "%");
            ResultSet rs = p.executeQuery(); //This sets the first parameter in the SQL query to the search term.
                                              // The % wildcard is used in SQL to match any sequence of characters, making it a partial match search.
           if(!rs.isBeforeFirst()) // Check if the result set is empty
           {
               System.out.println("\t****No record found.****");
           }
           else
           {
               System.out.println("\t**** BOOK IS AVAILABLE ****");
             while(rs.next())
              {
               System.out.println
              (
                "Author   : "+rs.getString("author")+"\n"+ //Retrieves the value of the "author" column.
                "Title    : "+rs.getString("title")+"\n"+  //Retrieves the value of the "title" column.
                "ISBN     : "+rs.getString("isbn")+"\n"+  // Retrieves the value of the "isbn" column.
                "Quantity : "+rs.getString("quantity")+"\n" //Retrieves the value of the "quantity" column.
            );
                System.out.println("*********************");
             }
           }
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
        //METHOD TO ADD MEMBERS OF THE LIBRARY
    public boolean addMembers(MemberInfo member)
    {
        boolean check = false;
       Connection con = DB.Con();
        
      try
        {
            String query = "insert into members(name,surname,member_id,email,phone_number) values(?,?,?,?,?)";
            PreparedStatement p = con.prepareStatement(query);
            
            p.setString(1, member.getname());
            p.setString(2, member.getsurname());
            p.setInt(3, member.getmember_id());
            p.setString(4, member.getemail());
            p.setString(5, member.getphone_number());
            
            
            p.executeUpdate();
            check = true;
            
        }catch(Exception e)
        {
            System.out.println(e);
        } 
        return check;
     }
  
    
}
