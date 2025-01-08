package DesignPatterns.StandardProblems.FacadePatternDemo;

public class BankAccountFacade {
    private int acctNumber;
    private int securityNumber;

    AccountNumberCheck accountNumberCheck ;
    SecurityNumberCheck securityNumberCheck;
    FundCheck fundCheck;

    public BankAccountFacade(int acctNumber, int securityNumber){
        this.acctNumber = acctNumber;
        this.securityNumber = securityNumber;
        this.accountNumberCheck = new AccountNumberCheck();
        this.securityNumberCheck = new SecurityNumberCheck();
        this.fundCheck = new FundCheck();
    }

    public void withDraw(double cash){
        if(accountNumberCheck.checkAccountNumber(acctNumber) && securityNumberCheck.isCodeCorrect(securityNumber) &&  fundCheck.haveEnoughMoney(cash)){
            System.out.println("Transaction Completed");
        } else {
            System.out.println("Transaction Failed");
        }
    }

    public void deposit(double cash){
        if(accountNumberCheck.checkAccountNumber(acctNumber) && securityNumberCheck.isCodeCorrect(securityNumber)){
            fundCheck.makeDeposit(cash);
            System.out.println("Transaction Completed");
        } else {
            System.out.println("Transaction Failed");
        }
    }

}
