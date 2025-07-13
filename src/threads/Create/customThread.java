package threads.Create;

class custThread extends Thread{
    public void run(){
        try {
            System.out.println("🟢 State: RUNNING");
            Thread.sleep(1000);  // Goes into TIMED_WAITING
            System.out.println("🟡 Back to RUNNING after sleep");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }
}
public class customThread {
    public static void main(String[] args) {
        custThread t = new custThread();
        // NEW
        System.out.println("🔵 State: NEW → " + t.getState());

        // RUNNABLE
        t.start();
        System.out.println("🟡 State: After start() → " + t.getState());


        try {
            Thread.sleep(200);  // Main thread sleeps to let t go into RUNNING or WAITING
            System.out.println("🔄 State during sleep (maybe TIMED_WAITING) → " + t.getState());

            t.join(); // Wait for t to die
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }


        // TERMINATED
        System.out.println("🔴 State: After completion → " + t.getState());
    }
}
