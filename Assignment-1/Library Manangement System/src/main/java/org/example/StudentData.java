package org.example;
import java.util.*;
import java.time.*;


public class StudentData {
    private HashSet<Integer> availableStudentID ;

    private HashMap<String, ArrayList<String>> studentData;

    private HashMap<String , ArrayList<HashMap<String,Instant>>> issuedBooks;

    private HashMap<String, Integer> Fines;



    public StudentData(){
        this.availableStudentID = new HashSet<>();
        this.studentData = new HashMap <>();
        this.issuedBooks = new HashMap<>();
        this.Fines = new HashMap<>();
    }

    public HashMap<String, Integer> getFines() {
        return Fines;
    }

    public HashMap<String, ArrayList<HashMap<String,Instant>>> getIssuedBooks() {
        return issuedBooks;
    }

    public HashSet <Integer> getAvailableStudentID() {
        return availableStudentID;
    }

    public HashMap<String,ArrayList<String>> getStudentData(){
        return studentData;
    }
    public void setIssuedBooks(HashMap<String, ArrayList<HashMap<String,Instant>>> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }

    public void setFines(HashMap<String, Integer> fines) {
        Fines = fines;
    }
    public void setAvailableStudentID(HashSet <Integer> newAvailableStudentID){
        this.availableStudentID = newAvailableStudentID;
    }

    public void setStudentData(HashMap<String,ArrayList<String>> newStudentData){
        this.studentData = newStudentData;
    }


    public void addStudentID(int studentID){
        this.availableStudentID.add(studentID);
    }

    public void removeStudentID(int studentID){
        this.availableStudentID.remove(studentID);
    }

    public boolean isIdUsed(int ID){
        return this.availableStudentID.contains(ID);
    }

    public void addStudentData(String studentID, ArrayList<String> studentInfo){
        this.studentData.put(studentID,studentInfo);
    }

    public void removeStudent(String studentID){
        this.studentData.remove(studentID);
    }

    public void addFines(String memberID, int fine){
        this.getFines().put(memberID,fine);
    }

    public void removeFines(String memberID){
        this.getFines().remove(memberID);
    }
    public boolean hasFines(String memberID){
        return this.getFines().containsKey(memberID);
    }

    public void issueBook(String memberID,String bookID){
        if (this.getIssuedBooks().containsKey(memberID)){
            if (this.getIssuedBooks().get(memberID).size() == 2){
                System.out.println("You can't issue more than 2 books");
            }
            else if (hasFines(memberID)){
                System.out.println("You can't issue another book until you pay the pending fines");
            }
            else{
                ArrayList<HashMap<String,Instant>> temp = this.getIssuedBooks().get(memberID);
                HashMap <String,Instant> id_and_time= new HashMap<>();
                id_and_time.put(bookID,Instant.now());
                temp.add(id_and_time);
                this.getIssuedBooks().put(memberID,temp);
                System.out.println("Book was issued successfully");
            }
        }
        else if (hasFines(memberID)){
            System.out.println("You can't issue another book until you pay the pending fines");
        }

        else{
            ArrayList <HashMap<String,Instant> > temp = new ArrayList<>();
            HashMap<String,Instant> id_and_time = new HashMap<>();
            id_and_time.put(bookID,Instant.now());
            temp.add(id_and_time);
            this.getIssuedBooks().put(memberID, temp);
            System.out.println("Book was issued successfully");
        }
    }


    public void returnBook(String memberID,String bookID, int fine){
        for (int i = 0; i <this.getIssuedBooks().get(memberID).size();i++ ){
            if (this.getIssuedBooks().get(memberID).get(i).containsKey(bookID)){
                this.getIssuedBooks().get(memberID).remove(i);
                break;
            }
        }
        if (this.getIssuedBooks().get(memberID).isEmpty()){
            this.getIssuedBooks().remove(memberID);
        }
        if (fine != 0) {
            if (this.getFines().containsKey(memberID)){
                fine += this.getFines().get(memberID);
            }
            this.addFines(memberID, fine);
            System.out.printf("You need to pay a fine of Rs %d\n", fine);
        }

    }

    public boolean hasBook(String memberID){

        return this.getIssuedBooks().containsKey(memberID);
    }

    public boolean isBookIssued(String bookID){
        boolean flag = false;
        for (String studentID : getIssuedBooks().keySet()){
            for (HashMap<String,Instant> book: getIssuedBooks().get(studentID)){
                for (String book_id:book.keySet()){
                    if (bookID.equals(book_id)){
                        flag = true;
                        break;
                    }
                }
            }
        }

        return flag;
    }


}
