import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//思路：内容拷贝
public class Remove {
    public boolean removeNode(ListNode pNode) {
        if(pNode == null || pNode.next == null){
            return false;
		}
        else {
            pNode.val = pNode.next.val;
            pNode.next = pNode.next.next;
            return true;
		}
    }
}
