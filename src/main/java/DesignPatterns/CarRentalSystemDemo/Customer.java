package DesignPatterns.CarRentalSystemDemo;

public class Customer {
    private final String name;
    private final String contactInfo;
    private final String driverLiscenseNumber;

    public Customer(String name, String contactInfo, String driverLiscenseNumber) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.driverLiscenseNumber = driverLiscenseNumber;
    }
}
