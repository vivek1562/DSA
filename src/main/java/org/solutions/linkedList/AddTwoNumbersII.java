package org.solutions.linkedList;

public class AddTwoNumbersII {
    ListNode head = null;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);

        if(len1 < len2) {
            int temp = len1;
            len1 = len2;
            len2 = temp;
            ListNode tempNode = l1;
            l1 = l2;
            l2 = tempNode;
        }

        int carry = addUtility(l1, l2, len1-len2);
        if(carry!=0) {
            ListNode temp = new ListNode(carry);
            temp.next = head;
            head = temp;
        }
        return head;
    }

    public int addUtility(ListNode l1, ListNode l2, int diff) {
        if(l1 == null || l2 == null) {
            return 0;
        }

        int carry;
        if(diff!=0) {
            carry = addUtility(l1.next, l2, diff-1);
            int val = l1.val + carry;
            carry = val/10;
            val = val%10;
            ListNode temp = new ListNode(val);
            temp.next = head;
            head = temp;
        } else {
            carry = addUtility(l1.next, l2.next, diff);
            int val = l1.val + l2.val + carry;
            carry = val/10;
            val = val%10;
            ListNode temp = new ListNode(val);
            temp.next = head;
            head = temp;
        }

        return carry;
    }

    public int getLength(ListNode l) {
        int len = 0;
        while(l!=null) {
            len++;
            l = l.next;
        }
        return len;
    }

    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
