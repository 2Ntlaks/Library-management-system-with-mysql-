# LibraryManagementSystem

LibraryManagementSystem is a Java-based application designed to manage a library's collection of books and its members. The system uses a MySQL database to perform CRUD (Create, Read, Update, Delete) operations on book and member records.

## Features

- **Add Book**: Add new books to the library's collection.
- **Display Books**: View all books currently available in the library.
- **Update Book**: Update the title or author of a book in the collection.
- **Delete Book**: Remove a book from the library's collection.
- **Search Book**: Search for books by author, title, or ISBN.
- **Add Member**: Register new members to the library.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed on your machine.
- MySQL installed and running.
- Git installed on your machine.
- A MySQL database with the following structure:

  ```sql
  CREATE TABLE books (
      author VARCHAR(50),
      title VARCHAR(50),
      isbn VARCHAR(20) PRIMARY KEY,
      quantity INT
  );

  CREATE TABLE members (
      name VARCHAR(50),
      surname VARCHAR(50),
      member_id INT AUTO_INCREMENT PRIMARY KEY,
      email VARCHAR(100),
      phone_number VARCHAR(15)
  );
  ```
