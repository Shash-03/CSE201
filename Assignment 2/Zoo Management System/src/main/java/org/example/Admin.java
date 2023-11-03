package org.example;
import java.util.*;
public class Admin implements AdminFunctions{

    public Admin(){


    }


    public void add_attractions(){               //Adds attraction to HashMap
        Scanner scanner = new Scanner(System.in);


        int id;

        while(true){
            System.out.print("Enter id:");
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
            System.out.println("ID already exists\n");
            return;
        }

        String name;
        System.out.print("Enter event name:");
        name = scanner.nextLine();

        String description;
        System.out.print("Enter event description:");
        description = scanner.nextLine();
        System.out.println();

        Attraction attraction = new Attraction(name, description);

        Zoo.getAttractions().put(id, attraction);

        Schedule schedule = new Schedule(false, "",0,0,0,0);

        Zoo.getSchedules().put(id,schedule);

    }

    public void view_attractions(){   //Views all the attractions
        for (int id : Zoo.getAttractions().keySet()){
            System.out.println("ID:"+ id);
            System.out.println("Name:"+Zoo.getAttractions().get(id).getName());
            System.out.println("Description:" + Zoo.getAttractions().get(id).getDescription());
            System.out.println();
        }
        System.out.println();
    }

    public void remove_attractions(){// Removes attraction from hashmap
        Scanner scanner = new Scanner(System.in);

        int id;

        while(true){
            System.out.print("Enter the id of the attraction you want to remove: ");
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
            Zoo.getAttractions().remove(id);
            Zoo.getSchedules().remove(id);
            System.out.println("Attraction removed successfully\n");

        }
        else{
            System.out.println("Please enter a valid id\n");
        }

    }

    public void modify_attraction(){  //Modifies a particular parameter of the attraction
        Scanner scanner = new Scanner(System.in);

        int id;

        while(true){
            System.out.print("Enter the id of the attraction you want to modify: ");
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
            while(true){
                System.out.println("1.Modify name");
                System.out.println("2.Modify description");
                System.out.println("3.Exit\n");

                System.out.print("Enter your choice:");

                String choice = scanner.nextLine().trim();

                System.out.println();

                if(choice.equals("1")){
                    String name;
                    System.out.print("Enter event name:");
                    name = scanner.nextLine();

                    Attraction attraction = new Attraction(name,Zoo.getAttractions().get(id).getDescription());
                    Zoo.getAttractions().put(id,attraction);


                }
                else if(choice.equals("2")){
                    String description;
                    System.out.print("Enter event description:");
                    description = scanner.nextLine();

                    Attraction attraction = new Attraction(Zoo.getAttractions().get(id).getName(),description);
                    Zoo.getAttractions().put(id,attraction);

                }
                else if(choice.equals("3")){
                    break;

                }
                else{
                    System.out.println("Please enter a valid option\n");
                }

            }

        }
        else{
            System.out.println("Please enter a valid id\n");

        }

    }

    public void schedule_event(){   //Open/close an event, set time for an event, set ticket price of an event and number of visitors of an event
        Scanner scanner = new Scanner(System.in);

        int id;

        while(true){
            System.out.print("Enter the id of the event you want to schedule: ");
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

        if (Zoo.getSchedules().containsKey(id)){
            while (true){
                System.out.println("1.Open/Closed");
                System.out.println("2.Change Timings");
                System.out.println("3.View Number of Visitors");
                System.out.println("4.Ticket price");
                System.out.println("5.Exit\n");

                System.out.print("Enter your choice:");

                String choice = scanner.nextLine().trim();

                System.out.println();

                if (choice.equals("1")){
                    String status;

                    if (Zoo.getSchedules().get(id).getOpen()){
                        System.out.println("Currently open");
                    }
                    else{
                        System.out.println("Currently closed");
                    }

                    System.out.println();

                    System.out.print("Enter status (Open/Closed) : ");

                    status = scanner.nextLine().trim();

                    System.out.println();

                    if (status.equalsIgnoreCase("open")){
                        Zoo.getSchedules().get(id).setOpen(true);
                    }
                    else if (status.equalsIgnoreCase("closed")){
                        Zoo.getSchedules().get(id).setOpen(false);

                    }
                    else{
                        System.out.println("Please enter a valid option\n");
                    }

                }
                else if(choice.equals("2")){
                    String timings;
                    if (!Zoo.getSchedules().get(id).getTiming().isEmpty()){
                        System.out.print("Current timings:" + Zoo.getSchedules().get(id).getTiming());
                        System.out.println();

                    }

                    System.out.print("Enter new timings:");
                    timings = scanner.nextLine();

                    System.out.println();

                    Schedule schedule = new Schedule(Zoo.getSchedules().get(id).getOpen(),timings,Zoo.getSchedules().get(id).getNoOfVisitors(),Zoo.getSchedules().get(id).getTicketPrice(),Zoo.getSchedules().get(id).getNumTickets(),Zoo.getSchedules().get(id).getRevenue());

                    Zoo.getSchedules().put(id,schedule);



                }
                else if(choice.equals("3")){
                    System.out.println("No of visitors:" + Zoo.getSchedules().get(id).getNoOfVisitors());
                    System.out.println();

                }
                else if(choice.equals("4")){
                    System.out.println("Current ticket price: Rs. " + Zoo.getSchedules().get(id).getTicketPrice());

                    System.out.println();

                    int price;

                    System.out.print("Enter new ticket price:");
                    price = scanner.nextInt();
                    scanner.nextLine();

                    Zoo.getSchedules().get(id).setTicketPrice(price);

                }
                else if(choice.equals("5")){
                    break;

                }
                else{
                    System.out.println("Please enter a valid option\n");
                }



            }

        }
        else{
            System.out.println("Please enter a valid id\n");
        }

    }

    public void feedback(){     //Returns all the feedback provided by visitors

        int n = Zoo.getFeedback().size();

        if (n == 0){
            System.out.println("No feedback as of yet\n");
        }

        else{
            for (int i = 0 ; i < n;i++){
                System.out.println(i+1 + "." + Zoo.getFeedback().get(i));
                System.out.println();
            }
        }
    }

    public void add_animal(){   //Adds animal to hashmap
        Scanner scanner = new Scanner(System.in);

        int id;

        while(true){
            System.out.print("Enter the id for the new animal: ");
            if (scanner.hasNextInt()){
                id = scanner.nextInt();
                scanner.nextLine();

                break;

            }
            else{
                String temp = scanner.nextLine();
                System.out.println();
                System.out.println("Please enter valid input");

            }

        }

        if (Zoo.getAnimals().containsKey(id)){
            System.out.println("ID already exists\n");
            return;
        }

        String name;
        System.out.print("Enter animal name:");
        name = scanner.nextLine();

        String description;
        System.out.print("Enter a brief description of the animal:");
        description = scanner.nextLine();


        String sound;
        System.out.print("Enter the sound the animal makes:");
        sound = scanner.nextLine();

        String type;
        System.out.print("Enter whether animal is Reptile(R)/Amphibian(A)/Mammal(M):");
        type = scanner.nextLine();
        System.out.println();

        if (type.equalsIgnoreCase("r")){
            Reptile reptile = new Reptile(name,sound,description);
            Zoo.getAnimals().put(id,reptile);

        }
        else if(type.equalsIgnoreCase("a")){
            Amphibian amphibian = new Amphibian(name, sound,description);
            Zoo.getAnimals().put(id,amphibian);
        }
        else if(type.equalsIgnoreCase("m")){
            Mammal mammal = new Mammal(name,sound,description);
            Zoo.getAnimals().put(id,mammal);
        }
        else{

            System.out.println("Please enter a valid type\n");

        }




    }

    public void remove_animal(){  //Removes animal from hashmap

        System.out.println("Animals currently in the zoo:");
        System.out.println();

        for (int id: Zoo.getAnimals().keySet()){
            System.out.println("ID:"+id);
            System.out.println("Animal name:" + Zoo.getAnimals().get(id).getName());
            System.out.println("Animal sound:" + Zoo.getAnimals().get(id).getSound());
            System.out.println("Animal description:" + Zoo.getAnimals().get(id).getDescription());
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);

        int id;

        while(true){
            System.out.print("Enter the id of the animal you want to remove: ");
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
            String type = Zoo.getAnimals().get(id).animal_type().trim();
            int count = 0;
            for (int animalId: Zoo.getAnimals().keySet()){
                if (Zoo.getAnimals().get(animalId).animal_type().trim().equalsIgnoreCase(type)){
                    count++;
                }
            }
            if (count <= 2){
                System.out.println("Animal can't be removed otherwise number of "+Zoo.getAnimals().get(id).animal_type() + " will go below 2\n") ;
                return;
            }
            Zoo.getAnimals().remove(id);
            System.out.println("Animal removed successfully\n");

        }
        else{
            System.out.println("Please enter a valid input\n");
        }



    }

    public void modify_animals(){  //Modifies a particular attribute of an animal

        System.out.println("Animals currently in the zoo:");
        System.out.println();

        for (int id: Zoo.getAnimals().keySet()){
            System.out.println("ID:"+id);
            System.out.println("Animal name:" + Zoo.getAnimals().get(id).getName());
            System.out.println("Animal sound:" + Zoo.getAnimals().get(id).getSound());
            System.out.println("Animal description:" + Zoo.getAnimals().get(id).getDescription());
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);

        int id;

        while(true){
            System.out.print("Enter the id of the animal you want to modify: ");
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
            while(true){
                System.out.println("1.Modify name");
                System.out.println("2.Modify sound");
                System.out.println("3.Modify description");
                System.out.println("4.Exit\n");

                String choice;
                System.out.print("Enter your choice:");
                choice = scanner.nextLine().trim();
                System.out.println();

                if (choice.equals("1")){
                    String name;
                    System.out.print("Enter new animal name:");
                    name = scanner.nextLine().trim();
                    System.out.println();

                    if (Zoo.getAnimals().get(id).animal_type().equals("Amphibian")){
                        Amphibian amphibian = new Amphibian(name, Zoo.getAnimals().get(id).getSound(),Zoo.getAnimals().get(id).getDescription());
                        Zoo.getAnimals().put(id,amphibian);

                    }
                    else if(Zoo.getAnimals().get(id).animal_type().equals("Reptile")){
                        Reptile reptile = new Reptile(name, Zoo.getAnimals().get(id).getSound(),Zoo.getAnimals().get(id).getDescription());
                        Zoo.getAnimals().put(id,reptile);
                    }
                    else{
                        Mammal mammal = new Mammal(name, Zoo.getAnimals().get(id).getSound(),Zoo.getAnimals().get(id).getDescription());
                        Zoo.getAnimals().put(id,mammal);

                    }

                }
                else if(choice.equals("2")){
                    String sound;
                    System.out.print("Enter new animal sound:");
                    sound = scanner.nextLine().trim();
                    System.out.println();

                    if (Zoo.getAnimals().get(id).animal_type().equals("Amphibian")){
                        Amphibian amphibian = new Amphibian(Zoo.getAnimals().get(id).getName(), sound,Zoo.getAnimals().get(id).getDescription());
                        Zoo.getAnimals().put(id,amphibian);

                    }
                    else if(Zoo.getAnimals().get(id).animal_type().equals("Reptile")){
                        Reptile reptile = new Reptile(Zoo.getAnimals().get(id).getName(), sound,Zoo.getAnimals().get(id).getDescription());
                        Zoo.getAnimals().put(id,reptile);
                    }
                    else{
                        Mammal mammal = new Mammal(Zoo.getAnimals().get(id).getName(), sound,Zoo.getAnimals().get(id).getDescription());
                        Zoo.getAnimals().put(id,mammal);

                    }

                }
                else if(choice.equals("3")){
                    String description;
                    System.out.print("Enter new animal description:");
                    description = scanner.nextLine().trim();
                    System.out.println();

                    if (Zoo.getAnimals().get(id).animal_type().equals("Amphibian")){
                        Amphibian amphibian = new Amphibian(Zoo.getAnimals().get(id).getName(), Zoo.getAnimals().get(id).getSound(),description);
                        Zoo.getAnimals().put(id,amphibian);

                    }
                    else if(Zoo.getAnimals().get(id).animal_type().equals("Reptile")){
                        Reptile reptile = new Reptile(Zoo.getAnimals().get(id).getName(), Zoo.getAnimals().get(id).getSound(),description);
                        Zoo.getAnimals().put(id,reptile);
                    }
                    else{
                        Mammal mammal = new Mammal(Zoo.getAnimals().get(id).getName(), Zoo.getAnimals().get(id).getSound(),description);
                        Zoo.getAnimals().put(id,mammal);

                    }

                }
                else if(choice.equals("4")){
                    break;
                }
                else{
                    System.out.println("Please enter a valid input\n");
                }
            }

        }
        else{
            System.out.println("Please enter a valid input\n");
        }

    }

    public void add_discount(){  //Adds a new discount
        Scanner scanner = new Scanner(System.in);


        int id;

        while(true){
            System.out.print("Enter id:");
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

        if (Zoo.getDiscounts().containsKey(id)){
            System.out.println("Id is already in use\n");
            return;
        }
        else{
            String category;
            int percentage;

            while(true){
                System.out.print("Enter category (should have greater than 1 character):");
                category = scanner.nextLine().trim();

                if (category.length() >= 2){
                    System.out.println();
                    break;
                }
                else{
                    System.out.println("Please enter valid input\n");
                }

            }





            while(true){
                System.out.print("Enter discount percentage:");
                if (scanner.hasNextInt()){
                    percentage = scanner.nextInt();
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

            Discount discount = new Discount(category,percentage);
            Zoo.getDiscounts().put(id, discount);

            String discountCode = Zoo.getDiscounts().get(id).getCategory().substring(0,2).toLowerCase() + Zoo.getDiscounts().get(id).getPercentage();
            Zoo.getDiscount_codes().put(id,discountCode);


        }

    }

    public void remove_discount(){   //Removes discount
        System.out.println("Current Discounts:");
        System.out.println();

        for (int id: Zoo.getDiscounts().keySet()){
            System.out.println("ID:"+id);
            System.out.println("Discount category:" + Zoo.getDiscounts().get(id).getCategory());
            System.out.println("Discount percentage:" + Zoo.getDiscounts().get(id).getPercentage());
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);

        int id;

        while(true){
            System.out.print("Enter the id of the discount you want to remove: ");
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

        if (Zoo.getDiscounts().containsKey(id)){
            Zoo.getDiscounts().remove(id);
            Zoo.getDiscount_codes().remove(id);
            System.out.println("Discount removed successfully\n");

        }
        else{
            System.out.println("Please enter a valid input\n");
        }

    }

    public void modify_discount(){  //Modifies a particular parameter of the discount
        System.out.println("Current Discounts:");
        System.out.println();

        for (int id: Zoo.getDiscounts().keySet()){
            System.out.println("ID:"+id);
            System.out.println("Discount category:" + Zoo.getDiscounts().get(id).getCategory());
            System.out.println("Discount percentage:" + Zoo.getDiscounts().get(id).getPercentage());
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);

        int id;

        while(true){
            System.out.print("Enter the id of the discount you want to modify: ");
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

        if (Zoo.getDiscounts().containsKey(id)){

            while (true){
                System.out.println("1.Category");
                System.out.println("2.Percentage");
                System.out.println("3.Exit\n");

                String choice;
                System.out.print("Enter your choice:");
                choice = scanner.nextLine().trim();
                System.out.println();

                if (choice.equals("1")){
                    String category;
                    while(true){
                        System.out.print("Enter category (should have more than 1 character):");
                        category = scanner.nextLine().trim();

                        if (category.length() >= 2){
                            System.out.println();
                            break;
                        }
                        else{
                            System.out.println("Please enter a valid input\n");
                        }

                    }

                    Discount discount = new Discount(category, Zoo.getDiscounts().get(id).getPercentage());

                    Zoo.getDiscounts().put(id,discount);

                    String discountCode = Zoo.getDiscounts().get(id).getCategory().substring(0,2).toLowerCase() + Zoo.getDiscounts().get(id).getPercentage();
                    Zoo.getDiscount_codes().put(id,discountCode);


                }
                else if(choice.equals("2")){
                    int new_percentage;
                    while(true){
                        System.out.print("Enter new discount percentage: ");
                        if (scanner.hasNextInt()){
                            new_percentage = scanner.nextInt();
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

                    Zoo.getDiscounts().get(id).setPercentage(new_percentage);
                    String discountCode = Zoo.getDiscounts().get(id).getCategory().substring(0,2).toLowerCase() + Zoo.getDiscounts().get(id).getPercentage();
                    Zoo.getDiscount_codes().put(id,discountCode);



                }
                else if(choice.equals("3")){
                    break;

                }
                else{
                    System.out.println("Please enter a valid input\n");
                }
            }


        }
        else{
            System.out.println("Please enter a valid input\n");
        }

    }

    public void add_deal(){   //Adds a new deal
        Scanner scanner = new Scanner(System.in);
        int id;

        while(true){
            System.out.print("Enter id:");
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

        if (Zoo.getDeals().containsKey(id)){
            System.out.println("Id is already in use\n");
            return;
        }
        else{
            int numTickets;
            int percentage;

            while(true){
                System.out.print("Enter minimum number of tickets person needs to buy to avail discount:");
                if (scanner.hasNextInt()){
                    numTickets = scanner.nextInt();
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

            while(true){
                System.out.print("Enter discount percentage:");
                if (scanner.hasNextInt()){
                    percentage = scanner.nextInt();
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

            Deal deal = new Deal(numTickets, percentage);

            Zoo.getDeals().put(id, deal);

        }


    }

    public void remove_deal(){  //Removes a deal
        System.out.println("Current Deals:");
        System.out.println();

        for (int id: Zoo.getDeals().keySet()){
            System.out.println("ID:"+id);
            Zoo.getDeals().get(id).description();
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);

        int id;

        while(true){
            System.out.print("Enter the id of the deal you want to remove: ");
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

        if (Zoo.getDeals().containsKey(id)){
            Zoo.getDeals().remove(id);
            System.out.println("Deal removed successfully\n");

        }
        else{
            System.out.println("Please enter a valid input\n");
        }

    }

    public void visitor_stats(){  //Prints various statistics of the zoo
        System.out.println("Visitor statistics:");
        System.out.println();

        int totalRevenue = 0;
        int numberVisitors = 0;
        ArrayList <Integer> visitorsPerAttraction = new ArrayList<>();
        visitorsPerAttraction.add(0);

        for (int id : Zoo.getSchedules().keySet()){
            totalRevenue += Zoo.getSchedules().get(id).getRevenue();
            numberVisitors += Zoo.getSchedules().get(id).getNoOfVisitors();
            visitorsPerAttraction.add(Zoo.getSchedules().get(id).getNoOfVisitors());

        }

        totalRevenue += Zoo.getMembershipRevenue();
        System.out.println("Total Revenue: Rs" + totalRevenue);
        System.out.println("Number of Visitors: " + numberVisitors); //Assumed to be sum of the number of visitors who have visited an attraction

        System.out.println("Most popular attractions:");

        visitorsPerAttraction.sort(new DescendingComparator());

        int maxVisits = visitorsPerAttraction.get(0);

        int number = 1;

        for (int id : Zoo.getSchedules().keySet()){
            if (Zoo.getSchedules().get(id).getNoOfVisitors() == maxVisits){
                System.out.println(number + "." + Zoo.getAttractions().get(id).getName());
                number++;
            }
        }
        System.out.println();


    }

}
