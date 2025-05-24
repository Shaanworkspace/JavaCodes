package threads;

public class evenThreads  extends  Thread{
    public void run(){
        for(int i =0;i<10;i++){
            try{
                Thread.sleep(5000);
            }catch (Exception e){
                System.out.println("cath block of Thread even");
            }
            if(i %2 ==0){
                System.out.println(i);
                System.out.println("Thread class: " + this.getClass().getSimpleName());
                System.out.println("Thread actual name: " + Thread.currentThread().getName());
            }
        }
    }
}
