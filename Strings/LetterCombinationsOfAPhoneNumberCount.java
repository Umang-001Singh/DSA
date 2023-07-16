package Strings;

public class LetterCombinationsOfAPhoneNumberCount {
    public static void main(String[] args) {
        int ans = CombinationsCount("", "12");
        System.out.println(ans);
    }

    static int CombinationsCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }

        int s=0;
        int e=0;
        int digit = up.charAt(0) - '0'; //WILL CONVERT CHARACTER '2' TO INTEGER VALUE
        if(digit == 1)
        {

        }
        else if(digit == 7)
        {
            s= (digit -2)*3;
            e=(digit -1)*3;
        }
        else if(digit == 8){
            s = (digit -2)*3 +1;
            e = (digit -1)*3;
        }
        else if (digit == 9){
            s = (digit -2)*3 +1;
            e = (digit -1)*3 +1;
        }
        else{
            s=(digit -2)*3;
            e = (digit -1)*3-1;
        }
        int ans=0;
        for (int i = s; i <= e; i++) {
            if(e != 0){
                char ch = (char)('a'+i);
                ans = ans + CombinationsCount(p + ch, up.substring(1));
            }
            else{
                ans = ans + CombinationsCount(p, up.substring(1));
            }
        }
        return ans;
    }
}
