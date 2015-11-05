package org.buaa.nlp.cj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/2.
 */
public class _95_UniqueSeachBiTree2 {
    public List<LeetcodeBiTreeNode> generateTrees(int n) {
        List<LeetcodeBiTreeNode> res = new ArrayList<LeetcodeBiTreeNode>();
//        LeetcodeBiTreeNode[][][] btrees = new LeetcodeBiTreeNode[][][];
        ArrayList<ArrayList<ArrayList<LeetcodeBiTreeNode>>> btrees = new ArrayList<ArrayList<ArrayList<LeetcodeBiTreeNode>>>();
        //为了下面处理btrees[i][j]时 i > j的边界情况
        for (int i = 1; i <= n+1; i++) {
            btrees.get(i).get(i-1).add(null);
        }
        //k表示节点数目
        for (int k = 1; k <= n; k++) {
            //i表示起始节点
            for(int i = 1; i <= n-k+1; i++) {
                //求[i,i+1,...i+k-1]序列对应的所有BST树
                for (int rootval = i; rootval <= i+k-1; rootval++) {
                    //左子树
                    for (int m = 0; m < btrees.get(i).get(rootval-1).size(); m++) {
                        // 右子树
                        for (int l = 0; l < btrees.get(rootval+1).get(k+i-1).size(); l++) {
                            LeetcodeBiTreeNode root = new LeetcodeBiTreeNode(rootval);
                            root.left = btrees.get(i).get(rootval-1).get(m);
                            root.right = btrees.get(rootval+1).get(k+i-1).get(n);
                            btrees.get(i).get(i+k-1).add(root);
                        }
                    }
                }
            }
        }
        return btrees.get(1).get(n);
    }
}
