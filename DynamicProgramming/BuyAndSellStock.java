package DynamicProgramming;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int []prices = {7, 6, 4, 3, 1};
        int ans = Profit(prices);
        System.out.println(ans);
    }

    public static int Profit(int []prices){
        int min = prices[0];
        int profit = 0;
        for(int i = 1;i<prices.length;i++){
            int temp = prices[i] - min;
            profit = Math.max(profit, temp);
            min = Math.min(prices[i], min);
        }

        return profit;
    }
}
