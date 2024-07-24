package leetcode;

/**
 *
 *@author JH-Wang
 *@since 2024/7/24 23:19
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
