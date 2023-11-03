package org.example;

public interface VisitorFunctions {
    public void leave_feedback();

    public void explore_attractions();

    public void explore_animals();

    public void visit_animals();

    public void buy_premium_membership(int visitorIndex);

    public void buy_basic_membership(int visitorIndex);

    public void view_discounts();

    public void buy_tickets(int visitorIndex);

    public void visit_attraction(int visitorIndex);
}
