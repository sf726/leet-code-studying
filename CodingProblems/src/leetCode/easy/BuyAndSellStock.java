package leetCode.easy;

public final class BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int x =0;
        int buy = Integer.MAX_VALUE;
        int sell = Integer.MIN_VALUE;
        boolean isBuyBeforeSell;
        for (int i = 0; i < prices.length -1; i++) {
            if(buy > x){
                buy = x;
            }
            if(sell < x && buy != Integer.MAX_VALUE){
                sell = x;
            }
        }
        return Math.max(sell - buy, 0);
    }

    public static void main(String[] args) {
       System.out.println(maxProfit(new int[]{1,2,3,4,5}));
    }
}
