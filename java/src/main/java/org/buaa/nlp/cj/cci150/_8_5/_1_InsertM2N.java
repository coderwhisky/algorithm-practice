package org.buaa.nlp.cj.cci150._8_5;

/**
 * Created by whisky-yonk on 8/16/2015.
 */
public class _1_InsertM2N {
    /**
     * 来源：
     *
     * 将M插入到N中第j到第i位
     *
     * 步骤：
     * 1.将N中从j到i之间的位清零
     * 2.对M执行移位操作，与j和i之间的位对齐
     * 3.合并M与N
     * 其中步骤1最棘手，我们将先创建掩码的左半部分，然后再创建掩码的右半部分
     *
     * 实例：i = 2, j = 4.掩码将为11100011
     * @param n
     * @param m
     * @param i
     * @param j
     * @return
     */
    int updateBits(int n, int m, int i, int j) {
        System.out.println("origin n: " + Integer.toBinaryString(n));
        System.out.println("origin m: " + Integer.toBinaryString(m));

        int allOnes = ~0;
        // 在位置j之前的位均为1，其余为0， left = 1110000
        int left = allOnes << (j+1);
        System.out.println("left mask: " + Integer.toBinaryString(left));
        // 在位置i之后的均为1，right = 00000011
        int right = ((allOnes << i) - 1);
        System.out.println("right mask: " + Integer.toBinaryString(right));
        // 除i到j的位为0， 其余位均为1.mask = 11100011
        int mask = left | right;
        System.out.println("maskJ: " + Integer.toBinaryString(mask));

        // n对应为清0，m移位
        int n_cleared = n & mask;
        int m_shifted = m << i;

        return n_cleared | m_shifted;
    }
    public static void main(String[] args) {
        _1_InsertM2N insertM2N = new _1_InsertM2N();
        int result = insertM2N.updateBits(127,4,2,7);
        System.out.println("result : " + Integer.toBinaryString(result));

    }
}
