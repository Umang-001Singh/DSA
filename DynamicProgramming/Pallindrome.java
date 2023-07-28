package DynamicProgramming;

public class Pallindrome {
    public static void main(String[] args) {
        String text = "aacaa";
        System.out.println(ispallindrome(text));
    }

    public static boolean ispallindrome(String text){
        if(text.length()==1){
            return true;
        }
        

        int j = text.length()-1;
        for(int i = 0;i<text.length();i++){
            if(text.charAt(j) != text.charAt(i)){
                return false;
            }
            j--;
        }
        return true;
    }
}
