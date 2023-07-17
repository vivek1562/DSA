package org.solutions.linkedList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addUtility(l1, l2, 0);
    }

    public ListNode addUtility(ListNode l1, ListNode l2, int carry) {
        if(l1==null && l2==null && carry==0) {
            if(carry!=0)
                return new ListNode(carry);
            return null;
        }

        int val1 = l1==null ? 0 : l1.val;
        int val2 = l2==null ? 0 : l2.val;
        int sum = val1 + val2 + carry;
        ListNode head = new ListNode(sum%10, addUtility(l1 == null ? l1 : l1.next, l2 == null ? l2 : l2.next, sum/10));

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
