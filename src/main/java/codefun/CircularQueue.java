package codefun;

import java.util.Arrays;

public class CircularQueue
{

    private int size;
    private int[] array;
    private int startPos;
    private int endPos;
    
    public CircularQueue(int size)
    {
        this.size = size;
        array = new int[size];
        startPos = -1;
        endPos = -1;
    }
    
    public void add(int data) throws Exception
    {
        // check is queue is full
        if ((endPos > startPos) && (endPos-startPos+1 == size))
        {
            throw new Exception("Queue Full");
        }
        else if ((endPos < startPos) && ((size - startPos + endPos + 1) == size))
        {
            throw new Exception("Queue Full");
        }
        
        if(startPos == -1)
        {
            startPos = 0;
        }
        endPos = (endPos + 1) % size;
        array[endPos] = data;
        System.out.println("Successfully added: "+ data);
        System.out.println(Arrays.toString(array));
        notifyAll();
    }
    
    // Remove from beginning of the queue
    public int remove() throws Exception
    {
        int returnVal;
        
        // check if queue is already empty
        if(startPos == -1 && endPos == -1)
        {
            throw new Exception("Queue Empty");
        }
        
        returnVal = array[startPos];
        array[startPos] = 0;
        
        // In case of only single element, move the pointers to -1 value
        if(startPos == endPos)
        {
            startPos = -1;
            endPos = -1;
        }
        else 
        {
            // otherwise just increment the startPos to next place
            startPos = (startPos + 1) % size;
        }
        
        System.out.println("Successfully removed: "+ returnVal);
        System.out.println(Arrays.toString(array));
        return returnVal;        
    }
    
    public static void main(String[] args)
    {
        CircularQueue queue = new CircularQueue(4);
        for(int i = 1; i< 6; i++)
        {
            try
            {
                queue.add(i);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        
        for(int i = 1; i< 6; i++)
        {
            try
            {
                queue.remove();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
