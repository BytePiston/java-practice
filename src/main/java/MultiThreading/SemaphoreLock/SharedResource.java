package MultiThreading.SemaphoreLock;

import java.util.concurrent.Semaphore;

public class SharedResource {

    boolean isAvailable = false;
    Semaphore lock = new Semaphore(2);

    public void producer() {
        try {
            lock.acquire();
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (Exception e) {
            //Exception.
        } finally {
            System.out.println("Lock release by: " + Thread.currentThread().getName());
            lock.release();
        }
    }
}
