package DesignPatterns.StandardProblems.FacadePatternDemo;

public class FacadePatternExample {
    public static void main(String[] args) {
        System.out.println("Welcome to Banking Facade System");
        BankAccountFacade bank = new BankAccountFacade(123456789,1234);
        bank.withDraw(10);
        bank.deposit(110);
    }
}
