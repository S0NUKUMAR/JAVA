package DesignPatterns.CarRentalSystemDemo;

import java.time.LocalDate;
import java.util.List;

public class CarRentalSystemDemo {
    public static void main(String[] args) {
        RentalSystem rentalSystem = RentalSystem.getInstance();

        rentalSystem.addCar(new Car("Toyota", "Camry", 2022, "ABC123", 50.0));
        rentalSystem.addCar(new Car("Honda", "Civic", 2021, "XYZ789", 45.0));
        rentalSystem.addCar(new Car("Ford", "Mustang", 2023, "DEF456", 80.0));

        Customer customer = new Customer("John Doe", "john@gmail.com","DL1234" );

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(3);

        List<Car> availableCars = rentalSystem.searchCars("Toyota" , "Camry" , startDate , endDate);
        if(!availableCars.isEmpty()){
            Car car = availableCars.getFirst();
            Reservation reservation = rentalSystem.makeReservation(customer, car,startDate,endDate);
            if(reservation!=null){
                boolean payment = rentalSystem.processPayment(reservation);
                if(payment){
                    System.out.println("Payment is successful " + reservation.getCar().getLicensePlate());
                }
                else {
                    System.out.println("Payment failed!!");
                }
            }
        }
    }
}
