package ie.atu.serialization;

import java.io.Serializable;

public class BankAccount implements Serializable {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private transient String pin;
    
    public BankAccount(String accountNumber, String accountHolder, double balance, String pin) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.pin = pin;
    }
    
    @Override
    public String toString() {
        return "BankAccount{accountNumber='" + accountNumber + "', accountHolder='" + 
               accountHolder + "', balance=" + balance + ", pin='" + pin + "'}";
    }
}
