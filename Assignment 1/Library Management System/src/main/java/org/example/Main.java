package org.example;
import java.util.*;


public class Main {
    public static void line(){
        StringBuilder blanks = new StringBuilder();
        for (int  i = 0; i < 20;i++){
            blanks.append('-');
        }

        System.out.println(blanks);
    }

    public static void starter_menu(){
        System.out.println("1.      Enter as a librarian");
        System.out.println("2.      Enter as a member");
        System.out.println("3.      Exit" );
    }

    public static void librarian_menu(){
        System.out.println("1.      Register a member");
        System.out.println("2.      Remove a member");
        System.out.println("3.      Add a book" );
        System.out.println("4.      Remove a book");
        System.out.println("5.      View all members along with their book and fines to be paid");
        System.out.println("6.      View all books" );
        System.out.println("7.      Back");
    }

    public static void student_menu(){
        System.out.println("1.      List Available Books");
        System.out.println("2.      List My Books");
        System.out.println("3.      Issue book" );
        System.out.println("4.      Return book");
        System.out.println("5.      Pay fine");
        System.out.println("6.      Back" );
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StudentData studentInfo = new StudentData();
        BookData bookInfo = new BookData();

        line();

        while(true){
            starter_menu();
            line();
            int starter_choice = scanner.nextInt();
            scanner.nextLine();
            line();

            if (starter_choice == 1){
                Librarian librarian = new Librarian(bookInfo,studentInfo);
                System.out.print("Please enter password:");
                String pass = scanner.next();
                line();
                if (pass.equals(librarian.getPassword())){
                    while(true){
                        librarian_menu();
                        line();
                        int librarian_choice = scanner.nextInt();
                        scanner.nextLine();
                        line();
                        if (librarian_choice == 1){
                            System.out.print("Name:");
                            String studentName = scanner.nextLine();
                            System.out.print("Age:");
                            int age = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Phone number:");
                            String phoneNumber = scanner.nextLine();
                            boolean flag = false;
                            for (int studentId: studentInfo.getAvailableStudentID()){
                                if (studentName.equalsIgnoreCase(studentInfo.getStudentData().get("Member ID-"+studentId).get(0))
                                        && phoneNumber.equalsIgnoreCase(studentInfo.getStudentData().get("Member ID-"+studentId).get(2))){
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag){
                                System.out.println("Member with the following credentials already exists");
                            }
                            else {
                                librarian.addMember(studentName, age, phoneNumber);
                            }
                            line();
                        }
                        else if (librarian_choice == 2){
                            System.out.print("Please enter the ID of the member you want to remove(We just the number X where ID-X is the id of the member to be removed):");
                            int memberId = scanner.nextInt();
                            scanner.nextLine();
                            if (studentInfo.isIdUsed(memberId)){
                                librarian.removeMember(memberId);
                                System.out.println("Member with the given ID was successfully removed");

                            }
                            else{
                                System.out.println("Please enter valid member ID");
                            }

                            line();


                        }
                        else if(librarian_choice == 3){
                            System.out.print("Book title:");
                            String bookTitle = scanner.nextLine();
                            System.out.print("Author:");
                            String author = scanner.nextLine();
                            System.out.print("Number of copies:");
                            int noCopies = scanner.nextInt();
                            scanner.nextLine();
                            //Add function to check noCopies are positive
                            librarian.addBook(bookTitle,author, noCopies);
                            System.out.println("Book was successfully added ");
                            line();

                        }
                        else if (librarian_choice == 4){
                            System.out.print("Please enter the ID of the book you want to remove(We just the number X where ID-X is the id of the book to be removed):");
                            int bookId = scanner.nextInt();
                            scanner.nextLine();
                            if (bookInfo.isBookPresent("ID-"+bookId)){
                                librarian.removeBook(bookId);
                                System.out.println("Book with the given ID was successfully removed");
                            }
                            else{
                                System.out.println("Please enter a valid book id");
                            }
                            line();


                        }
                        else if (librarian_choice == 5){
                            librarian.displayMembers();

                        }
                        else if(librarian_choice == 6){
                            librarian.displayAllBooks();

                        }
                        else if(librarian_choice == 7){
                            break;
                        }

                        else{
                            System.out.println("Please enter a valid option");
                            line();
                        }

                    }

                }
                else{
                    System.out.println("You don't have the authorization to access this menu");
                    line();
                }


            }
            else if (starter_choice == 2){
                String studentName;
                String studentPhoneNo;
                System.out.print("Name:");
                studentName = scanner.nextLine();
                System.out.print("Phone No:");
                studentPhoneNo = scanner.nextLine();
                String memberID = "";
                line();
                boolean flag = false;
                for (int studentId: studentInfo.getAvailableStudentID()){
                    if (studentName.equalsIgnoreCase(studentInfo.getStudentData().get("Member ID-"+studentId).get(0))
                    && studentPhoneNo.equalsIgnoreCase(studentInfo.getStudentData().get("Member ID-"+studentId).get(2))){
                        flag = true;
                        memberID += "Member ID-"+studentId;
                        break;
                    }
                }
                if (flag ){
                    Student student = new Student(memberID,bookInfo,studentInfo);
                    System.out.println("Welcome "+studentName);
                    System.out.println(memberID);
                    line();
                    while(true) {
                        student_menu();
                        line();
                        int student_choice = scanner.nextInt();
                        scanner.nextLine();
                        line();
                        if (student_choice == 1){
                            student.displayBooks();



                        }
                        else if(student_choice == 2){
                            student.myBooks();
                            line();

                        }
                        else if(student_choice == 3){
                            System.out.print("Enter the ID of the book you want to issue(We just the number X where ID-X is the id of the book to be issued):");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            String bookID = "ID-" + id;
                            if (!bookInfo.isIdUsed(id)){
                                System.out.println("Please enter a valid id");
                            }
                            else {
                                student.issueBooks(bookID);
                            }
                            line();

                        }
                        else if(student_choice == 4){
                            System.out.print("Please enter the ID of the book you are returning(We just the number X where ID-X is the id of the book to be returned):");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            String bookID = "ID-" + id;
                            if (!bookInfo.isIdUsed(id)){
                                System.out.println("Please enter a valid id");
                            }
                            else {
                                student.returnBook(bookID);
                            }
                            line();

                        }
                        else if (student_choice == 5){
                            student.payFine();
                            line();

                        }
                        else if (student_choice == 6){
                            break;
                        }
                        else{
                            System.out.println("Please enter a valid option");
                            line();
                        }
                    }
                }
                else{
                    System.out.println("User with the given name and number doesn't exist");
                    line();
                }

            }
            else if (starter_choice == 3){
                System.out.println("Thanks for visiting");
                line();
                break;
            }
            else{
                System.out.println("Please enter a valid option");
            }
        }

    }
}
