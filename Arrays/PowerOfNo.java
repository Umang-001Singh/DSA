package Arrays;

public class PowerOfNo {
    public static void main(String [] args){
        int power=5;
        int base=3;
        System.out.println(power(power,base));
    }

    static int power(int p,int b){
        int i=0;
        int ans=1;
        while(p>0){
            int last=p&1;
            if(last!=0){
                ans=ans*(int)(Math.pow(b,Math.pow(2,i)));
            }
            i++;
            p=p>>1;
        }
        return ans;
    }
}
