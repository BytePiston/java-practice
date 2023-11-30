package MultiThreading.producer_consumer_shared_buffer;

public class Main {
    public static void main(String[] args) {
        SharedBuffer sharedBufferObj = new SharedBuffer(3);
        Thread producerThread = new Thread(() -> {
            try{
                Thread.sleep(1000);
                for(int i=1; i<=6; i++){
                    sharedBufferObj.produce(i);
                }
            } catch (Exception e){
                //Exception goes here.
            }
        });

        Thread consumerThread = new Thread(() -> {
            try{
                for(int i=1; i<=6; i++){
                    sharedBufferObj.consume();
                }
            } catch (Exception e){
                //Exception goes here.
            }

        });
        producerThread.start();
        consumerThread.start();
    }
}
