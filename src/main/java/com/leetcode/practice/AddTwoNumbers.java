package com.leetcode.practice;


import com.leetcode.practice.base.ListNode;

/**
 *给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode next = null;
        int last = 0;
        while(l1 != null || l2 != null){
            int v1 = 0,v2 = 0;
            if(l1 != null){
                v1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2 + last;
            last = sum /10;
            if(head == null){
                head = new ListNode(sum%10);
                next = head;
            }else {
                next.next = new ListNode(sum%10);
                next = next.next;
            }
        }
        if(last != 0){
            next.next = new ListNode(last);
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);

        new AddTwoNumbers().addTwoNumbers(listNode1,listNode2);
    }

}
