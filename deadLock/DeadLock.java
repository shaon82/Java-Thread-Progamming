import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeadLock {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void running(){
        synchronized (lock1){
            log("Acquired lock1");
                synchronized (lock2){
                    log("lock2 Acquired");
                    System.out.println("Running.......");
                    log("About to release lock2");
                }
                log("About to release lock1");
            }
        }



    public void walking(){
        synchronized (lock2){
            System.out.println("Acquired lock2");{
                synchronized (lock1){
                    log("lock1 Acquired");
                    System.out.println("Running.......");
                    log("About to release lock1");
                }
                log("About to release lock2");
            }
        }
    }

    private void log(String msg){
        LocalDateTime now = LocalDateTime.now();
        String time = DateTimeFormatter.ISO_LOCAL_TIME.format(now);
        String threadName = Thread.currentThread().getName();
        System.out.printf("%12s %s : %s%n", time, threadName,msg);
    }
}
