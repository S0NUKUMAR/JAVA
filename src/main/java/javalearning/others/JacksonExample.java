package javalearning.others;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonExample {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("Hello World");
        Student s = new Student(1, "John");
        System.out.println(s);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(s);
        System.out.println(jsonString);

        Student s1 = mapper.readValue(jsonString, Student.class);
        System.out.println(s1);
    }
}
