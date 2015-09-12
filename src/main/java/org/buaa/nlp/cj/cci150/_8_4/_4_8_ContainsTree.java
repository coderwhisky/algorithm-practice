package org.buaa.nlp.cj.cci150._8_4;

/**
 * 你有两棵非常大的二叉树：T1，有几百万个结点，T2，有几百个结点。设计一个算法，判断T2是否为T1的子树
 * Created by whisky-yonk on 9/12/2015.
 */
public class _4_8_ContainsTree {
    /*
    // ============= method 1 =============start
    如果规模较小，我们可以分别存储先序遍历和中序遍历的字符串，然后原问题转化为字符串包含问题
    如果两种遍历方式都包含的话，则是子树关系，否则不是。
    // ============= method 1 =============start
    */

    // **************** method 2 ************ start
    // this function has something wrong
    public boolean matchTree(BiTreeNode t1, BiTreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        return ((t1.val == t2.val) && matchTree(t1.lchild, t2.lchild)
                && matchTree(t1.rchild, t2.rchild));
    }

    public boolean containsTree(BiTreeNode t1, BiTreeNode t2) {
        if (t2 == null)
            return true;
        if (t1 == null)
            return false;
        if (t1.val == t2.val)
            return matchTree(t1, t2);
        return containsTree(t1.lchild, t2) || containsTree(t1.rchild, t2);
    }
    // **************** method 2 ************ end

    public static void main(String[] args) {

    }
}
