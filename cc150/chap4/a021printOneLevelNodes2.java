/**
非递归方法
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
