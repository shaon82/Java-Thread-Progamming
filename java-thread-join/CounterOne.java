public class CounterOne extends Thread{


    @Override
    public void run(){
        for (int i = 1; i<=100; i++){
            System.out.println("counter one : "+i);
        }
    }
}
