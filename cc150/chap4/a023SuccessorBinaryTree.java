 
import java.util.*;
 
/*
中序遍历非递归算法
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class Successor {
    public int findSucc(TreeNode root, int p) {
        boolean isFound = false;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                TreeNode q = stack.pop();
                if(isFound) return q.val;
                else if(q.val==p) isFound = true;
                cur = q.right;
            }
        }
        return -1;
    }      
}

///////解法2
import java.util.*;
 
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/

public class Successor {
        ArrayList<TreeNode> ls=new ArrayList<TreeNode>();
    public int findSucc(TreeNode root, int p) {
        find(root);
        for(int i=0;i<ls.size()-1;i++)
        {
            if(ls.get(i).val==p)
                return ls.get(i+1).val;
        }
        return -1;
    }
    public void find(TreeNode root)
    {
        if(null!=root)
        {
            find(root.left);
            ls.add(root);
            find(root.right);
        }
    }
}
