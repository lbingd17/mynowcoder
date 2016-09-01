import java.util.*;
 
/*
 题目分析：

<方法1>

      首先我们想到的是二叉树中序遍历后的结果是有序的，根据这个结果，我们可以中序遍历二叉树，并把遍历结果存放在一个数组里面，然后判断这个数组大小是否是有序数组，如果是有序数组，则是二叉查找树，否则就不是。

       这个方法的时间复杂度是O(N)，但是空间复杂度比较高，需要浪费O（N）的存储空间。

<方法2>

      其实在<方法1>的基础上，我们可以在中序遍历的同时，比较大小，每次记录下上次遍历过的元素的值，如果当前元素的值大于上次遍历元素的值，则接着遍历，否则返回false，因为这个记录是一个址传递，所以需要用到引用形参进行传递。

     这个方法的时间复杂度与<方法1>的时间复杂度相同，只是空间复杂度只需要一个元素O(1)。 
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class Checker {
    public boolean checkBST(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean res = true;
        TreeNode pre = null;
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while(cur1 != null){
            cur2 = cur1.left;
            if(cur2 != null){
                while(cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                 }
                if(cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else{
                    cur2.right = null;
                }
                 
            }
            if(pre != null && pre.val > cur1.val){
                res = false;
            }
            pre = cur1;
            cur1 = cur1.right;
 
        }
        return res;
    }
}
