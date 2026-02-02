/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Check if we have enough nodes to reverse
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        
        // If less than k nodes, return as is
        if (count < k) return head;
        
        // Reverse first k nodes
        ListNode prev = null;
        curr = head;
        for (int i = 0; i < k; i++) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        // Connect reversed portion to rest of reversed list
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}