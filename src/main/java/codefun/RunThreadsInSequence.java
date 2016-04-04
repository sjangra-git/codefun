package codefun;

public class RunThreadsInSequence
{

    private static int num=0;    
    
    public static void main(String[] args)
    {
        RunThreadsInSequence obj = new RunThreadsInSequence();
        obj.runThreadsInSequence(obj);
    }
    
    private void runThreadsInSequence(final Object obj)
    {
        Thread t1 = new Thread(new Runnable() {            
            public void run()
            {
                while(true) 
                {
                    if(num == 10) break;
                    
                    if(num % 3 == 0)
                    {
                        System.out.print("T1<<");
                        synchronized(obj)
                        {
                            obj.notifyAll();                            
                        }
                    }
                    else 
                    {
                        try
                        {
                            synchronized(obj)
                            {
                                obj.wait();
                            }                           
                        } catch (InterruptedException e)
                        {
                            System.out.println("Interrupted");
                        }
                    }
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable() {            
            public void run()
            {
                while(true) 
                {
                    if(num == 10) break;
                    
                    if(num % 3 == 1)
                    {
                        System.out.print("T2<<");
                        synchronized(obj)
                        {
                            obj.notifyAll();                            
                        }
                    }
                    else 
                    {
                        try
                        {
                            synchronized(obj)
                            {
                                obj.wait();
                            }                           
                        } catch (InterruptedException e)
                        {
                            System.out.println("Interrupted");
                        }
                    }
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {            
            public void run()
            {
                while(true) 
                {
                    if(num == 10) break;
                    
                    if(num % 3 == 2)
                    {
                        System.out.print("T3<<");
                        synchronized(obj)
                        {
                            obj.notifyAll();                            
                        }
                    }
                    else 
                    {
                        try
                        {
                            synchronized(obj)
                            {
                                obj.wait();
                            }                           
                        } catch (InterruptedException e)
                        {
                            System.out.println("Interrupted");
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        
        // sleep for some time in main thread
        try
        {
            Thread.sleep(4000);
        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
                
        try
        {
            t1.join(2000);
            t2.join(2000);
            t3.join(2000);
        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
