package MultiThreading.producer_consumer_shared_buffer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {

    private Queue<Integer> sharedBuffer;
    private int sharedBufferSize;

    public SharedBuffer(int sharedBufferSize){
        sharedBuffer = new LinkedList<>();
        this.sharedBufferSize = sharedBufferSize;
    }

    public synchronized void produce(int item){
        System.out.println("Inside produce method.");
        while(sharedBuffer.size() == sharedBufferSize){
            System.out.println("sharedBufferSize full calling Wait method for all producer Threads");
            try{
                wait();
            } catch (Exception e){
                //Exception goes here;
            }
        }
        sharedBuffer.add(item);
        System.out.println("Item: " + item + " added calling NotifyAll method for all consumer Threads");
        notifyAll();
    }
    public synchronized void consume(){
        System.out.println("Inside consumer method.");
        while(sharedBuffer.isEmpty()){
            System.out.println("sharedBufferSize empty calling Wait method for all consumer Threads");
            try{
                wait();
            } catch (Exception e){
                //Exception goes here;
            }
        }
        int item = sharedBuffer.poll();
        System.out.println("Consumed Item: " + item + "  calling NotifyAll method for all producer Threads");
        notifyAll();
    }
}
