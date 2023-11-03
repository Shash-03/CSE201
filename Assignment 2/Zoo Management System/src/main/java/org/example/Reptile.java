package org.example;

public class Reptile extends Animal{

    public Reptile(String name, String sound , String description){
        super(name, sound, description);
    }

    @Override
    public void sound(){
        System.out.println(getName()+ ":" + getSound());

    }

    @Override
    public void description(){
        System.out.println(getName()+ ":");
        System.out.println(getDescription());
    }
    @Override
    public String animal_type(){
        return "Reptile";
    }

}
