package Arrays;

public class IthBitOfANo {
    public static void main(String [] args){
        int num= 166;
        System.out.println(ithBit(num,5));
    }

    static int  ithBit(int num, int bit){
        int  num1=(int) Math.pow(10,bit-1);
        int  ans=0;
        ans=num1&num;

        return ans/(10^4);
    }
}
