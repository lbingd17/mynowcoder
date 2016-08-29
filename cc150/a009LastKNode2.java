
/*

public class ListNode {

    int val;

    ListNode next = null;

​

    ListNode(int val) {

        this.val = val;

    }

}*/

public class Solution {

    public ListNode FindKthToTail(ListNode list,int k) {
      ListNode head = list;
      if(head==null||k<=0)return null;
      ListNode nodePre=head;
      ListNode nodeLast=head;
            
      for(int i=1;i<k;i++){
         if(nodePre.next!=null)nodePre=nodePre.next;
         else return null;
      }
      
      while(nodePre.next!=null){
         nodePre = nodePre.next;
         nodeLast=nodeLast.next;
      }
      return nodeLast;
    }
  }
