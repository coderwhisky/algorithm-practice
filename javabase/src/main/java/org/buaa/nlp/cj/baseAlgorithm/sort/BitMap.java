package org.buaa.nlp.cj.baseAlgorithm.sort;

import java.util.BitSet;

/**
 * Created by I320592 on 7/31/2015.
 */
public class BitMap {
    private final int BITS_PER_WORD = 32;
    private final int SHIFT = 5;
    private final int MASK = 31;
    private final int N = 100;

    private int[] bitMap = new int[1 + N/BITS_PER_WORD];

    /**
     * 解析本例中的void set(int i) {        a[i>>SHIFT] |=  (1<<(i & MASK)); }

     1.i>>SHIFT：
     其中SHIFT=5，即i右移5为，2^5=32,相当于i/32，即求出十进制i对应在数组a中的下标。比如i=20，通过i>>SHIFT=20>>5=0 可求得i=20的下标为0；

     2.i & MASK：
     其中MASK=0X1F,十六进制转化为十进制为31，二进制为0001 1111，i&（0001 1111）相当于保留i的后5位。

     比如i=23，二进制为：0001 0111，那么
     0001 0111
     &    0001 1111 = 0001 0111 十进制为：23
     比如i=83，二进制为：0000 0000 0101 0011，那么
     0000 0000 0101 0011
     &   0000 0000 0001 0000 = 0000 0000 0001 0011 十进制为：19

     i & MASK相当于i%32。

     3.1<<(i & MASK)
     相当于把1左移 (i & MASK)位。
     比如(i & MASK)=20，那么i<<20就相当于：
     0000 0000 0000 0000 0000 0000 0000 0001 >>20
     =0000 0000 0000 1000 0000 0000 0000 0000

     4.void set(int i) {        a[i>>SHIFT] |=  (1<<(i & MASK)); }等价于：
     void set(int i)
     {
     a[i/32] |= (1<<(i%32));
     }
     * 置位操作
     * m mod n 运算，当n = 2的X次幂的时候,m mod n = m&(n-1)
     * @param val
     */
    public void setVal(int val) {
        bitMap[val >> SHIFT] = bitMap[val >> SHIFT] | (1 << (val & MASK));
    }

    /**
     * 测试位操作
     * @param val
     * @return
     */
    public int testVal(int val) {
        return (bitMap[val >> SHIFT] & (1 << (val & MASK))) >>> (val & MASK);
    }

    /**
     * 清除位操作
     * @param val
     */
    public void clrVal(int val) {
        bitMap[val >> SHIFT] &= ~(1 << (val & MASK));
    }



    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(126 & (1 << (31 & 31))));
        BitMap bitMap = new BitMap();
        int[] a = {1,2,3,4,5,6,31,32,33,99};
        for (int i = 0; i < a.length; i ++) {
            bitMap.setVal(a[i]);
        }
        for (int i = 0; i < bitMap.bitMap.length; i++) {
            System.out.println(bitMap.bitMap[i] + ":" +Integer.toBinaryString(bitMap.bitMap[i]));
        }
        for (int i = 0; i < a.length; i ++) {
            System.out.println(a[i] + ":" + bitMap.testVal(a[i]));
        }

        System.out.println(44 + ":" + bitMap.testVal(44));

//        int testR = bitMap.testVal(5);
//        System.out.println(testR);
    }
}