package org.buaa.nlp.cj.cci150._8_4;

import org.buaa.nlp.cj.Utils.BiTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一颗二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一颗树的深度为D，则会创建出D个链表）
 * Created by Administrator on 2015/9/11.
 */
public class _4_4_TreeToLevelList {
    // ================ method 1 start: ====================

    /**
     * 深度优先遍历，前序遍历
     * @param root
     * @param lists
     * @param level
     */
    public void createLevelLinkedList(BiTreeNode root, ArrayList<LinkedList<BiTreeNode>> lists, int level) {
        if (root == null) {
            return;
        }
        LinkedList<BiTreeNode> list = null;
        // 该层不在链表中
        if (lists.size() == level) {
            list = new LinkedList<BiTreeNode>();
            /* 以中序遍历所有层级，因此，若这是第一次访问第i层，则表示我们已经访问过第0到底i-1层。
            *  因此我们可以安全地将这一层加到链表的末端
            * */
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        list.add(root);
        createLevelLinkedList(root.lchild, lists, level+1);
        createLevelLinkedList(root.rchild, lists, level+1);
    }

    public ArrayList<LinkedList<BiTreeNode>> createLevelLinkedList(BiTreeNode root) {
        ArrayList<LinkedList<BiTreeNode>> lists = new ArrayList<LinkedList<BiTreeNode>>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    // ================ method 1 end: ====================

    // ********************* method 2 start: ***************************
    public ArrayList<LinkedList<BiTreeNode>> createLevelLinkedList2(BiTreeNode root) {
        ArrayList<LinkedList<BiTreeNode>> result = new ArrayList<LinkedList<BiTreeNode>>();
        LinkedList<BiTreeNode> current = new LinkedList<BiTreeNode>();
        if (root != null) {
            current.add(root);
        }

        while (current.size() > 0) {
            result.add(current);
            LinkedList<BiTreeNode> parents = current;
            current = new LinkedList<BiTreeNode>();
            for (BiTreeNode parent : parents) {
                // 访问子节点
                if (parent.lchild != null)
                    current.add(parent.lchild);
                if (parent.rchild != null)
                    current.add(parent.rchild);
            }
        }

        return result;
    }
    // ********************* method 2 end : ***************************
}
