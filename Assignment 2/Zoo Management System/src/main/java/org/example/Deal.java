package org.example;
import java.util.*;
public class Deal extends Coupon{

    private int numTickets;

    public Deal(int numTickets, int percentage){
        super(percentage);
        this.numTickets = numTickets;


    }


    public int getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    public void description(){
        System.out.println("If a person buys "+getNumTickets() +" or more tickets to an attraction, they get a special discount of "+getPercentage()+" percent");
    }
}
