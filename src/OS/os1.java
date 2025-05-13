package OS;


public class os1 {
    public static void main(String[] args) {
        int[] at = {0,1,7,16};
        int[] BT = {4,20,6,2};
        int[] bt = {4,24,3,32};

        int[] wt = new int[at.length];
        int[] tat = new int[at.length];
        wt[0] = at[0];
        tat[0] = BT[0]+wt[0];
        for(int i = 1 ; i<at.length;i++){
            wt[i] = bt[i-1]-at[i];
            tat[i] = wt[i]+BT[i];
        }
        for(int n : wt){
            System.out.println(n);
        }
        System.out.println("-----------------------");
        for(int p : tat){
            System.out.println(p);
        }

    }
}
