package MultiThreading.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Thread readerThread = new Thread(() -> {
            resource.readers(lock);
        });

        Thread readerThread1= new Thread(() -> {
            resource.readers(lock);
        });

        SharedResource resource1 = new SharedResource();
        Thread writerThread= new Thread(() -> {
            resource1.writer(lock);
        });

        readerThread.start();
        readerThread1.start();
        writerThread.start();
    }
}
