package MockTest;

import java.util.ArrayList;
import java.util.HashMap;

public class NinjasSafe {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("2000");
        list.add("1001");
        list.add("1002");
        list.add("3010");
        String result = "2121";
        HashMap<String, String> map = new HashMap<>();
		for(int i = 0;i<list.size();i++){
			map.put(list.get(i), list.get(i));
		}
        HashMap<String, Integer> dp = new HashMap<>();
		int ans = turns(map, result, "0000", dp);
        System.out.println(ans);
    }

    public static int turns(HashMap<String, String> map, String result,String str, HashMap<String, Integer> dp){
		if(str.equals(result)){
			return 1;
		}

		if(map.containsKey(str)){
			return (int)1e9;
		}

        if(dp.containsKey(str)){
            return dp.get(str);
        }
		int min = (int)1e9;
		for(int i = 0;i<4;i++){
			int ans = 0;
			if(str.charAt(i) != result.charAt(i)){
				String temp = str;
                int num = Integer.parseInt(str);
                num = num + (int)Math.pow(10, 3 - i);
                str = Integer.toString(num);

				ans = 1 + turns(map, result,str, dp);
                dp.put(str, ans);
                str = temp;
				min = Math.min(min, ans);
			}
		}

		return min;
	}
}
