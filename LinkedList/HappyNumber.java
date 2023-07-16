package LinkedList;

public class HappyNumber {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do{
            slow = isSquare(slow);
            fast = isSquare(isSquare(fast));
            if(slow == 1){
                return true;
            }
        }while(fast!=slow);
        
        return false;
    }

    public static int isSquare(int num){
        int sum = 0;
        while(num>0){
            int rem = num % 10;
            sum +=rem * rem;
            num /=10;
        }
        return sum;
    }
}
