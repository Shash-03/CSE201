package org.example;
import java.util.*;

public class Schedule {
    private boolean open;

    private String timing;

    private int noOfVisitors;

    private int ticketPrice;

    private int numTickets;

    private int revenue;

    public Schedule(boolean open, String timing, int noOfVisitors, int ticketPrice, int numTickets, int revenue){
        this.open = open;
        this.timing = timing;
        this.noOfVisitors = noOfVisitors;
        this.ticketPrice = ticketPrice;
        this.numTickets = numTickets;
        this.revenue = revenue;
    }

    public boolean getOpen(){
        return open;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public int getNoOfVisitors() {
        return noOfVisitors;
    }

    public String getTiming() {
        return timing;
    }

    public int getRevenue() {
        return revenue;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setNoOfVisitors(int noOfVisitors) {
        this.noOfVisitors = noOfVisitors;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }
}
