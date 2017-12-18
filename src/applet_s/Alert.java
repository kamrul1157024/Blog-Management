package applet_s;

public class Alert implements Runnable{


    Alert()
    {
        Thread thread=new Thread(this);
        thread.start();
    }

    @Override
    public void run() {


    }



}
