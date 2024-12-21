package DesignPatterns.StandardProblems.StrategyPatternDemo;

public class CreditCardStrategy implements PaymentStrategy {
    String name ;
    String ccNum ;
    String cvv ;
    String expiryDate ;

    public CreditCardStrategy(String name , String ccNum , String cvv , String expiryDate){
        this.name = name;
        this.ccNum = ccNum;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
    @Override
    public void pay(int amount) {
        System.out.printf("implemented payment method by credit card: %d\n", amount);
    }
}
