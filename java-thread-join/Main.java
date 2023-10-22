public class Main {
    public static void main(String[] args) {

        DownloadingHeartBeat downloadingHeartBeat = new DownloadingHeartBeat();

        CounterOne  counterOne = new CounterOne();

        CounterTwo counterTwo = new CounterTwo();


        counterOne.start();
        counterTwo.start();

        downloadingHeartBeat.start();


        try {
            counterOne.join();
            counterTwo.join();

            downloadingHeartBeat.shutDown();
            downloadingHeartBeat.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




        System.out.println("Whole Program is completed!!!!!!");
    }
}
