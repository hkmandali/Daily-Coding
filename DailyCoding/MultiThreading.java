package DailyCoding;
// taken through gfg , start is a function of Thread class and it needs to be called to create new threads , so we need to create an object of thread type either through inheritance or directly
// calling run directly wont spawn new threads
class MultithreadingDemo extends Thread
{
    public void run()
    {
        try
        {
            // Displaying the thread that is running
            System.out.println ("Thread " +
                    Thread.currentThread().getId() +
                    " is running");

        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
    }
}

// Main Class
class Multithreading
{
    public static void main(String[] args)
    {
        int n = 8; // Number of threads
        for (int i=0; i<8; i++)
        {
            //Thread object = new Thread(new MultithreadingDemo());
            MultithreadingDemo object = new MultithreadingDemo();
            object.start();
        }
    }
}
