public class DownloadingHeartBeat extends Thread {

    private volatile boolean beating = true;


    @Override
    public void run() {
        String[] dots = {
                ".",
                "..",
                "...",
                "...."
        };

        while (beating) {
            for (String dot : dots) {
                System.out.println(dot);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public void shutDown() {
        this.beating = false;
    }
}
