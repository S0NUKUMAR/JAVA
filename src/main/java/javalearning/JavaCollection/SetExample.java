package javalearning.JavaCollection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(3);
        hashSet.add(1);
        hashSet.add(2);

        System.out.println("HashSet Stream:");
        hashSet.forEach(System.out::println);

        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(3);
        linkedHashSet.add(1);
        linkedHashSet.add(2);

        System.out.println("\nLinkedHashSet Stream:");
        linkedHashSet.forEach(System.out::println);

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);

        System.out.println("\nTreeSet Stream:");
        treeSet.forEach(System.out::println);
    }
}


/*
    HashSet is a collection of unique elements. It does not allow duplicate elements.
    Only difference Between HashSet and TreeSet is that HashSet does not maintain any order of elements.
    LinkedHashSet maintains the order of elements in which they are inserted.
 */
