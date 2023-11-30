package MultiThreading.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    int currentValue = 0;
    public void readers(ReadWriteLock lock){
        try{
            lock.readLock().lock();
            System.out.println("Read Lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println("Current value is: " +currentValue);
        } catch (Exception e){
            //Exception.
        } finally {
            System.out.println("Read Lock released by: " + Thread.currentThread().getName());
            lock.readLock().unlock();
        }
    }

    public void writer(ReadWriteLock lock){
        try{
            lock.writeLock().lock();
            System.out.println("Write Lock acquired by: " + Thread.currentThread().getName());
            ++currentValue;
            System.out.println("Current value is: " +currentValue);
        } catch (Exception e){
            //Exception.
        } finally {
            System.out.println("Write Lock released by: " + Thread.currentThread().getName());
            lock.writeLock().unlock();
        }
    }
}
