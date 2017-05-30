package codefun;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class BoundedBufferProblem {
	  
	  private static final int BUFFER_SIZE=3;
	  // buffer of size 3
	  private int[] buffer = new int[BUFFER_SIZE];
	  private int start = -1;
	  private int end = -1;
	  
	  public BoundedBufferProblem() {
		  for(int i = 0; i< BUFFER_SIZE; i++)
			  buffer[i] = -1;
	}
	  // write to buffer
	  public synchronized void write(int data) {
		  System.out.println("Start write...");
	    // check if queue already full
	    if((start<end && end-start+1 == BUFFER_SIZE) ||
	    	(start>end && (end == start-1))) {
	    	// blocking wait
	    	try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Write thread woken");
			}
	    }
	    
	    end = (end + 1) % BUFFER_SIZE;
	    
	    // write at end & move end
	    buffer[end] = data;     
	    
	    if(start == -1)
	    	start = 0;   
	    
	    System.out.println("After writing " + data + " " +  Arrays.toString(buffer));
	    // notify all threads that data is now available
	    notifyAll();   
	    System.out.println("End write...");
	  }
	  
	  // read from buffer
	  public synchronized int read() {
		  System.out.println("Start read...");
	    // check if empty then block
	    if(start == end && (start == -1)) {
	    	try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Read thread woken");
			}
	    }
	    
	    final int returnVal = buffer[start];
	    buffer[start] = -1;
	    System.out.println("After reading " + returnVal + " " +  Arrays.toString(buffer));
	    
	    start = (start + 1) % BUFFER_SIZE;
	    if(buffer[start] == -1) {
	    	start = -1;
	    	end = -1;
	    }
	    
	    
	    notifyAll();
	    System.out.println("End read...");
	    return returnVal;
	  }

	  public static void main(String[] args) {
		  final BoundedBufferProblem buffer = new BoundedBufferProblem();
		  
		  Runnable producer = new Runnable() {			
			public void run() {
				Random r = new Random();
				int Low = 1;
				int High = 3;
				int written = r.nextInt(High-Low) + Low;
				buffer.write(written);
//				System.out.println("Write: "+ written);				
			}
		};
		
		  Runnable consumer = new Runnable() {			
			public void run() {
				buffer.read();
//				System.out.println("Read: " + buffer.read());				
			}
		};

		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		for(int i = 1; i< 20; i++) {
			executor.execute(consumer);
			executor.execute(producer);
		}
		
		executor.shutdown();
		try {
			executor.awaitTermination(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	  }
} 
