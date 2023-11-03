package org.example;
import java.util.*;
public class BookData {
    private HashMap <String, ArrayList<String>> bookData;
    private HashSet <Integer> availableBookID;

    public BookData(){
        this.bookData = new HashMap<>();
        this.availableBookID = new HashSet<>();
    }


    public HashSet <Integer> getAvailableBookID(){
        return availableBookID;
    }

    public HashMap<String, ArrayList<String>> getBookData(){
        return bookData;
    }

    public void setBookData(HashMap <String, ArrayList<String>> newBookData){
        this.bookData= newBookData;

    }
    public void setAvailableBookID(HashSet <Integer> newAvailableBookID){
        this.availableBookID = newAvailableBookID;
    }


    public void addBookID(int bookID){
        this.availableBookID.add(bookID);
    }

    public void removeBookID(int bookID){
        this.availableBookID.remove(bookID);
    }

    public boolean isIdUsed(int ID){
        return this.availableBookID.contains(ID);
    }



    public void addBook(String bookID,ArrayList<String> info){
        this.bookData.put(bookID,info);
    }

    public void removeBook(String bookID){
        this.bookData.remove(bookID);
    }

    public boolean isBookPresent(String bookID){
        return this.bookData.containsKey(bookID);
    }

}
