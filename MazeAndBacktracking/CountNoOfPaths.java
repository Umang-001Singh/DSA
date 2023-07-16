package MazeAndBacktracking;

public class CountNoOfPaths {
    public static void main(String[] args) {
        int ans = count(3,3);
        System.out.println(ans);
    }

    static int count(int r, int c ){
        if(r==1 || c==1){
            return 1;
        }
        
        //FIRST METHOD 
        // int left = count(r-1, c);
        // int right = count(r,c -1);

        // return left + right;

        //SECOND METHOD
        int ans =0;
        ans = ans + count(r-1,c);
        ans = ans + count(r,c-1);
        return ans;
    }
}
