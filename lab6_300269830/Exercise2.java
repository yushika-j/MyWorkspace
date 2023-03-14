public class Exercise2{

    public static void main(String args[]) {
        try{
            Account myAccount=new Account();
            myAccount.deposit(600);
            myAccount.withdraw(300);
            myAccount.withdraw(400);
        }
        catch(NotEnoughMoneyException e){
            System.out.println(e.getMessage());
            System.out.println("You are missing " + e.getMissingAmount() + "$");
        }
    }

}