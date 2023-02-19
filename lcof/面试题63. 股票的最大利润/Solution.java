class Solution {

    /**
     * 动态规划
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    /**
     * 双指针移动
     * 找最小最大值
     * 
     * @param prices
     * @return
     */

     

    /**
     * 动态规划
     *   准备一变量记录最大差值，初始化为 0；一变量记录最小值，初始化为无限大。
     *  遍历数组，计算当前遍历元素与最小值的差值，并更新最大差值；再更新最小值。
     * 
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < len; ++i) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }



}