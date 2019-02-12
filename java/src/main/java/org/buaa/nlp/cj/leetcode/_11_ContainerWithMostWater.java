package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/7/9.
 */
public class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0, right = len-1;
        int maxArea = 0;
        while (left < right) {
            int curArea = 0;
            if (height[left] < height[right]) {
                curArea = height[left] * (right-left);
                maxArea = curArea > maxArea ? curArea : maxArea;
                left++;
            } else {
                curArea = height[right] * (right-left);
                maxArea = curArea > maxArea ? curArea : maxArea;
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        _11_ContainerWithMostWater containerWithMostWater = new _11_ContainerWithMostWater();
        int[] height = {2,4,1,6,9};
        containerWithMostWater.maxArea(height);
    }
}
