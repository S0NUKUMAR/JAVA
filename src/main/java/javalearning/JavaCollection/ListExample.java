package javalearning.JavaCollection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // ArrayList example
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");

        System.out.println("ArrayList:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        System.out.println("\nArrayList:");
        fruits.forEach(System.out::println);

        // LinkedList example
        List<String> animals = new LinkedList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Horse");
        animals.add("Cow");

        System.out.println("\nLinkedList:");
        animals.forEach(System.out::println);
    }

}

/*
- ArrayList is based on dynamic arrays, offering fast O(1) random access.
- LinkedList is implemented as a double linked list, allowing quick O(1) insertions and deletions.
- ArrayList has slower O(n) insertions and deletions due to the need for element shifting.
- LinkedList provides slower O(n) access as elements are sequentially accessed.
- ArrayList is more memory-efficient compared to LinkedList.
- LinkedList has a higher memory overhead due to storing additional references for each element.
- ArrayList is preferred for use cases with frequent read operations.
- LinkedList is better suited for scenarios with frequent insertions and deletions.
- The choice between ArrayList and LinkedList depends on operation frequency, memory considerations, and access speed requirements.
*/