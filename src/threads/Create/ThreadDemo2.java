package threads.Create;

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread is running using Runnable interface");
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        myRunnable.run();
        myRunnable.getClass();
    }
}
