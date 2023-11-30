package MultiThreading.StampedLock.ReadWriteLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    boolean isAvailable = false;
    StampedLock lock = new StampedLock();

    public void produce() {
        long stamp = lock.readLock();
        try {
            System.out.println("Read Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(6000);
        } catch (Exception e) {
            //Exception.
        } finally {
            System.out.println("Read Lock release by: " + Thread.currentThread().getName());
            lock.unlockRead(stamp);
        }
    }

    public void consume() {
        long stamp = lock.writeLock();
        try {
            System.out.println("Write Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception e) {
            //Exception.
        } finally {
            System.out.println("Write Lock release by: " + Thread.currentThread().getName());
            lock.unlockWrite(stamp);
        }
    }
}
