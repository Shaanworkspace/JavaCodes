package Recursion;

public class PreInPost {
    private static void pip(int n ){
        if(n==0) return;
        System.out.println("Pre : " + n);
        pip(n-1);

        System.out.println("In : " + n);

        pip(n-1);
        System.out.println("Post : " + n);
    }
    public static void main(String[] args) {
        pip(2);
    }
}
