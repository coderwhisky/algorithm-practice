package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/11/5.
 */
public class _121_StockSell {
    public int maxProfit(int[] prices) {
        if (prices.length < 1)
            return 0;
        int low = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - low > max)
                max = prices[i] - low;
            if (low > prices[i])
                low = prices[i];
        }
        return max;
    }
}
