package com.hyman.zhh.leetcode;

import java.util.HashMap;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        HashMap<Integer, ListNode> hashMap = new HashMap<>();
        int count = 0;
        ListNode current = head;
        while (current != null) {
            hashMap.put(count++, current);
            current = current.next;
        }
        int index = count - n;
        hashMap.get(index).next = null;
        if (index == 0) {
            return hashMap.get(1);
        } else {
            hashMap.get(index - 1).next = hashMap.get(index + 1);
            return head;
        }
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
