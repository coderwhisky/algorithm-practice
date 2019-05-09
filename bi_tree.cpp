/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
* File Name : bi_tree.cpp
* Purpose :
* Creation Date : 2019-05-09 15:37:26
* Last Modified : 2019-05-09 17:01:33
* Created By : chenjiang
* Modified By : chenjiang
_._._._._._._._._._._._._._._._._._._._._.*/


class Node {
    int val;
    Node left;
    Node right;
    Node(int x) {val = x;}
};


vector<int> preorder(Node root) {
    vector<int> res;
    if (root == NULL) {
        return res;
    }
    stack<int> stk;
    Node cur = root;
    // stk.push(root);
    while (cur != NULL || !stack.empty()) {
        if (cur != NULL) {
            res.append(cur.val);
            stk.push(cur);
            cur = cur.left;
        } else {
            cur = cur.pop();
            cur = cur.right;
        }
        
    }
    return res;
}


vector<int> inorder(Node root) {
    vector<int> res;
    if (root == NULL) {
        return res;
    }
    stack<int> stk;
    Node cur = root;
    while (cur != NULL || !stk.empty()) {
        if (cur != NULL) {
            stk.push(cur);
            cur = cur.left;
        } else {
            cur = stk.pop();
            res.append(cur.val);
            cur = cur.right;
        }
    }
}

vector<int> postorder(Node root) {
    vector<int> res;
    if (root == NULL) { 
        return res;
    }
    Node cur = root;
    Node visited;
    stack<Node> stk;
    while (cur != NULL || !stk.empty()) {
        if (cur != NULL) {
            stk.push(cur);
            cur = cur.left;
        } else {
            cur = stk.peek();
            if (cur.right != NULL && cur != visited) {
                cur = cur.right;
            } else {
                res.add(cur.val);
                visited = cur;
                stk.pop();
                cur = NULL;
            }
        }
    }

}




