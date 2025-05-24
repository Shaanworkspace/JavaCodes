package threads;

public class Main {
    public static void main(String[] args) {
        evenThreads evenThreads = new evenThreads();
        oddThreads oddThreads = new oddThreads();
        evenThreads.run();
        oddThreads.run();
        int[] arr = {1,2,3,4};
        for(int i : arr){
            System.out.println(i);
        }
    }
}
