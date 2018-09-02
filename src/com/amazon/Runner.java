package com.amazon;

import com.amazon.utils.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Runner {
    public static void main(String[] args){
        System.out.println(isValidParenthesis("{{{}}}"));
    }

    public static boolean isValidParenthesis(String s) {
        String open = "{[(";
        String close = "}])";
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(open.indexOf(c) != -1){
                stack.push(c);
            }
            else {
                if(!stack.isEmpty() && open.indexOf(stack.peek()) == close.indexOf(c)) stack.pop();
            }
        }

        return stack.size() == 0;
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for(int i = 0, count =0; i < s.length() ; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                count = 1;
                i = map.get(c) + 1;
                map.clear();
                map.put(s.charAt(i), i);
                continue;
            } else {
                count++;
            }
            map.put(c, i);
            maxLength = Math.max(maxLength, count);
        }

        return maxLength;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i =0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;
        ListNode sol = new ListNode(0);
        boolean once = true;
        ListNode tempSol = sol;
        while(l1 != null || l2 != null){
            sum = carry + (l1 !=null? l1.val: 0) + (l2 !=null? l2.val: 0);
            if(once){
                once = false;
                sol.val = sum % 10;
            } else {
                tempSol.next = new ListNode(sum % 10);
                tempSol = tempSol.next;
            }
            if(l1 !=null) l1 = l1.next;
            if(l2 !=null) l2 = l2.next;
            carry  = sum / 10;
        }

        if(carry != 0){
            tempSol.next = new ListNode(carry);
        }

        return sol;
    }
}
