import java.util.*;
 
/*
public class ListNode {
    int val;
    ListNode next = null;
 
    ListNode(int val) {
        this.val = val;
    }
}*/
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode p1=new ListNode(0);
        ListNode p2=new ListNode(0);
        ListNode pHead1=p1;
        ListNode pHead2=p2;
        for(ListNode p=pHead; p!=null; p=p.next){
            if(p.val<x){
                p1.next=p;
                p1=p;
            }else{
                p2.next=p;
                p2=p;
            }
        }
        p1.next=pHead2.next;
        p2.next=null;
        return pHead1.next;
    }
}
