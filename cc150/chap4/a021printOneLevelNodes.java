import java.util.*;

/*
递归层次遍历
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class TreeLevel { 
    ListNode ln = new ListNode(-1);
    ListNode p = ln;
 
    public ListNode getTreeLevel(TreeNode root, int dep) {
        // write code here
        if (root == null || dep <= 0)
            return null;
        if (dep == 1) {
            p.next = new ListNode(root.val);
            p = p.next;
        } else {
            getTreeLevel(root.left, dep - 1);
            getTreeLevel(root.right, dep - 1);
        }
        return ln.next;
    } 
}
