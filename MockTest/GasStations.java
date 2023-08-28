package MockTest;

public class GasStations {
    public static void main(String[] args) {
        int[] gas = {95, 16, 91, 18, 65};
        int[] cost = {39, 59, 60, 76, 9};
        for(int i = 0;i<gas.length;i++){
            if(distance(gas, cost, i, 0, 0)){
                System.out.println(i);
                break;
            }
        }
        System.out.println(-1);
    }

    public static boolean distance(int[] gas, int[] cost, int i, int prev, int count){
		if(gas[i] + prev < cost[i]){
			return false;
		}

		if(count == gas.length){
			return true;
		}
		boolean ans = false;
		// if(gas[i] + prev >= cost[i]){
			int diff = gas[i] + prev - cost[i];
			System.out.println(diff);
			ans = distance(gas , cost, (i+1)%gas.length, diff, ++count);
		// }
		System.out.println(ans);

		return ans;
	}
}
