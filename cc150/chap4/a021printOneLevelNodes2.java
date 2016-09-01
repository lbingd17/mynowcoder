/**
非递归方法
 <方法1>：层次遍历

     这个题目的意思就是输出二叉树的某一层的所有元素，
     这个首先想到的是层次遍历，层次遍历最简单的方法就是用队列实现，
     我们传统的层次遍历方法是可以输出所有元素，那么如何区分相邻两层之间的元素呢？

     其实我们可以用两个整数变量line1，line2来记录相邻两层的元素个数，
     其中line1代表出栈那一层留下的元素个数，line2代表下一层进栈元素的个数，
     每当line1为0的时候，说明上一层已经全部出栈，下一层已经全部入栈，那么层次遍历层数就加一，
     这个时候将line2的值复制给line1，line2=0，当遍历到第dep层的时候，便把那一层的所有元素输出，停止遍历。
代码实现如下： 
*/

import java.util.*;

/*
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
        ListNode list=new ListNode(-1);
        ListNode listHead=list;
        Queue<TreeNode> qu = new LinkedList<TreeNode>();  
        qu.offer(root);//better than add, when fail, throw exception
        
        int lines1=1,lines2=0,num=1;
        while(!qu.isEmpty()){
            if(num==dep){
                for(int i=0;i<lines1;i++){
                    TreeNode root1=qu.peek();
                    list.next=new ListNode(root1.val);
                    list=list.next;
                    qu.remove();
                }
                return listHead.next;
            }
            TreeNode root1=qu.peek();
            if(root1.left != null){
                qu.offer(root1.left);
                lines2++;
            }
            if(root1.right != null){
                qu.offer(root1.right);
                lines2++;
            }
            qu.remove();
            if(--lines1==0){
                lines1=lines2;
                lines2=0;
                num++;
            }
        }
        return listHead.next;
    }
}
