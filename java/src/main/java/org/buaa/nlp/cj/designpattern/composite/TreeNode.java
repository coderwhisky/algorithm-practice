package org.buaa.nlp.cj.designpattern.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Administrator on 2015/5/18.
 */
public class TreeNode {
    private String name;
    private TreeNode parent;
    private Vector<TreeNode> children = new Vector<TreeNode>();

    public TreeNode(String name) {
        this.name = name;
    }

    //��Ӻ��ӽڵ�
    public void add(TreeNode node){
        children.add(node);
    }

    //ɾ�����ӽڵ�
    public void remove(TreeNode node){
        children.remove(node);
    }

    public String getName() {
        return name;
    }

    //ȡ�ú��ӽڵ�
    public Enumeration<TreeNode> getChildren(){
        return children.elements();
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
