package Arrays;
import java.util.*;

public class GreatestNoofCandies {
    public static void main(String [] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of kids");
        int n=in.nextInt();
        System.out.println("Enter the number of extra candies");
        int e=in.nextInt();
        int [] candies=new int [n];
        System.out.println("Enter the number of candies each kid has");
        for(int i=0;i<candies.length;i++){
            candies[i]=in.nextInt();
        }
        ArrayList result=new ArrayList<>();
        int max=0;
        for(int i=0;i<candies.length;i++){
            if (max < candies[i]) {
                max=candies[i];
            }
            }
        for(int i=0;i<candies.length;i++){
            if(max<=(candies[i]+e)){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }
        System.out.println(result);
    }
}



