package DesignPattern.CarRentalSystemTest;

import DesignPatterns.CarRentalSystemDemo.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CarTest {
    static Car car;
    @BeforeAll
    public static void Init(){
        car = new Car("Toyota", "Camry", 2022, "ABC123", 50.0);
    }

    @Test
    public void getMakeTest(){
        String result = car.getMake();
        String expected = "Toyota";

        Assertions.assertEquals(expected, result);
    }
}