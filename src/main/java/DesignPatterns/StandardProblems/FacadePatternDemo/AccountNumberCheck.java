package DesignPatterns.StandardProblems.FacadePatternDemo;

public class AccountNumberCheck {
    private final int accountNumber = 123456789;
    public int getAccountNumber(){
        return accountNumber;
    }
    public boolean checkAccountNumber(int acc){
        return accountNumber ==  acc;
    }
}
