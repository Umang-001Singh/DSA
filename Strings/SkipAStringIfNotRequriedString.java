package Strings;

public class SkipAStringIfNotRequriedString {
    public static void main(String[] args) {
        String str = "bacappeasecdha";
        String ans= skipStr(str);
        System.out.println(ans);
    }

    public static String skipStr(String up){
        if(up.isEmpty()){
            return "";
        }

        if(up.startsWith("app") && !up.startsWith("apple")){
            return skipStr(up.substring(3));
        }
        else{
            return up.charAt(0) + skipStr(up.substring(1));
        }
    }
}
