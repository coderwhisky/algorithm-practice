package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/11/2.
 */
public class _96_UniqueSeachBiTree {
    // method 1: recursively way +++++++++++++++++++ start
    public static int numTrees1(int n) {
        int[] nums = new int[n+1]; //nums[i]表示i个节点的二叉查找树的数目
        return numTreesRecur(n, nums);
    }

    public static int numTreesRecur(int n, int[] nums) {
        if (nums[n] != 0)
            return nums[n];
        if (n == 0) {
            nums[n] = 1;
            return 1;
        }
        int tmp = n >> 1;
        for (int i = 1; i <= tmp; i++) {
            int left = 0, right = 0;
            if (nums[i-1] != 0) {
                left = nums[i-1];
            } else {
                left = numTreesRecur(i-1, nums);
            }
            if (nums[n-i] != 0) {
                right = nums[n-i];
            } else {
                right = numTreesRecur(n-i, nums);
            }
            nums[n] += left*right;
        }
        // why?????
        nums[n] <<= 1;
        if (n%2 != 0) {
            int val = 0;
            if (nums[tmp] != 0) {
                val = nums[tmp];
            } else {
                val = numTreesRecur(tmp, nums);
            }
            nums[n] += val*val;
        }
        return nums[n];
    }

    // method 1: recursively way +++++++++++++++++++ end


    // method 1: non recursively way +++++++++++++++++++ start
    public static int numTrees2(int n) {
        //num[i]表示i个节点的二叉查找树数目
        int[] nums = new int[n+1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {
            int tmp = i>>1;
            for (int j = 1; j <= tmp; j++) {
                nums[i] += nums[j-1] * nums[i-j];
            }
            nums[i] <<= 1;
            if (i%2 != 0) {
                nums[i] += nums[tmp] * nums[tmp];
            }
        }
        return nums[n];
    }
    // method 1: non recursively way +++++++++++++++++++ start



    public static void main(String[] args) {
        System.out.println(numTrees1(3));
    }
}
