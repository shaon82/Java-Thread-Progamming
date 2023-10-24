import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankAccount {
    public static void main(String[] args) {


        Transaction transaction = new Transaction(100);

        DateTimeFormatter isoTimeFormater = DateTimeFormatter.ISO_TIME;

        Thread deposit = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"  -----   "+isoTimeFormater.format(LocalDateTime.now()));
            for (int i =0; i<10; i++){
                transaction.deposit(100);
                sleep();
            }
        });

        Thread withdraw = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"  -----   "+isoTimeFormater.format(LocalDateTime.now()));
            for (int i =0; i<10; i++){
                transaction.withDraw(100);
                sleep();
            }
        });

        deposit.start();
        withdraw.start();

        try {
            deposit.join();
            withdraw.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        System.out.println("The current Balance in account is : "+transaction.getBalance());
    }


    private static void sleep(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }
}
