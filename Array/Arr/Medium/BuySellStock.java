public class BuySellStock {
    public static int optimized(int prices[]) {
        int maxProfit = 0;
        int buyingPrice = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++) {
            if(buyingPrice < prices[i]) {
                profit =  prices[i] - buyingPrice;
            }
            else {
                buyingPrice = prices[i];
            }
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit > 0 ? maxProfit : 0;
    }

    
    public static void main(String args[]) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(optimized(prices));

    }
}