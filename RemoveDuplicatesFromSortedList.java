/**
 * Solution to
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * Output from LeetCode:
 * 
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove
 * Duplicates from Sorted List II. Memory Usage: 27.2 MB, less than 2.30% of
 * Java online submissions for Remove Duplicates from Sorted List II.
 */
public class RemoveDuplicatesFromSortedList {

	static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public RemoveDuplicatesFromSortedList() {
	}

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

	public static void main(String[] args) {
		// Input : 1-> 1-> 2-> 2-> 4-> 5-> 6-> 7-> 7
		// Output : 4 -> 5 -> 6 -> null
		ListNode head = new ListNode(1);
		ListNode one_2 = new ListNode(1);
		head.next = one_2;
		ListNode two = new ListNode(2);
		one_2.next = two;
		ListNode two_2 = new ListNode(2);
		two.next = two_2;
		ListNode four = new ListNode(4);
		two_2.next = four;
		ListNode five = new ListNode(5);
		four.next = five;
		ListNode six = new ListNode(6);
		five.next = six;
		ListNode seven = new ListNode(7);
		six.next = seven;
		ListNode seven_2 = new ListNode(7);
		seven.next = seven_2;
		ListNode res = RemoveDuplicatesFromSortedList.deleteDuplicates(head);
		// Print Result
		while (res != null) {
			System.out.print(res.val + " -> ");
			res = res.next;
		}
	}
}
