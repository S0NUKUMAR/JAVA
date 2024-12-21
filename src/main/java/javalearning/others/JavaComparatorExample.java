package javalearning.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JavaComparatorExample {
    public static void main(String[] args) {
        System.out.println("Java Comparator Example");
        List<Student> students = new ArrayList<>();
        students.add(new Student(10, "ten"));
        students.add(new Student(2, "two"));
        students.add(new Student(12, "twelve"));
        Comparator<Student> comp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age() - o2.age();
            }
        };

        Comparator<Student> compareByName = Comparator.comparing(Student::name);
        Collections.sort(students, compareByName);
        System.out.println(students);
    }
}
