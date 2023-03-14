public class NotEnoughMoneyException extends IllegalStateException{
    private double amount, balance;
    
    public NotEnoughMoneyException(double amount, double balance) {
        super("Amount cannot be withdrawn because Balance is lower than amount");
        this.balance = balance;
        this.amount=amount;
    }
    public double getAmount() {
        return amount;
    }

    public double getMissingAmount() {
        return amount-balance;
    }
    
    public double getBalance() {
        return balance;
    }
}
