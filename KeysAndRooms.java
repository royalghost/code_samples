package com.codesamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Solution to
 * https://leetcode.com/problems/keys-and-rooms/
 * 
 * Output from LeetCode:
 * 
 * Runtime: 9 ms, faster than 23.07% of Java online submissions for Keys and Rooms.
 * Memory Usage: 41.9 MB, less than 100.00% of Java online submissions for Keys and Rooms.
 */
public class KeysAndRooms {
	
	//Default Constructor
	public KeysAndRooms() {
	}
	
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
	
	public static void main(String[] args) {
		List<List<Integer>> input = new ArrayList<>();
		//	[[1],[2],[3],[]]
		input.add(Arrays.asList(1));
		input.add(Arrays.asList(2));
		input.add(Arrays.asList(3));
		input.add(Arrays.asList());

		KeysAndRooms keysAndRooms = new KeysAndRooms();
		boolean result = keysAndRooms.canVisitAllRooms(input);
		System.out.println(result);
	}

}
