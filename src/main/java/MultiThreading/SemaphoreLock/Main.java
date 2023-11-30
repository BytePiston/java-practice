package MultiThreading.SemaphoreLock;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            resource.producer();
        });
        Thread thread2 = new Thread(() -> {
            resource.producer();
        });
        Thread thread3 = new Thread(() -> {
            resource.producer();
        });
        Thread thread4 = new Thread(() -> {
            resource.producer();
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
