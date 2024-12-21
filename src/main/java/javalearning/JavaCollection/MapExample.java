package javalearning.JavaCollection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapExample {
    public static void main(String[] args) {
        // HashMap example
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(3, "Three");
        hashMap.put(1, "One");
        hashMap.put(2, "Two");

        hashMap.get(1);
        System.out.println("HashMap: " + hashMap);

        // LinkedHashMap example
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(3, "Three");
        linkedHashMap.put(1, "One");
        linkedHashMap.put(2, "Two");
        System.out.println("LinkedHashMap: " + linkedHashMap);

        // TreeMap example
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        System.out.println("TreeMap: " + treeMap);
    }
}

/*
HashMap:
    Does not maintain any order.
    Offers constant-time performance for the basic operations (get and put).
LinkedHashMap:
    Maintains insertion order.
    Slightly slower than HashMap due to the maintenance of a doubly-linked list running through its entries.
TreeMap:
    Maintains natural ordering (or custom ordering via a Comparator).
    Offers log(n) time cost for the containsKey, get, put, and remove operations.
 */