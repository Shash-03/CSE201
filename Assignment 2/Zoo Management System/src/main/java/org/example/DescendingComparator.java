package org.example;
import java.util.*;

public class DescendingComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1); // Sorting in reverse order
    }

}
