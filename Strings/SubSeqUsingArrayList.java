package Strings;

import java.util.ArrayList;

public class SubSeqUsingArrayList {
 public static void main(String[] args) {
    String str = "abc";
    ArrayList<String> ans = new ArrayList<>();
    ans = SubSeq(str, "");
    System.out.println(ans);
 }

 public static ArrayList<String> SubSeq(String up, String p){
    ArrayList<String> ans = new ArrayList<>();
    
    if(up.isEmpty()){
        ans.add(p);
        return ans;
    }

    char ch = up.charAt(0);
    ArrayList<String> left = SubSeq(up.substring(1), p + ch);
    ArrayList<String> right = SubSeq(up.substring(1), p);

    left.addAll(right);
    return left;
 }   
}
