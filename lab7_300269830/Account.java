public class Account {
    private double balance;
    public Account() {
        balance = 0.0;
    } 

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Balance is: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new NotEnoughMoneyException(amount,balance);
        }else{
            balance = balance - amount;
            System.out.println("Balance is: " + balance);
        }
    }
    public double getBalance() {
        return balance;
    }
}
