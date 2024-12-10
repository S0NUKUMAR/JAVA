package javalearning.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaComparableExample {
   public static class Student implements Comparable<Student> {
       int age;
       String name ;
       Student(int age , String name){
           this.age = age;
           this.name = name;
       }
       @Override
       public int compareTo(Student s) {
           return s.age - age;
       }

       public String toString(){
           return "[age: " + this.age + " , " +"name: " + this.name + "]";
       }
   }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(10, "ten"));
        students.add(new Student(5, "five"));
        students.add(new Student(12, "twelve"));
        students.add(new Student(1, "one"));


        Collections.sort(students);
        System.out.println(students);
    }

}
