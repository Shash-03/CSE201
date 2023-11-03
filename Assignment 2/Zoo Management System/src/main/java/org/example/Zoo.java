package org.example;
import javax.print.attribute.HashAttributeSet;
import java.util.*;

public class Zoo{
    private static HashMap<Integer, Attraction> attractions = new HashMap<>();
    private static HashMap<Integer, Animal> animals = new HashMap<>();
    private static HashMap<Integer, Schedule> schedules = new HashMap<>();
    private static HashMap<Integer,String> discount_codes = new HashMap<>();
    private static HashMap<Integer, Deal> deals = new HashMap<>();
    private static HashMap <Integer, Discount> discounts = new HashMap<>();
    private static ArrayList<String> feedback = new ArrayList<>();;
    private static ArrayList<Visitor> visitors = new ArrayList<>();

    private static int membershipRevenue = 0;

    static {
        Mammal mammal1 = new Mammal("Platypus","Grrrrr","Mammal but lays eggs");
        Mammal mammal2 = new Mammal("Vampire Bat","Hsssss","May have caused covid");
        Amphibian amphibian1 = new Amphibian("Fire Salamander","Raaaaa","Does not breathe fire");
        Amphibian amphibian2 = new Amphibian("Toad","Croack","May be highly poisonous");
        Reptile reptile1 = new Reptile("Snake","Rattle rattle","Definitely highly poisonous");
        Reptile reptile2 = new Reptile("Lizard","Hehehehe","Pretty disgusting");
        Zoo.getAnimals().put(1018,mammal1);
        Zoo.getAnimals().put(1019,mammal2);
        Zoo.getAnimals().put(1020,amphibian1);
        Zoo.getAnimals().put(1021,amphibian2);
        Zoo.getAnimals().put(1022,reptile1);
        Zoo.getAnimals().put(1023,reptile2);
    }

    public Zoo(){


    }

    public static HashMap<Integer, String> getDiscount_codes() {
        return discount_codes;
    }

    public static HashMap<Integer, Deal> getDeals() {
        return deals;
    }

    public static HashMap<Integer, Animal> getAnimals() {
        return animals;
    }

    public static HashMap<Integer, Discount> getDiscounts() {
        return discounts;
    }

    public static ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    public static ArrayList<String> getFeedback() {
        return feedback;
    }

    public static int getMembershipRevenue() {
        return membershipRevenue;
    }

    public static HashMap<Integer, Attraction> getAttractions() {
        return attractions;
    }

    public static HashMap<Integer, Schedule> getSchedules() {
        return schedules;
    }

    public void setFeedback(ArrayList<String> feedback) {
        Zoo.feedback = feedback;
    }

    public static void setDiscount_codes(HashMap<Integer, String> discount_codes) {
        Zoo.discount_codes = discount_codes;
    }

    public void setAttractions(HashMap<Integer, Attraction> attractions) {
        Zoo.attractions = attractions;
    }

    public void setSchedules(HashMap<Integer, Schedule> schedules) {
        Zoo.schedules = schedules;
    }

    public void setVisitors(ArrayList<Visitor> visitors) {
        Zoo.visitors = visitors;
    }

    public static void setDeals(HashMap<Integer, Deal> deals) {
        Zoo.deals = deals;
    }

    public static void setDiscounts(HashMap<Integer, Discount> discounts) {
        Zoo.discounts = discounts;
    }

    public static void setAnimals(HashMap<Integer, Animal> animals) {
        Zoo.animals = animals;
    }

    public static void setMembershipRevenue(int membershipRevenue) {
        Zoo.membershipRevenue = membershipRevenue;
    }

    public static void add_visitors(Visitor visitor){
        getVisitors().add(visitor);

    }

    public static boolean is_valid_visitor(String email, String password){
        int n = getVisitors().size();

        for (int i = 0; i < n;i++){
            String visitorEmail = getVisitors().get(i).getEmail();
            String visitorPassword = getVisitors().get(i).getPassword();

            if (email.equals(visitorEmail) && password.equals(visitorPassword)){
                return true;
            }


        }
        return false;
    }

    public static int visitor_index(String email, String password){
        int n = getVisitors().size();

        for (int i = 0; i < n;i++){
            String visitorEmail = getVisitors().get(i).getEmail();
            String visitorPassword = getVisitors().get(i).getPassword();

            if (email.equals(visitorEmail) && password.equals(visitorPassword)){
                return i;
            }


        }

        return -1;
    }

    public static void view_deals(){
        int count = 1;
        for (int id: Zoo.getDeals().keySet()){
            System.out.print(count+"."+ " "+" ");
            Zoo.getDeals().get(id).description();
            count++;
        }

        System.out.println();

    }

}

