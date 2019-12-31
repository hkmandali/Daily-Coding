package DailyCoding;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

/*
Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
 */
public class Day10 {

    public void testfun(){
        System.out.println("calling this at "+java.time.LocalTime.now());
    }
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, InterruptedException {
        System.out.println("enter the function string which needs to be executed and the millisec after which it needs to be called");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputfun = br.readLine(); // this function gets called after every millisec enter below
        int millisec = Integer.parseInt(br.readLine());
        Method getmethod = Day10.class.getDeclaredMethod(inputfun);
        for(int i=0;i<2;++i)
        {
            getmethod.invoke(new Day10());
            Thread.sleep(millisec);
        }
    }
}

// to use timer task include the below way , it can be done without timer task as well by just taking the thread.sleep , if we use timertask we need to write the function in run

/*
public class Day10 {
    static class TestThread extends TimerTask {
        int i=1;
        static void testfunction(){ // this function gets called after every n millisecs
            System.out.println(" alling this at "+java.time.LocalTime.now());
        }
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
    static class TestFun implements Runnable{
        public void run()
        {
            System.out.println("calling the function ");
        }
    }
    public void testfun(){
        System.out.println("calling this at "+java.time.LocalTime.now());
    }
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, InterruptedException {
        Timer t= new Timer();
        TimerTask task = new TestThread();
        System.out.println("enter the function string which needs to be executed and the millisec after which it needs to be called");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputfun = br.readLine();
        int millisec = Integer.parseInt(br.readLine());
        Method getmethod = Day10.class.getDeclaredMethod(inputfun);
        for(int i=0;i<2;++i)
        {
            getmethod.invoke(new Day10());
            Thread.sleep(millisec);
        }
        Method[] method = Day10.class.getDeclaredMethods();
        for(Method x:method)
        {
            System.out.println(x.getName());
        }
        Method testm = Day10.class.getMethod("testfun");

        testm.invoke(new Day10());
        System.out.println("outputasfd is ");
        t.schedule(task,0,5000); // this will schedule a task for every 5 secs starting right now
    }
}
 */