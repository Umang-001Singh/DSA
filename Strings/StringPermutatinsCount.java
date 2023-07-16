package Strings;

public class StringPermutatinsCount {
    public static void main(String[] args) {
        int ans = PermutationsCount("", "abc");
        System.out.println(ans);
    }

    static int PermutationsCount(String p, String up)
    {
        if(up.isEmpty()){
            return 1;
        }

        int count=0;
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + PermutationsCount(f + ch + s, up.substring(1));
        }
        return count;
    }
}
