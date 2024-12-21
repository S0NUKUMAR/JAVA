package DesignPatterns.StandardProblems.StrategyPatternDemo;

public class PaypalStrategy implements PaymentStrategy {

    String email;
    String password;

    public PaypalStrategy(String email, String password){
        this.email  = email;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.printf("implemented the paypal strategy for payment : %d\n", amount);
    }
}