package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/11/4.
 */
public class _122_StockSell2 {
    // ++++++++++ method 1 ++++++++++++++ start
    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int down = 0, downIdx = 0, up = 0, upIdx = 0;
        int sum = 0;
        while (downIdx < prices.length-1 && upIdx < prices.length - 1) {
            while (downIdx < prices.length - 1 && prices[downIdx] >= prices[downIdx+1]) {
                downIdx++;
            }
            upIdx = downIdx;
            while (upIdx < prices.length - 1 && prices[upIdx] <= prices[upIdx+1]) {
                upIdx++;
            }
            if (upIdx > downIdx) {
                sum += prices[upIdx] - prices[downIdx];
            }
            downIdx = upIdx;
        }
        return sum;
    }
    // ++++++++++ method 1 ++++++++++++++ end

    // ++++++++++ method 2 ++++++++++++++ start
    public static int maxProfit2(int[] prices) {
        if (prices.length < 1)
            return 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                max += prices[i]-prices[i-1];
            }
        }
        return max;
    }
    // ++++++++++ method 2 ++++++++++++++ end
    public static void main(String[] args) {
        int[] prices = {1, 2};
        System.out.println(maxProfit(prices));
    }
}

/*
Best Time to Buy and Sell Stock II
Difficulty: Medium
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Subscribe to see which companies asked this question
 */