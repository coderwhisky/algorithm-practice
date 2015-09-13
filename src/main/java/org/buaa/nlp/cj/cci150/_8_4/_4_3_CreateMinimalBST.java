package org.buaa.nlp.cj.cci150._8_4;


/**
 * Created by Administrator on 2015/9/10.
 */
public class _4_3_CreateMinimalBST {
    public BiTreeNode createMinimalBST(int arr[], int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        BiTreeNode n = new BiTreeNode(arr[mid]);
        n.lchild = createMinimalBST(arr, start, mid - 1);
        n.rchild = createMinimalBST(arr, mid + 1, end);
        return n;
    }

    public BiTreeNode createMinimalBST(int arr[]) {
        int n = arr.length;
        return createMinimalBST(arr, 0, n-1);
    }

    public static void main(String[] args) {
        int[] arr =
    }

}
