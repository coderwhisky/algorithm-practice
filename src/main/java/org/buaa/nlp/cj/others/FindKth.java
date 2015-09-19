package org.buaa.nlp.cj.others;

/**
 * Created by Administrator on 2015/9/18.
 */
public class FindKth {

    public int findKth(int[] a, int startA, int endA, int[] b, int startB, int endB, int k) {
        if (k < 1 || k > a.length+b.length)
            return Integer.MIN_VALUE;
        if (k == 1) {
            if (a[startA] <= b[startB])
                return a[startA];
            else
                return b[startB];
        }

        if (endA < startA)
            return b[startB + k - 1];
        if (endB < startB)
            return a[startA + k - 1];

        int alen = endA - startA + 1;
        int blen = endB - startB + 1;

        if (alen > blen)
            return findKth(b, startB, endB, a, startA, endA, k);

        // 此处要求a元素个数小于b的元素个数
        // 考虑a中的前as个数，和b中的前bs个数
        int as = 0;
        int bs = 0;
        if (alen < k/2) {
            as = endA - startA + 1;
        } else {
            as = k/2;
        }
        bs = k - bs;

        int ap = startA + as - 1;
        int bp = startB + bs - 1;

        if (a[ap] == b[bp])
            return a[ap];
        else if (a[ap] > b[bp]) {
            return findKth(a,startA, ap, b, bp + 1, endB, k-bs);
        } else {
            return findKth(a, ap+1, endA, b, startB, bp, k-as);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,10,15,20,23,26};
        int[] b = {2,3,16,19,26,29};
        int result = new FindKth().findKth(a, 0, a.length - 1, b, 0, b.length - 1, 4);
        System.out.println(result);
    }
}
