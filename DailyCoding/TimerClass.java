package DailyCoding;

import java.util.Timer;
import java.util.TimerTask;

/*
This class executes a task repeatedly after 5 secs
 */
public class TimerClass {
    static class TestThread extends TimerTask {
        int i=1;
        public void run()
        {
            if(i==5)
            {
                System.out.println("Application Terminates");
                System.exit(0); // successful termination
            }
            ++i;
            System.out.println("calling this at "+java.time.LocalTime.now());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Timer t= new Timer();
        TimerTask task = new TestThread();
        t.schedule(task,0,5000); // this will schedule a task for every 5 secs starting right now
    }
}
