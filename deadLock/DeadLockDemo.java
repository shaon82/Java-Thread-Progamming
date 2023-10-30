import java.util.concurrent.TimeUnit;

public class DeadLockDemo {
    public static void main(String[] args) {

        DeadLock deadLock = new DeadLock();

        Thread runningThread = new Thread(()->{
           while (!Thread.currentThread().isInterrupted()){
               deadLock.running();

               try {
                   TimeUnit.MICROSECONDS.sleep(100);
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
                   throw new RuntimeException(e);
               }
           }
        });

        runningThread.setName("Running Thread.............");


        Thread walkingThread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                deadLock.walking();

                try {
                    TimeUnit.MICROSECONDS.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
        });

        walkingThread.setName("Walking Thread............");

        runningThread.start();
        walkingThread.start();


    }
}
