package threads;

public class oddThreads extends Thread{
    public void run(){
        for(int i =0;i<10;i++){
            try{
                Thread.sleep(2000);
            }catch (Exception e ){
                System.out.println("Catch block of ODD");
            }
            if(i %2 !=0){
                System.out.println(i);
                System.out.println(getName());
            }
        }
    }
}
