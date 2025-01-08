package DesignPatterns.StandardProblems.FacadePatternDemo;

public class FundCheck {
    private double cashInAccount = 100;
    public double getCashInAccount(){
        return cashInAccount;
    }

    private void increaseCash(double amount){
        cashInAccount+=amount;
    }

    private void decreaseCash(double amount){
        cashInAccount-=amount;
    }

    public boolean haveEnoughMoney(double money){
        if(money <= getCashInAccount()){
            decreaseCash(money);
            System.out.println("Withdraw Completed : Current Balance is: " + getCashInAccount());
            return true;
        }
        System.out.println("Error : you don't have enough Money: " + getCashInAccount());
        return false;
    }

    public void makeDeposit(double amount){
        increaseCash(amount);
        System.out.printf("Deposit Complete: %s%n", getCashInAccount());
    }
}
