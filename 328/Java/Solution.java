
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {

        // when the node is less than 3, which means no need to change
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }

        // two flag to mark the position of the last node of the odd queue and even queue
        ListNode odd = head, even = head.next, head2 = even, cur = even.next;

        while(cur != null){
            odd.next = cur;
            odd = cur;
            if(cur.next != null){
                even.next = cur.next;
                even = cur.next;
            }
            else{
                //if the next is null
                break;
            }

            cur = cur.next.next;
        }

        odd.next = head2;
        even.next = null;

        return head;
    }
}