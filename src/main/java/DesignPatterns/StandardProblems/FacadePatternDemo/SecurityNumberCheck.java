package DesignPatterns.StandardProblems.FacadePatternDemo;

public class SecurityNumberCheck {
    private final int security = 1234;
    public int getSecurity(){
        return security;
    }
    public boolean isCodeCorrect(int code){
        return this.security == code;
    }
}
