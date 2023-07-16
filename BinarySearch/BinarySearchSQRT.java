package BinarySearch;

public class BinarySearchSQRT {
    public static void main(String [] args){
        int n=10;
        int p=3;
        System.out.println(sqrt(n,p));

    }

    static double sqrt(int n, int p){
        int s=0;
        int e=n;
        double root=0;
        int mid=0;
        while(s<=e){
            mid=s+(e-s)/2;
            if(mid*mid==n){
                return mid;
            }
            else if(mid*mid>n){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        root=mid-1;
        double incr=0.1;
        for(int i=0;i<p;i++){
            while(root*root<=n){
                root+=incr;
            }
            root-=incr;
            incr/=10;
        }
        return root;
    }
}
