package Strings;

public class SkipACharacter {
    public static void main(String[] args) {
        String str = "baccadah";
        System.out.println(skip(str));
    }

    public static String skip(String up){
        if(up.isEmpty()){
            return "";
        }

        if(up.charAt(0)=='a'){
            return skip(up.substring(1));
        }
        else{
            return up.charAt(0)+skip(up.substring(1));
        }
    }
}
