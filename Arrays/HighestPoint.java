package Arrays;

public class HighestPoint {
    public int largestAltitude(int[] gain) {

        int [] altitude=new int[gain.length+1];
        altitude[0]=0;
        for(int i=1;i<=gain.length;i++){
            altitude[i]=gain[i-1]+altitude[i-1];
        }
        int highest=Integer.MIN_VALUE;
        for(int j=0;j<altitude.length;j++){
            if(highest<altitude[j]){
                highest=altitude[j];
            }
        }
    return highest;
    }
}
