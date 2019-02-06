# Code Samples

## Remove Duplicates from a Sorted List

This is a medium level question from [LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)

```
static ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode previous = dummy;

		while (current != null && current.next != null) {
			if (current.val == current.next.val) {
				while (current.next != null && current.val == current.next.val) {
					current = current.next;
				}
				previous.next = current.next;
			} else {
				previous = current;
			}
			current = current.next;
		}
		return dummy.next;
	}

```
[View full implementation](https://github.com/royalghost/code_samples/blob/develop/RemoveDuplicatesFromSortedList.java)
