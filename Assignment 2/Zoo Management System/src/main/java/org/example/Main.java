package org.example;
import java.util.*;

//You can navigate through the various menus using number inputs indicated at the start of every option
//Main class only contains the menus. The working is in the other classes (mainly admin and visitor)
//The Zoo class is a special class consisting of static arrays and hashmaps which stores all sorts of information
//regarding various objects like attractions or visitors
// Please read the assumption section of the read me before running the code

public class Main{

    public static void main_menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Zootopia!\n");

        System.out.println("1.Enter as Admin");
        System.out.println("2.Enter as Visitor");
        System.out.println("3.View Special Deals");
        System.out.println("4.Exit\n");

        System.out.print("Enter your choice:");

    }

    public static void admin_menu(){
        System.out.println("1.Manage Attractions");
        System.out.println("2.Manage Animals");
        System.out.println("3.Schedule Events");
        System.out.println("4.Set Discounts");
        System.out.println("5.Set Special Deal");
        System.out.println("6.View Visitor Stats");
        System.out.println("7.View Feedback");
        System.out.println("8.Exit\n");
    }

    public static void visitor_menu(){
        System.out.println("1.Explore the Zoo");
        System.out.println("2.Buy Membership");
        System.out.println("3.Buy Tickets");
        System.out.println("4.View Discounts");
        System.out.println("5.View Special Deals");
        System.out.println("6.View Animals");
        System.out.println("7.Visit Attractions");
        System.out.println("8.Leave Feedback");
        System.out.println("9.Logout\n");

    }

    public static void login_page(){
        System.out.println("1.Register");
        System.out.println("2.Login");
        System.out.println("3.Exit\n");
    }

    public static void admin_attractions(){
        System.out.println("1.Add Attractions");
        System.out.println("2.View Attractions");
        System.out.println("3.Modify Attractions");
        System.out.println("4.Remove Attractions");
        System.out.println("5.Exit\n");
    }

    public static void admin_animals(){
        System.out.println("1.Add Animal");
        System.out.println("2.Update Animal Details");
        System.out.println("3.Remove  Animal");
        System.out.println("4.Exit\n");

    }

    public static void visitor_explore(){
        System.out.println("Explore the Zoo:");
        System.out.println();
        System.out.println("1.View Attractions");
        System.out.println("2.View Animals");
        System.out.println("3.Exit\n");
    }

    public static void admin_discount(){
        System.out.println("1.Add discount");
        System.out.println("2.Modify discount");
        System.out.println("3.Remove discount");
        System.out.println("4.Exit\n");
    }

    public static void admin_deals(){
        System.out.println("1.Add Deal");
        System.out.println("2.Remove Deal");
        System.out.println("3.Exit\n");
    }





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        while(true){
            main_menu();
            String choice = scanner.nextLine().trim();
            System.out.println();
            Admin admin = new Admin();

            if (choice.equals("1")){
                System.out.print("Enter admin username:");
                String adminName = scanner.nextLine().trim();
                System.out.print("Enter password:");
                String adminPassword = scanner.nextLine().trim();
                System.out.println();

                final String finalAdminName  = "admin";
                final String finalAdminPassword = "admin123";

                if (adminName.equals(finalAdminName) && adminPassword.equals(finalAdminPassword)){
                    System.out.println("Logged in successfully\n");

                    while(true){
                        admin_menu();

                        System.out.print("Enter your choice:");
                        String adminChoice = scanner.nextLine().trim();
                        System.out.println();

                        if(adminChoice.equals("1")){
                            while(true){
                                admin_attractions();
                                System.out.print("Enter your choice:");
                                String attractionChoice = scanner.nextLine().trim();
                                System.out.println();

                                if (attractionChoice.equals("1")){
                                    admin.add_attractions();


                                }
                                else if(attractionChoice.equals("2")){
                                    admin.view_attractions();

                                }
                                else if(attractionChoice.equals("3")){
                                    admin.modify_attraction();

                                }
                                else if(attractionChoice.equals("4")){
                                    admin.remove_attractions();

                                }
                                else if (attractionChoice.equals("5")){
                                    break;

                                }
                                else{
                                    System.out.println("Please enter a valid input\n");
                                }

                            }

                        }
                        else if(adminChoice.equals("2")){
                            while(true){
                                admin_animals();
                                System.out.print("Enter your choice:");
                                String animalChoice = scanner.nextLine().trim();
                                System.out.println();

                                if (animalChoice.equals("1")){
                                    admin.add_animal();

                                }
                                else if(animalChoice.equals("2")){
                                    admin.modify_animals();

                                }
                                else if(animalChoice.equals("3")){
                                    admin.remove_animal();

                                }
                                else if(animalChoice.equals("4")){
                                    break;

                                }
                                else{
                                    System.out.println("Please enter a valid input\n");
                                }


                            }


                        }
                        else if(adminChoice.equals("3")){
                            admin.schedule_event();

                        }
                        else if(adminChoice.equals("4")){
                            while(true){
                                admin_discount();
                                System.out.print("Enter your choice:");
                                String discountChoice = scanner.nextLine().trim();
                                System.out.println();

                                if (discountChoice.equals("1")){
                                    admin.add_discount();

                                }
                                else if(discountChoice.equals("2")){
                                    admin.modify_discount();

                                }

                                else if(discountChoice.equals("3")){
                                    admin.remove_discount();

                                }
                                else if(discountChoice.equals("4")){
                                    break;
                                }
                                else{
                                    System.out.println("Please enter valid input\n");
                                }




                            }

                        }
                        else if(adminChoice.equals("5")){
                            while(true){
                                admin_deals();
                                System.out.print("Enter your choice:");
                                String dealChoice = scanner.nextLine().trim();
                                System.out.println();

                                if (dealChoice.equals("1")){
                                    admin.add_deal();

                                }
                                else if(dealChoice.equals("2")){
                                    admin.remove_deal();

                                }
                                else if(dealChoice.equals("3")){
                                    break;
                                }
                                else{
                                    System.out.println("Please enter a valid input\n");
                                }

                            }

                        }
                        else if(adminChoice.equals("6")){
                            admin.visitor_stats();


                        }
                        else if(adminChoice.equals("7")){
                            admin.feedback();

                        }

                        else if (adminChoice.equals("8")){
                            break;
                        }
                        else{
                            System.out.println("Please enter a valid input \n");
                        }

                    }

                }
                else{
                    System.out.println("You don't have authorisation to access this level\n");

                }

            }
            else if(choice.equals("2")){
                while(true){
                    login_page();

                    System.out.print("Enter your choice:");
                    String loginChoice = scanner.nextLine().trim();
                    System.out.println();

                    if (loginChoice.equals("1")){
                        String name;
                        int age;
                        String phoneNumber;
                        int balance;
                        String email;
                        String password;
                        int membership = -1;

                        System.out.print("Enter visitor name: ");
                        name = scanner.nextLine();
                        System.out.println();
                        while(true){
                            System.out.print("Enter age: ");
                            if(scanner.hasNextInt()){
                                age = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println();
                                break;

                            }
                            else{
                                String temp = scanner.nextLine();
                                System.out.println();
                                System.out.println("Please enter a valid input");
                            }
                        }



                        System.out.print("Enter phone number: ");
                        phoneNumber = scanner.nextLine();
                        System.out.println();

                        while(true){
                            System.out.print("Enter visitor balance: ");

                            if (scanner.hasNextInt()){
                                balance = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println();
                                break;

                            }
                            else{
                                String temp = scanner.nextLine();
                                System.out.println();
                                System.out.println("Please enter a valid input");
                            }

                        }


                        System.out.print("Enter visitor email: ");
                        email = scanner.nextLine();
                        System.out.println();

                        System.out.print("Enter visitor password: ");
                        password = scanner.nextLine();
                        System.out.println();

                        Visitor visitor = new Visitor(name, age,phoneNumber,balance,email,password,membership);

                        Zoo.add_visitors(visitor);

                        System.out.println("Registration is successful\n");



                    }

                    else if (loginChoice.equals("2")){
                        String email;
                        String password;
                        System.out.print("Enter visitor email:");
                        email = scanner.nextLine().trim();
                        System.out.print("Enter visitor password:");
                        password = scanner.nextLine().trim();
                        System.out.println();


                        if (Zoo.is_valid_visitor(email, password)){
                            int visitorIndex = Zoo.visitor_index(email,password);
                            while(true){
                                visitor_menu();


                                System.out.print("Enter your choice:");
                                String visitorChoice = scanner.nextLine().trim();
                                System.out.println();

                                if (visitorChoice.equals("1")){
                                    visitor_explore();

                                    String exploreChoice;
                                    System.out.print("Enter your choice:");
                                    exploreChoice = scanner.nextLine().trim();

                                    if (exploreChoice.equals("1")){
                                        Zoo.getVisitors().get(visitorIndex).explore_attractions();

                                    }
                                    else if(exploreChoice.equals("2")){
                                        Zoo.getVisitors().get(visitorIndex).explore_animals();

                                    }
                                    else if(exploreChoice.equals("3")){
                                        break;

                                    }
                                    else{
                                        System.out.println("Please enter a valid input\n");
                                    }

                                }
                                else if(visitorChoice.equals("2")){
                                    if (Zoo.getVisitors().get(visitorIndex).getMembership() == -1){
                                        System.out.println("You currently don't have a membership\n");
                                        System.out.println("1. Basic Membership (Rs 20)");
                                        System.out.println("2. Premium Membership (Rs 200)\n");


                                        String membershipChoice;
                                        System.out.print("Enter your choice:");
                                        membershipChoice = scanner.nextLine().trim();

                                        if (membershipChoice.equals("1")){
                                            Zoo.getVisitors().get(visitorIndex).buy_basic_membership(visitorIndex);

                                        }
                                        else if(membershipChoice.equals("2")){
                                            Zoo.getVisitors().get(visitorIndex).buy_premium_membership(visitorIndex);

                                        }
                                        else{
                                            System.out.println("Please enter valid input\n");
                                        }
                                    }
                                    else if(Zoo.getVisitors().get(visitorIndex).getMembership() == 0){
                                        System.out.println("You currently have a basic membership\n");

                                        System.out.println("1. Premium Membership (Rs 200)\n");

                                        String membershipChoice;
                                        System.out.print("Enter your choice:");
                                        membershipChoice = scanner.nextLine().trim();

                                        if (membershipChoice.equals("1")){
                                            Zoo.getVisitors().get(visitorIndex).buy_premium_membership(visitorIndex);
                                        }
                                        else {
                                            System.out.println("Please enter a valid input\n");
                                        }
                                    }
                                    else{
                                        System.out.println("You already have the premium membership\n");
                                    }

                                }
                                else if(visitorChoice.equals("3")){
                                    Zoo.getVisitors().get(visitorIndex).buy_tickets(visitorIndex);

                                }
                                else if(visitorChoice.equals("4")){
                                    Zoo.getVisitors().get(visitorIndex).view_discounts();

                                }
                                else if(visitorChoice.equals("5")){
                                    Zoo.view_deals();

                                }
                                else if(visitorChoice.equals("6")){
                                    Zoo.getVisitors().get(visitorIndex).visit_animals();

                                }
                                else if(visitorChoice.equals("7")){
                                    Zoo.getVisitors().get(visitorIndex).visit_attraction(visitorIndex);

                                }
                                else if(visitorChoice.equals("8")){
                                    Zoo.getVisitors().get(visitorIndex).leave_feedback();

                                }
                                else if(visitorChoice.equals("9")){
                                    break;
                                }
                                else{
                                    System.out.println("Please enter a valid input\n");
                                }
                            }

                        }
                        else{
                            System.out.println("Please enter a valid email or password\n");
                        }

                    }

                    else if(loginChoice.equals("3")){
                        break;
                    }

                    else{
                        System.out.println("Please enter valid input\n");
                    }

                }

            }
            else if(choice.equals("3")){
                System.out.println("Current Deals: ");
                System.out.println();
                Zoo.view_deals();

            }
            else if(choice.equals("4")){
                System.out.println("See you soon");
                break;
            }
            else{
                System.out.println("Please enter a valid input\n");
            }
        }

    }
}