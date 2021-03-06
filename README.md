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

## Keys and Rooms
Question - https://leetcode.com/problems/keys-and-rooms/

```
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //This is a depth first search problem 
        //Solved by using a Stack and keeping track of each node visited or not in order to avoid infinite loop
        if ( rooms == null || rooms.isEmpty() ) return true;
        final int N = rooms.size();
        //keep track of each node if visited or not with each node set to false initially
        boolean visits[] = new boolean[N];
        //Since by problem definition first one is unlocked so can visit without key
        visits[0] = true;
        Stack<List<Integer>> roomStack = new Stack<>();
        //Add the list of rooms for which keys are available on first node
        roomStack.push(rooms.get(0));
        while (! roomStack.isEmpty() ){
            List<Integer> keysInRoom = roomStack.pop();
            //Iterate through each key found in the node
            for(Integer key : keysInRoom){
                if ( ! visits[ key ] )  { 
                    visits[key] = true;  
                    roomStack.push( rooms.get( key) ); 
                }             
            }
        }
        //check if all visited is true or not
        for(boolean visit : visits)
            if (!visit) return false;
        
        return true;
    }
```
[View full implementation](https://github.com/royalghost/code_samples/blob/develop/KeysAndRooms.java)