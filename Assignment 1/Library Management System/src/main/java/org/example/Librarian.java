package org.example;
import java.util.*;
import java.time.*;
public class Librarian {
    private BookData bookInfo;
    private StudentData studentInfo;

    private String password = "1234567890";

    public Librarian(BookData bookInfo,StudentData studentInfo){
        this.bookInfo = bookInfo;
        this.studentInfo = studentInfo;

    }

    public BookData getBookInfo(){
        return bookInfo;
    }

    public void setBookInfo(BookData newBookInfo){
        this.bookInfo = newBookInfo;
    }

    public StudentData getStudentInfo(){
        return studentInfo;
    }

    public void setStudentInfo(StudentData newStudentInfo){
        this.studentInfo = newStudentInfo;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    public void addBook(String name, String author, int numCopies){
        int counter = 0;
        while (counter < numCopies){
            int i = 1;
            ArrayList <String> information_of_books = new ArrayList<>();
            information_of_books.add(name);
            information_of_books.add(author);
            while (true){
                if(bookInfo.isIdUsed(i)){
                    i++;
                }
                else{
                    bookInfo.addBookID(i);
                    String bookID = "ID-" + i;
                    bookInfo.addBook(bookID,information_of_books);

                    break;
                }
            }
            counter++;
        }

    }

    public void removeBook(int ID){
        String bookID = "ID-"+ID;
        bookInfo.removeBookID(ID);
        bookInfo.removeBook(bookID);

    }

    public void displayAllBooks(){
        System.out.println("We have the following books:");
        Main.line();
        int id = 1;
        int counter = 0;
        while (counter < bookInfo.getAvailableBookID().size()){
            if (bookInfo.isIdUsed(id)) {
                String bookID = "ID-" + id;
                System.out.println(bookID);
                ArrayList<String>placeholder = bookInfo.getBookData().get(bookID);
                System.out.println("Title:" + placeholder.get(0));
                System.out.println("Author:" + placeholder.get(1));
                Main.line();
                counter++;
            }
            id++;

        }
    }

    public void addMember(String name, int age, String phoneNumber){
        int i = 1;
        ArrayList <String> information_of_student = new ArrayList<>();
        information_of_student.add(name);
        information_of_student.add(Integer.toString(age));
        information_of_student.add(phoneNumber);
        while (true){
            if(studentInfo.isIdUsed(i)){
                i++;
            }
            else{
                studentInfo.addStudentID(i);
                String studentID = "Member ID-" + i;
                studentInfo.addStudentData(studentID,information_of_student);
                System.out.println("Member was successfully added");
                System.out.println(studentID);
                break;
            }
        }

    }

    public void removeMember(int ID){
        String memberID = "Member ID-"+ID;
        if (studentInfo.hasFines(memberID)){
            System.out.println("The member still has fines pending");
        }
        else if (studentInfo.hasBook(memberID)){
            System.out.println("Member still has book issued");
        }
        else {
            studentInfo.removeStudentID(ID);
            studentInfo.removeStudent(memberID);
        }


    }

    public void displayMembers(){
        for (int id: studentInfo.getAvailableStudentID()){
            String memberID = "Member ID-"+id;
            System.out.println("Name:"+studentInfo.getStudentData().get(memberID).get(0));
            System.out.println("Books Issued:");
            if(!studentInfo.hasBook(memberID)){
                System.out.println("None");
            }
            else{
                int book_no = 1;
                for (HashMap<String,Instant> book : studentInfo.getIssuedBooks().get(memberID)){
                    for (String book_id:book.keySet()) {
                        System.out.println("Book No." + book_no + ": " + bookInfo.getBookData().get(book_id).get(0) + " (Book "+book_id+")");
                        book_no++;
                    }
                }

            }
            System.out.println("Fines:");
            if (studentInfo.hasFines(memberID)){
                System.out.println("Rs."+studentInfo.getFines().get(memberID));

            }
            else{
                System.out.println("None");
            }

            Main.line();
        }
    }

}
