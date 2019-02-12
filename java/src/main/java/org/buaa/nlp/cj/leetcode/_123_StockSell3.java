package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/11/4.
 */
public class _123_StockSell3 {
    public static int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int[] tmp = new int[prices.length];
        int low = prices[0];
        int max = 0;
        tmp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            int tt = prices[i] - low;
            max = tt > max ? tt : max;
            tmp[i] = max;
            low = prices[i] < low ? prices[i] : low;
        }
        int high = prices[prices.length-1];
        max = 0;
        int maxSum = 0;
        for (int j = prices.length-2; j >=0; j--) {
            int tt = high - prices[j];
            max = max < tt ? tt : max;
            tt = tmp[j] + max;
            maxSum = maxSum < tt ? tt : maxSum;
            high = prices[j] > high ? prices[j] : high;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        System.out.println(maxProfit(prices));
    }
}

/*
Best Time to Buy and Sell Stock III
Difficulty: Hard
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Subscribe to see which companies asked this question
 */