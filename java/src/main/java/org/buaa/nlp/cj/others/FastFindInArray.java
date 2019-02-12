package org.buaa.nlp.cj.others;

/**
 * 来源：http://blog.csdn.net/morewindows/article/details/10645269
 *
 * 有这样一个数组A，大小为n，相邻元素差的绝对值都是1。
 * 如：A={4,5,6,5,6,7,8,9,10,9}。
 * 现在，给定A和目标整数t，请找到t在A中的位置。除了依次遍历，还有更好的方法么？
 * Created by I320592 on 8/7/2015.
 */
public class FastFindInArray {
    public int fastFind(int[] array, int target) {
        int i = 0;
        int finalP = i;
        while (target != array[i] && i < array.length) {
            i = i + (target - array[i]);
            if (target == array[i]) {
                finalP = i;
                break;
            }
        }
        return finalP;
    }

    public int fastFind2(int[] array, int target) {
        int len = array.length;
        int curIndex = 0;

        while (curIndex < len) {
            int dif = Math.abs(target - array[curIndex]);
            if (target == array[curIndex]) {
                return curIndex;
            }
            curIndex += dif;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastFindInArray fastFindInArray = new FastFindInArray();
        int[] array = {4,5,6,5,6,7,8,9,10,9};
        int target = 5;
        int result = fastFindInArray.fastFind2(array, target);
        System.out.println(result);
    }
}
