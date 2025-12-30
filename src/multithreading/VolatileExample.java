package multithreading;
public class VolatileExample {

    private static boolean running = true;
    private static int num=0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (running) {
                // Thread 1 is running
                System.out.println("Thread 1 is running");
                num++;
                try {
                    Thread.sleep(1000); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread 1 has stopped");
           
        });

        Thread t2 = new Thread(() -> {
            try {
            	
                Thread.sleep(5000); // Allow Thread 1 to run for a while
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            running = false; // Stop the running thread
            System.out.println(num);
            System.out.println("Thread 2 has stopped Thread 1");
        });

        t1.start();
        t2.start();

        t1.join();
        System.out.println("t1 join called");
        t2.join();
    }
}
