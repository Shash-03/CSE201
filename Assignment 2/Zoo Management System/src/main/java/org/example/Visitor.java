package org.example;
import java.util.*;
public class Visitor implements VisitorFunctions{
    private String name;
    private int age;

    private String phoneNumber;

    private int balance;

    private String email;

    private String password;

    private int membership;

    private HashMap <Integer, Integer> myTickets;

    public Visitor(String name, int age,String phoneNumber, int balance, String email, String password,int membership){
        this.name  = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.membership = membership;
        this.myTickets = new HashMap<>();

    }

    public HashMap<Integer, Integer> getMyTickets() {
        return myTickets;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMembership() {
        return membership;
    }

    public int getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setMyTickets(HashMap<Integer, Integer> myTickets) {
        this.myTickets = myTickets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMembership(int membership) {
        this.membership = membership;
    }

    public void leave_feedback(){  //User can leave feedback for the admin
        Scanner scanner = new Scanner(System.in);
        String visitorFeedback;

        System.out.println("Feel free to drop any feedback you may have for us:");
        System.out.println();
        visitorFeedback= scanner.nextLine();

        Zoo.getFeedback().add(visitorFeedback);


    }

    public void explore_attractions(){  //Explore what an attraction is about
        int number = 1;

        for (int id : Zoo.getAttractions().keySet()){
            System.out.println(number + "." + Zoo.getAttractions().get(id).getName());
            System.out.println("ID:"+id);
            System.out.println();
            number++;
        }

        System.out.println();

        Scanner scanner = new Scanner(System.in);

        int id;

        while(true){
            System.out.print("Enter the id of the attraction you want to visit:");
            if (scanner.hasNextInt()){
                id = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                break;

            }
            else{
                String temp = scanner.nextLine();
                System.out.println();
                System.out.println("Please enter valid input");
            }

        }

        if (Zoo.getAttractions().containsKey(id)){
            System.out.println(Zoo.getAttractions().get(id).getDescription());
            System.out.println();

        }
        else{
            System.out.println("Please enter valid input\n");
        }



    }

    public void explore_animals(){  //See an animal and listen to its sound
        int number = 1;

        for (int id : Zoo.getAnimals().keySet()){
            System.out.println(number + "." + Zoo.getAnimals().get(id).getName());
            System.out.println("ID:"+id);
            System.out.println();
            number++;
        }

        System.out.println();

        Scanner scanner = new Scanner(System.in);

        int id;

        while(true){
            System.out.print("Enter the id of the animal you want to visit:");
            if (scanner.hasNextInt()){
                id = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                break;

            }
            else{
                String temp = scanner.nextLine();
                System.out.println();
                System.out.println("Please enter valid input");
            }

        }

        if (Zoo.getAnimals().containsKey(id)){
            System.out.println(Zoo.getAnimals().get(id).getSound());
            System.out.println();

        }
        else{
            System.out.println("Please enter valid id\n");
        }




    }

    public void visit_animals(){   //Visit a particular animal and either feed it or read about it
        int number = 1;

        for (int id : Zoo.getAnimals().keySet()){
            System.out.println(number + "." + Zoo.getAnimals().get(id).getName());
            System.out.println("ID:"+id);
            System.out.println();
            number++;
        }

        System.out.println();

        Scanner scanner = new Scanner(System.in);

        int id;

        while(true){
            System.out.print("Enter the id of the animal you want to visit:");
            if (scanner.hasNextInt()){
                id = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                break;

            }
            else{
                String temp = scanner.nextLine();
                System.out.println();
                System.out.println("Please enter valid input");
            }

        }

        if (!Zoo.getAnimals().containsKey(id)){
            System.out.println("Invalid input\n");
            return;
        }

        while(true){
            System.out.println("1.Feed");
            System.out.println("2.Read");
            System.out.println("3.Leave\n");


            String animalChoice;
            System.out.print("Enter your choice:");
            animalChoice = scanner.nextLine().trim();
            System.out.println();

            if (animalChoice.equals("1")){
                System.out.println(Zoo.getAnimals().get(id).getSound());
                System.out.println();

            }
            else if (animalChoice.equals("2")){
                System.out.println(Zoo.getAnimals().get(id).getDescription());
                System.out.println();

            }
            else if (animalChoice.equals("3")){
                break;

            }
            else{
                System.out.println("Please enter valid input\n");
            }

        }

    }

    public void buy_premium_membership(int visitorIndex){ //buy premium membership
        int premiumMembershipPrice = 200;

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Enter discount code (Enter None if you don't have any):");
            String discountCode=  scanner.nextLine().trim();
            System.out.println();

            if (discountCode.equalsIgnoreCase("none")){
                System.out.println("No discount applied\n");
                break;
            }
            else{
                boolean flag = false;
                for (int id : Zoo.getDiscount_codes().keySet()){
                    if (Zoo.getDiscount_codes().get(id).equals(discountCode)){
                        boolean isMinorDiscountValid = Zoo.getDiscount_codes().get(id).substring(0,2).equalsIgnoreCase("mi") && Zoo.getVisitors().get(visitorIndex).getAge() < 18;
                        boolean isSeniorDiscountValid = Zoo.getDiscount_codes().get(id).substring(0,2).equalsIgnoreCase("se") && Zoo.getVisitors().get(visitorIndex).getAge() > 60;
                        boolean isOthers = !(Zoo.getDiscount_codes().get(id).substring(0,2).equalsIgnoreCase("mi") || Zoo.getDiscount_codes().get(id).substring(0,2).equalsIgnoreCase("se") ) ;
                        if (isOthers || isMinorDiscountValid || isSeniorDiscountValid){
                            flag = true;
                            premiumMembershipPrice = (100 - Zoo.getDiscounts().get(id).getPercentage())*premiumMembershipPrice/100;
                            System.out.println("Discount with category " + Zoo.getDiscounts().get(id).getCategory() + " successfully applied\n" );
                            break;

                        }
                        else{
                            System.out.println("You are not eligible for this discount\n");

                        }

                    }
                }
                if (!flag){
                    System.out.println("Please enter valid discount code\n");
                }
                else{
                    break;
                }
            }

        }





        if (Zoo.getVisitors().get(visitorIndex).getBalance() >= premiumMembershipPrice){
            int temp = Zoo.getVisitors().get(visitorIndex).getBalance() ;
            temp = temp - premiumMembershipPrice;
            Zoo.setMembershipRevenue(Zoo.getMembershipRevenue() + premiumMembershipPrice);
            Zoo.getVisitors().get(visitorIndex).setBalance(temp);
            Zoo.getVisitors().get(visitorIndex).setMembership(1);
            System.out.println("Premium membership purchased successfully");
            System.out.println("Current balance: Rs " + Zoo.getVisitors().get(visitorIndex).getBalance());

        }
        else{
            System.out.println("Balance insufficient for purchasing premium membership\n");
        }

    }

    public void buy_basic_membership(int visitorIndex){  //buy basic  membership
        int basicMembershipPrice = 20;

        Scanner scanner = new Scanner(System.in);

        while(true ){
            System.out.print("Enter discount code (Enter None if you don't have any):");
            String discountCode=  scanner.nextLine().trim();
            System.out.println();

            if (discountCode.equalsIgnoreCase("none")){
                System.out.println("No discount applied\n");
                break;
            }
            else{
                boolean flag = false;
                for (int id : Zoo.getDiscount_codes().keySet()){
                    if (Zoo.getDiscount_codes().get(id).equals(discountCode)){
                        boolean isMinorDiscountValid = Zoo.getDiscount_codes().get(id).substring(0,2).equalsIgnoreCase("mi") && Zoo.getVisitors().get(visitorIndex).getAge() < 18;
                        boolean isSeniorDiscountValid = Zoo.getDiscount_codes().get(id).substring(0,2).equalsIgnoreCase("se") && Zoo.getVisitors().get(visitorIndex).getAge() > 60;
                        boolean isOthers = !(Zoo.getDiscount_codes().get(id).substring(0,2).equalsIgnoreCase("mi") || Zoo.getDiscount_codes().get(id).substring(0,2).equalsIgnoreCase("se") ) ;
                        if (isMinorDiscountValid || isSeniorDiscountValid || isOthers){
                            flag = true;
                            basicMembershipPrice = (100 - Zoo.getDiscounts().get(id).getPercentage())*basicMembershipPrice/100;
                            System.out.println("Discount with category " + Zoo.getDiscounts().get(id).getCategory() + " successfully applied\n" );
                            break;
                        }
                        else{
                            System.out.println("You are not eligible for this discount\n");
                        }

                    }
                }
                if (!flag){
                    System.out.println("Please enter valid discount code\n");
                }
                else{
                    break;
                }
            }

        }



        if (Zoo.getVisitors().get(visitorIndex).getBalance() >= basicMembershipPrice){
            int temp = Zoo.getVisitors().get(visitorIndex).getBalance() ;
            temp = temp - basicMembershipPrice;
            Zoo.setMembershipRevenue(Zoo.getMembershipRevenue() + basicMembershipPrice);
            Zoo.getVisitors().get(visitorIndex).setBalance(temp);
            Zoo.getVisitors().get(visitorIndex).setMembership(0);
            System.out.println("Basic membership purchased successfully");
            System.out.println("Current balance: Rs " + Zoo.getVisitors().get(visitorIndex).getBalance());
            System.out.println();

        }
        else{
            System.out.println("Balance insufficient for purchasing basic membership\n");
        }

    }



    public void view_discounts(){   //View all the avaialble discounts
        System.out.println("Current Discounts:");
        System.out.println();

        for (int id: Zoo.getDiscounts().keySet()){
            System.out.println("ID:"+id);
            System.out.println("Discount category:" + Zoo.getDiscounts().get(id).getCategory());
            System.out.println("Discount percentage:" + Zoo.getDiscounts().get(id).getPercentage());
            System.out.println("Discount code:" + Zoo.getDiscount_codes().get(id));

            System.out.println();
        }

    }

    public void buy_tickets(int visitorIndex){  //buy ticket for attraction
        if (Zoo.getVisitors().get(visitorIndex).getMembership() == -1){
            System.out.println("You need to purchase a basic membership before buying tickets\n");
            return;
        }
        Scanner scanner = new Scanner (System.in);
        int number = 1;

        for (int id : Zoo.getAttractions().keySet()){
            System.out.println(number + "." + Zoo.getAttractions().get(id).getName());
            System.out.println("Ticket Price: Rs "+Zoo.getSchedules().get(id).getTicketPrice());
            System.out.println("ID:"+id);
            System.out.println();
            number++;
        }

        System.out.println();

        int attractionId;

        while(true) {
            System.out.print("Enter id of the attraction whose ticket you wish to buy (Enter -1 to exit):");
            if (scanner.hasNextInt()) {
                attractionId = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                break;

            } else {
                String temp = scanner.nextLine();
                System.out.println();
                System.out.println("Please enter valid input\n");
            }

        }

        if (attractionId == -1){
            return;
        }
        else if(Zoo.getAttractions().containsKey(attractionId)){
            int ticketPrice = Zoo.getSchedules().get(attractionId).getTicketPrice();

            while(true ){
                System.out.print("Enter discount code (Enter None if you don't have any):");
                String discountCode=  scanner.nextLine().trim();
                System.out.println();

                if (discountCode.equalsIgnoreCase("none")){
                    System.out.println("No discount applied\n");
                    break;
                }
                else{
                    boolean flag = false;
                    for (int id : Zoo.getDiscount_codes().keySet()){
                        if (Zoo.getDiscount_codes().get(id).equals(discountCode)){
                            boolean isMinorDiscountValid = Zoo.getDiscount_codes().get(id).substring(0,2).equalsIgnoreCase("mi") && Zoo.getVisitors().get(visitorIndex).getAge() < 18;
                            boolean isSeniorDiscountValid = Zoo.getDiscount_codes().get(id).substring(0,2).equalsIgnoreCase("se") && Zoo.getVisitors().get(visitorIndex).getAge() > 60;
                            boolean isOthers = !(Zoo.getDiscount_codes().get(id).substring(0,2).equalsIgnoreCase("mi") || Zoo.getDiscount_codes().get(id).substring(0,2).equalsIgnoreCase("se") ) ;
                            if (isMinorDiscountValid || isSeniorDiscountValid || isOthers){
                                flag = true;
                                ticketPrice = (100 - Zoo.getDiscounts().get(id).getPercentage())*ticketPrice/100;
                                System.out.println("Discount with category " + Zoo.getDiscounts().get(id).getCategory() + " successfully applied\n" );
                                break;
                            }
                            else{
                                System.out.println("You are not eligible for this discount\n");
                            }

                        }
                    }
                    if (!flag){
                        System.out.println("Please enter valid discount code\n");
                    }
                    else{
                        break;
                    }
                }

            }

            int numTickets;

            while(true) {
                System.out.print("Enter number of tickets you wish to buy:");
                if (scanner.hasNextInt()) {
                    numTickets = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();
                    break;

                } else {
                    String temp = scanner.nextLine();
                    System.out.println();
                    System.out.println("Please enter valid input\n");
                }

            }

            if (numTickets<0){
                System.out.println("Input invalid");
                return;
            }

            System.out.println("You are eligible for the following deals:");
            System.out.println();

            for (int id : Zoo.getDeals().keySet()){
                if (Zoo.getDeals().get(id).getNumTickets() <= numTickets){
                    System.out.println("ID:" + id);
                    Zoo.getDeals().get(id).description();
                    System.out.println();
                }

            }
            System.out.println();


            while(true){
                int dealId;
                while(true) {
                    System.out.print("Enter id of the deal you wish to apply (Enter -1 if there are none):");
                    if (scanner.hasNextInt()) {
                        dealId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println();
                        break;

                    } else {
                        String temp = scanner.nextLine();
                        System.out.println();
                        System.out.println("Please enter valid input\n");
                    }

                }

                if (dealId == - 1){
                    System.out.println("No deal applied\n");
                    break;
                }
                else if(Zoo.getDeals().containsKey(dealId)){
                    ticketPrice = (100 - Zoo.getDeals().get(dealId).getPercentage())*ticketPrice/100;
                    System.out.println("Deal applied\n");
                    break;
                }
                else{
                    System.out.println("Please enter a valid id\n");
                }

            }

            if (Zoo.getVisitors().get(visitorIndex).getMembership() == 1){
                ticketPrice = 0;
            }

            if (numTickets*ticketPrice <= Zoo.getVisitors().get(visitorIndex).getBalance()){
                int temp = Zoo.getVisitors().get(visitorIndex).getBalance() - numTickets*ticketPrice;
                Zoo.getVisitors().get(visitorIndex).setBalance(temp);
                if (Zoo.getVisitors().get(visitorIndex).getMyTickets().containsKey(attractionId)){
                    numTickets += Zoo.getVisitors().get(visitorIndex).getMyTickets().get(attractionId);
                }
                Zoo.getVisitors().get(visitorIndex).getMyTickets().put(attractionId,numTickets);
                Zoo.getSchedules().get(attractionId).setNumTickets(numTickets + Zoo.getSchedules().get(attractionId).getNumTickets() );
                Zoo.getSchedules().get(attractionId).setRevenue(numTickets*ticketPrice + Zoo.getSchedules().get(attractionId).getRevenue());
                System.out.println("Tickets purchased successfully");
                System.out.print("Available Balance: Rs " + Zoo.getVisitors().get(visitorIndex).getBalance() );
                System.out.println();
                System.out.println();
            }
            else{
                System.out.println("Insufficient balance\n");
            }




        }
        else{
            System.out.println("Please enter a valid input\n");
        }



    }

    public void visit_attraction(int visitorIndex){ //visit a particular attraction
        Scanner scanner = new Scanner (System.in);
        int number = 1;

        for (int id : Zoo.getAttractions().keySet()){
            System.out.println(number + "." + Zoo.getAttractions().get(id).getName());
            System.out.println("Ticket Price: Rs "+Zoo.getSchedules().get(id).getTicketPrice());
            System.out.println("ID:"+id);
            System.out.println();
            number++;
        }

        System.out.println();

        int attractionId;

        while(true) {
            System.out.print("Enter id of the attraction you wish to visit:");
            if (scanner.hasNextInt()) {
                attractionId = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                break;

            } else {
                String temp = scanner.nextLine();
                System.out.println();
                System.out.println("Please enter valid input\n");
            }
        }

        if (!Zoo.getSchedules().containsKey(attractionId)){
            System.out.println("Invalid id\n");
            return;
        }

        if (!Zoo.getSchedules().get(attractionId).getOpen()){
            System.out.println("Sorry attraction is closed right now :( \n");
        }
        else{
            int numPeople;

            while(true) {
                System.out.print("Enter the no of people with you who are visiting the attraction:");
                if (scanner.hasNextInt()) {
                    numPeople = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();
                    break;

                } else {
                    String temp = scanner.nextLine();
                    System.out.println();
                    System.out.println("Please enter valid input\n");
                }

            }

            if (Zoo.getVisitors().get(visitorIndex).getMyTickets().containsKey(attractionId)){
                if (numPeople > Zoo.getVisitors().get(visitorIndex).getMyTickets().get(attractionId)){
                    System.out.println("Insufficient number of tickets \n");
                }
                else if (numPeople <= 0 ){
                    System.out.println("Invalid number of people\n");

                }
                else{
                    Zoo.getSchedules().get(attractionId).setNoOfVisitors(numPeople + Zoo.getSchedules().get(attractionId).getNoOfVisitors());
                    int leftTickets = Zoo.getVisitors().get(visitorIndex).getMyTickets().get(attractionId) - numPeople;
                    Zoo.getVisitors().get(visitorIndex).getMyTickets().put(attractionId,leftTickets);
                    System.out.println("Welcome to " + Zoo.getAttractions().get(attractionId).getName());

                }

            }
            else{
                System.out.println("Insufficient number of tickets\n");
            }

        }


    }
}
