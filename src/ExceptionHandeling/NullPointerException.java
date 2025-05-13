package ExceptionHandeling;

public class NullPointerException {
    public static void main(String[] args) {
        String s = null;
        try{
            System.out.println(s.length()+" " +s.toLowerCase());
        }catch (java.lang.NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
