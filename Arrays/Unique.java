package Arrays;

public class Unique {
    public static void main(String [] args){
        int [] arr={2,3,3,4,2,6,4};
        System.out.println(isUnique(arr));


    }

    static int isUnique(int [] arr){
        int unique=0;
        for(int i:arr){
            unique^=i;
        }
        return unique;
    }
}
