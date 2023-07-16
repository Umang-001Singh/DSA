package Strings;

public class SubSeq {
    public static void main(String[] args) {
        subseq("abc", "");
    }

    public static void subseq(String up,String p){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch=up.charAt(0);
        subseq(up.substring(1),p+ch);
        subseq(up.substring(1),p);
    }
}
