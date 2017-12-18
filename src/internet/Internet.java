package internet;

public class Internet implements Runnable {


    public static boolean isConnected=false;


    public Internet()
    {
        Thread t=new Thread(this);
        t.setDaemon(true);
        t.start();
    }


    @Override
    public void run() {
        while (true)
        {
            isConnected=new CheckConnection().IsConnected();
           // System.out.println(isConnected);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
