import java.util.concurrent.TimeUnit;

public class SharedObject {

    private ThreadLocal<Integer> number = new ThreadLocal<>();


    public Integer getNumber() {
        return number.get();
    }

    public void setNumber(Integer number) {
        this.number.set(number) ;
    }


    private static void setRandomNumber(SharedObject sharedObject){
        sharedObject.setNumber((int) (Math.random()*100));

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }

        System.out.println("Thread creation : "+Thread.currentThread().getName());
        System.out.println("Value : "+sharedObject.getNumber());
    }



    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject();

        setRandomNumber(sharedObject);

        Thread thread1 = new Thread(()->{
           setRandomNumber(sharedObject);
        });

        Thread thread2 = new Thread(()->{
            setRandomNumber(sharedObject);
        });


        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread : "+Thread.currentThread().getName());
        System.out.println("Value : "+sharedObject.getNumber());
    }
}
