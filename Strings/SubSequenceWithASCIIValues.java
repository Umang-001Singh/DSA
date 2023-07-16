package Strings;

import java.util.ArrayList;



public class SubSequenceWithASCIIValues {
    public static void main(String[] args) {
        System.out.println(SubSeq("abc", ""));
    }

    public static ArrayList<String> SubSeq(String up, String p){
        if(up.isEmpty()){
            ArrayList<String> first = new ArrayList<>();
            first.add(p);
            return first;
        }

        char ch = up.charAt(0);

        ArrayList<String> first = SubSeq(up.substring(1), p + ch);
        ArrayList<String> second = SubSeq(up.substring(1), p);
        ArrayList<String> third = SubSeq(up.substring(1), p + (ch+0));

        first.addAll(second);
        first.addAll(third);
            
        return first;
    }
}
