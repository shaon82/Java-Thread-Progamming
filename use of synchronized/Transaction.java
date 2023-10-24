import java.util.concurrent.TimeUnit;

public class Transaction {

    private long balance;

    public Transaction(long balance) {
        this.balance = balance;
    }

    public synchronized void withDraw(long amount){
        System.out.println("inside withdraw method ! Lock acquired!!");
        try {
            TimeUnit.MICROSECONDS.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println("Withdrawing : "+amount);
        long newBalance = balance - amount;
        System.out.println("new Balance is : "+ newBalance);
        balance = newBalance;

        System.out.println("End of withdraw Method! Release the Lock");
    }


    public synchronized void deposit(long amount){
        System.out.println("inside Deposit method ! Lock acquired!!");
        try {
            TimeUnit.MICROSECONDS.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println("Deposit : "+amount);
        long newBalance = balance + amount;
        System.out.println("new Balance is : "+ newBalance);
        balance = newBalance;

        System.out.println("End of Deposit Method! Release the Lock");
    }

    public long getBalance(){
        return balance;
    }
}
