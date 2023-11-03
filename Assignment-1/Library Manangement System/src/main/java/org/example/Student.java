package org.example;
import java.util.*;
import java.time.*;

public class Student {

    private String studentID;
    private BookData bookInfo;
    private StudentData studentInfo;

    public Student(String studentID,BookData bookInfo, StudentData studentInfo){
        this.studentID = studentID;
        this.bookInfo = bookInfo;
        this.studentInfo = studentInfo;
    }

    public String getStudentID(){
        return studentID;
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

    public void setStudentID(String newStudentID){
        this.studentID = newStudentID;
    }

    public void displayBooks(){
        System.out.println("We have the following books:");
        Main.line();
        int id = 1;
        int counter = 0;
        while (counter < bookInfo.getAvailableBookID().size()){
            if (bookInfo.isIdUsed(id) && !studentInfo.isBookIssued("ID-"+id)) {
                String bookID = "ID-" + id;
                System.out.println(bookID);
                ArrayList<String>placeholder = bookInfo.getBookData().get(bookID);
                System.out.println("Title:" + placeholder.get(0));
                System.out.println("Author:" + placeholder.get(1));
                Main.line();
                counter++;
            }
            else if(bookInfo.isIdUsed(id)){
                counter++;
            }
            id++;

        }

    }

    public void myBooks(){
        if (!studentInfo.hasBook(getStudentID())){
            System.out.println("You don't have any books as of now");
        }

        else{
            int book_no = 1;
            for (HashMap<String, Instant> book : studentInfo.getIssuedBooks().get(studentID)){
                for (String book_id: book.keySet()) {
                    System.out.println("Book No." + book_no + ": " + bookInfo.getBookData().get(book_id).get(0) + " (Book "+book_id+")");
                    book_no++;
                }
            }
        }
    }

    public void issueBooks(String bookID){
        Instant initial = Instant.now();
        if(studentInfo.getIssuedBooks().containsKey(studentID)) {
            if (!studentInfo.getIssuedBooks().get(studentID).isEmpty()) {
                if (studentInfo.getIssuedBooks().get(studentID).size() == 1) {
                    for (int i = 0; i < studentInfo.getIssuedBooks().get(studentID).size(); i++) {
                        for (String book_id : studentInfo.getIssuedBooks().get(studentID).get(0).keySet()) {
                            initial = studentInfo.getIssuedBooks().get(studentID).get(0).get(book_id);
                        }
                    }
                }
            }
        }
        Duration duration = Duration.between(initial,Instant.now());
        long seconds = duration.getSeconds();

        if(studentInfo.isBookIssued(bookID)){
            System.out.println("Book has already been issued");
        }
        else if(seconds > 10){
            System.out.println("You have a fine pending on the book you had issued. Return the book and settle the fine before trying to issue another book.");
        }
        else {
            studentInfo.issueBook(getStudentID(), bookID);
        }
    }

    public void payFine(){
        studentInfo.removeFines(getStudentID());
        System.out.println("Your fine was paid successfully");
    }

    public void returnBook(String bookID){
        Instant initial = Instant.now();
        for (int i = 0; i <studentInfo.getIssuedBooks().get(studentID).size();i++ ){
            if (studentInfo.getIssuedBooks().get(studentID).get(i).containsKey(bookID)){
                initial = studentInfo.getIssuedBooks().get(studentID).get(i).get(bookID);
                break;
            }
        }
        Duration duration = Duration.between(initial,Instant.now());
        long seconds = duration.getSeconds();
        int fine = 0;

        if (seconds >10){
            fine+= (int) ((seconds-10)*3);
        }

        studentInfo.returnBook(getStudentID(),bookID,fine);

    }

}
