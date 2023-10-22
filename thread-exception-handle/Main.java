import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        System.out.println("current thread: "+Thread.currentThread().getName());

        Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {
                System.out.println("sum = "+(100/0));
//                try {
//                    TimeUnit.SECONDS.sleep(5);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException("Something went wrong");
//                }
            }
        });

        thread.setUncaughtExceptionHandler(new CustomUncaughtExceptionHandler());

        thread.start();
    }
}
