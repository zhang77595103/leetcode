public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0);
    ListNode p1 = l1, p2 = l2, p = result;
    int carry = 0;
    while (p1 != null || p2 != null) {
        int add1 = p1 == null ? 0 : p1.val;
        int add2 = p2 == null ? 0 : p2.val;
        int sum = add1 + add2 + carry;
        p.next = new ListNode(sum % 10);
        carry = sum / 10;
        p = p.next;
        if (p1 != null) { p1 = p1.next; }
        if (p2 != null) { p2 = p2.next; }
    }
    if (carry == 1) { p.next = new ListNode(1); }
    return result.next;
}
