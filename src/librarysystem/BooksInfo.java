package librarysystem;

public class BooksInfo
{
    private String author,title,isbn;
    private int quantity;
    
    public BooksInfo(){} // non paramiterilized constructor
    public BooksInfo(String author,String title,String isbn,int quantity)
    {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.quantity = quantity;
    }
    
    //setter and getter methods
    public void setauthor(String author)
    {
        this.author = author;
    }
    public String getauthor()
    {
        return author;
    }
    public void settitle(String title)
    {
        this.title = title;
    }
    public String gettitle()
    {
        return title;
    }
    public void setisbn(String isbn)
    {
        this.isbn = isbn;
    }
    public String getisbn()
    {
        return isbn;
    }
    public void setquantity(int quantity)
    {
        this.quantity = quantity;
    }
    public int getquantity()
    {
        return quantity;
    }
    //toString function to display class information
    
    @Override
    public String toString()
    {
        return "Author   : "+author  +"\n"+
               "Title    : "+title   +"\n"+
               "ISBN     : "+isbn    +"\n"+
               "Quantity : "+quantity+"\n"; 
    }
}
