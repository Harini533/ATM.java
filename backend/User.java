package backend;
public class User {
    
    String accountHolder;
    String cardNumber;
    int pin;
    double balance;
    String accountType;

      public User(String accountHolder, String cardNumber, int pin, double balance, String accountType)
       {

        this.accountHolder = accountHolder;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
        this.accountType = accountType;
       }
    

}
