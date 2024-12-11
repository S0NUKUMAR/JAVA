package DesignPatterns.CarRentalSystemDemo;

import DesignPatterns.CarRentalSystemDemo.Payment.PayPalPaymentProcessor;
import DesignPatterns.CarRentalSystemDemo.Payment.PaymentProcessor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class RentalSystem {
    private static RentalSystem rentalSystem;
    private final Map<String , Car> cars;
    private final Map<String , Reservation> reservations;
    private final PaymentProcessor paymentProcessor;

    private RentalSystem() {
        this.cars = new ConcurrentHashMap<>();
        this.reservations = new ConcurrentHashMap<>();
        this.paymentProcessor = new PayPalPaymentProcessor();
    }

    public static synchronized RentalSystem getInstance(){
        if(rentalSystem == null){
            rentalSystem = new RentalSystem();
        }
        return rentalSystem;
    }

    public List<Car> searchCars(String make , String model, LocalDate start , LocalDate end){
       return cars.values().stream().filter(car -> car.getMake().equals(make) && car.getModel().equals(model) && car.isAvailable() && checkCarAvailability(car, start, end)).collect(Collectors.toList());
    }

    public void addCar(Car car){
        cars.put(car.getLicensePlate(), car);
    }

    public void removeCar(String licensePlate){
        cars.remove(licensePlate);
    }

    private Boolean checkCarAvailability(Car car , LocalDate start , LocalDate end){
        return reservations.values().stream().noneMatch(reservation -> reservation.getCar().equals(car) && !(start.isBefore(reservation.getEndDate()) && end.isAfter(reservation.getStartDate())));
    }

    public synchronized Reservation makeReservation(Customer customer , Car car , LocalDate start , LocalDate end){
        if(checkCarAvailability(car , start , end)){
            String reservationId = generateReservation();
            Reservation reservation = new Reservation(reservationId, customer , car , start , end);
            reservations.put(reservationId, reservation);
            car.setAvailable(false);
            return reservation;
        }
        return null;
    }

    public boolean processPayment(Reservation reservation){
        return paymentProcessor.processPayment(reservation.getTotalPrice());
    }

    private String generateReservation() {
        return "RES" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }
}
