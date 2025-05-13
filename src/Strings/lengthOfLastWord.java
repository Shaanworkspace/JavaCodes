package Strings;

public class lengthOfLastWord {
    public static int lengthOfLastWordFunction(String s) {
        if(s.isEmpty()) return 0;
        s=s.replaceAll("\\s+$","");
        System.out.println(s);
        int length = 0;
        for (char c : s.toCharArray()) {
            if(c != ' '){
                length++;
            }else{
                length=0;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWordFunction("   fly me   to   the moon  "));
    }
}
