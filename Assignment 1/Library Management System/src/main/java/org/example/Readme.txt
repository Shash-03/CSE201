How to run the file in the terminal:

1. Run the command in terminal:
mvn clean install

2. The previous command should create a target folder
Inside the target folder, you will find a .jar file
In my computer, the file is named : library-1.0-SNAPSHOT.jar
Copy the name of the file

3.In the terminal, run the command:
cd target

4.In the terminal, run the command:
java -cp .\name_of_the_.jarfile name_of_the_main_class

In my computer, the command was:
java -cp .\library-1.0-SNAPSHOT.jar org.example.Main

5.Hopefully, you should be greeted with the menu of the library management system


How to Navigate through the program:

The program has a menu based interface. Just enter the integer X (where X represents
the number associated with the operation) to perform the operation of your choice.
To access the features of the librarian, you need to enter a password to make the overall
system more secure.

Password: 1234567890

When you want to terminate the application. Just enter the number 3 in
the main menu(associated with the exit option) to exit the application


Code Structure:

Apart from the Main class, the code has employed four different class:

1. Librarian :
The Librarian class consists of the functions that perform all the operations that a librarian
may need to perform.

The Librarian class takes in 2 parameters as input while creating an instance of the class.
These include an object of type BookData and an object of type StudentData. These objects allow us to
call various helper functions that improve the readability of our code.

The librarian class consists of 3 private variables with getter and setter methods for the same.

a)addBook()
This method adds a book to the collection of all the books in the library.
Takes in title of the book, name of the author and no of copies as input.

b)removeBook()
This method removes a book from the collection of all the books in the library.
Takes the book-ID as the input.
Prints an error message if the bookID is invalid.

c)displayAllBooks()
This method displays all the book present in the library.

d)addMember()
This method adds a new member to the collection of all the members of the library.
Takes in the name,age and phone no of the member as input.

e)removeMember()
This method removes a member from the collection of all the members of the library.
Takes in the id of the member to be removed.
Prints an error if the member to be removed has some book issued or has a fine pending.
Prints an error message if the memberID is invalid

f)displayMember()
This method displays all the members of the library along with the books issued by them as well
as any fines they still need to pay.


2. Student:
The Student class consists of the functions that perform all the operation that a student
may need to perform.

The Student class takes in 3 parameters as input while creating an instance of the class.
These include an object of type BookData, an object of type StudentData as well as a String
representing the member-ID.

The Student class consists of 3 private variables with getter and setter methods for the same.

a)displayBooks()
This method displays all the books that are currently available in the library and can be issued by
the member. These don't include the books which have issued by other members.

b)myBooks()
This method displays all the books that are currently issued by the member.

c)issueBooks()
This method takes in the id of the book as input and issues the book to the member.
Prints an error message if the book ID is invalid.
Prints an error message if the member has any fine pending or has already issued 2 books.
Prints an error message if it has been more than 10 seconds since the member has issued the first book.

d)payFine()
Pays any pending fine of the users.

e)returnBook()
This methods takes in the id of the book as input and take the book from the member and returns it
to the collection of books in the library. It also prints any fine the user may have incurred due to
returning the book after the due date.
Prints an error message if the book ID is invalid.


3. BookData:
The bookData class consists of helper functions regarding operations related to books
that help  make the code in the Librarian and Student class more readable and organised.

It has 2 private variables with getter and setter methods for the same.

a) addBookID()
Adds the book ID to the list of book IDs currently in use.

b)removeBookID()
Removes bookID from the list of book IDs currently in use.

c)isIDUsed()
Returns a boolean value telling whether the id passed as input is currently in use or free.

d)addBook()
Adds the book with the given parameters to the collection of books in the library.

e)removeBook()
Removes the book with the given book ID from the collection of books in the library.

f)isBookPresent()
Returns a boolean value telling whether book with the given ID is part of the collection
of books in the library or not.


4.StudentData:
The StudentData class consists of helper functions regarding operations related to students
that help make the code in the Librarian and Student class more readable and organised.

It has 4 private variables with getter and setter methods for the same

a)addStudentID()
Adds the member ID to the list of the member IDs currently in use.

b)removeStudentID()
Removes the member ID from the list of member IDs currently in use.

c)isIDUsed()
Returns a boolean value telling whether the id passed as input is currently in use or free.

d)addStudentData()
Adds the member with the given parameters to the list of all the members of the library

e)removeStudent()
Removes the member with the given member ID from the list of members of the library

f)addFines()
Add a fine passed as a parameter associated with the member ID passed as a parameter

g)removeFines()
Removes fine associated with the member ID passed as the parameter

h)hasFines()
Returns a boolean value telling if the member ID passed as a parameter has a fine associate with it
or not

i)issueBook()
Issues a book with the book ID passed as the parameter to the member ID passed as the parameter

j)returnBook()
Takes the book with book ID passed as the parameter from the member with member ID passed
as the parameter

i)hasBook()
Returns a boolean value telling if the member with the member ID passed as the parameter has issued a book or
not

j)isBookIssued()
Returns a boolean value telling if the book with the book ID passed as the parameter has been issued by
someone or not








