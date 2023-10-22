public class CounterTwo extends Thread{

    @Override
    public void run(){
        for (int i =1; i<=100; i++){
            System.out.println("counter two : "+i);
        }
    }
}
