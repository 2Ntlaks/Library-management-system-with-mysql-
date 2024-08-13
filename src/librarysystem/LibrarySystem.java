package librarysystem;

import java.util.Scanner;

public class LibrarySystem 
{
    public static void main(String[] args)
    {
       Scanner input = new Scanner(System.in);
       CrudMethod cd = new CrudMethod (); //Creating this object here so it can be visible to all the methods
       
        System.out.println("\t**** WELCOME TO A LIBRARY MANAGEMENT SYSTEM ****");
       
       while(true)
       {
           System.out.println
           (
               "Press 1 for adding a book \n"+
               "Press 2 for dispalying available a books \n"+
               "Press 3 for updating book information \n"+
               "Press 4 for deleting a book \n"+
               "Press 4 for existing System \n"+
               "Press 5 for searching book \n"+
               "Press 6 for add members  \n"
           );
           System.out.print("Please provide input:-> ");
           int userInput = input.nextInt();
           input.nextLine();
           
           switch(userInput)
           {
               case 1:
               {
                   System.out.println("\t**** ADDING BOOK ****");
                   System.out.print("Enter book author  : -> ");
                   String author = input.nextLine();
                   System.out.print("Enter book title   : -> ");
                   String title = input.nextLine();
                   System.out.print("Enter book isbn    : -> ");
                   String isbn = input.nextLine();
                   System.out.print("Enter book quantity: -> ");
                   int quantity = input.nextInt();
                   
                   BooksInfo book = new BooksInfo(author,title,isbn,quantity);
                   
                   boolean valid = cd.add(book); //calling method add from 
                   
                   if(valid == true)
                       System.out.println("\t**** BOOK RECORD ADDED SUCCESSFULLY ****");
                   else
                        System.out.println("\t**** ADDING BOOK IS NOT SUCCESSFUL, PROBLEM OCCURED **** ");
              
                   break;
               }
               case 2:
               {
                   System.out.println("\t1**** Available books ****");
                   cd.display();
                   break;
               }
               case 3:
               {
                   System.out.println("**** UPDATING BOOK DETAILS ****");
                   System.out.println
                                    (
                                       "Press 1 for updating title \n"+
                                       "Press 2 for updating quantity \n"
                                    );
                   int choice = input.nextInt();
                   input.nextLine();
                   
                   if(choice == 1)
                   {
                       System.out.print("Enter book isbn      :-> ");
                       String isbn = input.nextLine();
                       System.out.print("Enter new book title :-> ");
                       String title = input.nextLine();
                       
                       BooksInfo book = new BooksInfo();
                       
                       book.settitle(title);
                       
                       boolean validUpdate = cd.update(isbn, title, choice, book);
                       
                       if(validUpdate == true)
                           System.out.println("**** Title updated successfully ****");
                       else
                           System.out.println("**** Title is not updated successfully, Problem occured ****");
                   }
                   else if(choice == 2)
                   {
                       System.out.print("Enter book isbn        :-> ");
                       String isbn = input.nextLine();
                       System.out.print("Enter new book title:-> ");
                       String author = input.nextLine();
                       
                       BooksInfo book = new BooksInfo();
                       
                       book.setauthor(author);
                       
                       boolean validUpdate = cd.update(isbn, author, choice, book);
                       
                       if(validUpdate == true)
                           System.out.println("**** Author updated successfully ****");
                       else
                           System.out.println("**** Author is not updated successfully, Problem occured ****");
                   }
                   
                   break;
               }
               case 4:
               {
                   System.out.println("EXITED SUCCESSFULLY");
                   System.exit(0);
                   break;
               }
               case 5:
               {
                   System.out.println("\t**** SEARCHING BOOKS ****");
                   System.out.println
                   (
                        "Press 1 to search book by Author \n"+
                        "Press 2 to search book by Title \n"+
                        "Press 1 to search book by ISBN \n"
                   );
                   System.out.print("Please provide input:-> ");
                   int choice = input.nextInt();
                   input.nextLine();
                   
                   if(choice == 1)
                   {
                       System.out.print("Enter book author name:-> ");
                       String author = input.nextLine();
                       
                       //call method to search by author name
                       cd.search(choice, author);
                   }
                   else if(choice == 2)
                   {
                       System.out.print("Enter book title name:-> ");
                       String title = input.nextLine();
                       //call method to search by title name
                       cd.search(choice, title);
                   }
                   else if(choice == 3)
                   {
                       System.out.print("Enter book isbn:-> ");
                       String isbn = input.nextLine();
                       //call method to search by isbn 
                       cd.search(choice, isbn);
                   }
               }
               case 6:
               {
                   System.out.println("**** ADDING LIBRARY MEMBER ****");
                   System.out.print("Enter member name:-> ");
                   String name = input.nextLine();
                   System.out.print("Enter member surname:-> ");
                   String surname = input.nextLine();
                   System.out.print("Enter member email:-> ");
                   String email = input.nextLine();
                   System.out.print("Enter member phone number:-> ");
                   String phone_number = input.nextLine();
                   
                   MemberInfo member = new MemberInfo(name,surname,email,phone_number);
                   
                   boolean valid = cd.addMembers(member);
                   
                   if(valid == true)
                       System.out.println("**** Library member added successfully ****");
                   else
                       System.out.println("**** Library member not added successfully, problem occured ****");
               }
           }
       }
    }
    
}
