package leetcode;

/**
 * 148. 排序链表
 *
 * @author JH-Wang
 * @since 2024/7/29 0:08
 */
public class LC148 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(4, node3);
        Solution148 solution148 = new Solution148();
        ListNode listNode = solution148.sortList(node4);
        System.out.println(listNode);
    }
}


class Solution148 {

    // 使用归并排序算法
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 使用快慢指针找到链表中间点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 将链表分割为两半
        ListNode list2 = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(list2));
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode point = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                point.next = list1;
                list1 = list1.next;
            } else {
                point.next = list2;
                list2 = list2.next;
            }
            point = point.next;
        }
        if (list1 != null) {
            point.next = list1;
        } else {
            point.next = list2;
        }
        return head.next;
    }
}