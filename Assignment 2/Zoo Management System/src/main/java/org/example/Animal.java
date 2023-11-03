package org.example;
import java.util.*;

public abstract class Animal {
    private String sound;

    private String name;

    private String description;

    public Animal(String name, String sound, String description){
        this.name = name;
        this.sound = sound;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSound() {
        return sound;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public abstract void sound();

    public abstract void description();

    public abstract String animal_type();
}
