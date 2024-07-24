package leetcode;

/**
 *
 *@author JH-Wang
 *@since 2024/7/24 23:18
 */
public class LC2 {
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode point = head;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int val = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;
            point.next = new ListNode(val);
            point = point.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        return head.next;
    }
}