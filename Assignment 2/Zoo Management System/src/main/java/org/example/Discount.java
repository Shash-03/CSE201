package org.example;
import java.util.*;
public class Discount extends Coupon{
    private String category;


    public Discount(String category, int percentage){
        super(percentage);
        this.category = category;


    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
