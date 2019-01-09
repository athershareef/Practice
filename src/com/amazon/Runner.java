package com.amazon;

import com.amazon.utils.ListNode;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class Runner {
    public static void main(String[] args){
        Runner ref = new Runner();
//        System.out.println(ref.numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
//        System.out.println(ref.cellCompete(new int[]{1,0,0,0,0,1,0,0}, 1));
//        System.out.println(ref.optimalUtilization(20,  , ));
    }

    List<List<Integer>> optimalUtilization(int maxTravelDist,
                                           List<List<Integer>> forwardRouteList,
                                           List<List<Integer>> returnRouteList)
    {
        // WRITE YOUR CODE HERE
        // Max heap
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for(List<Integer> forwardRoute: forwardRouteList){
            for(List<Integer> returnRoute: returnRouteList){
                int distance = forwardRoute.get(1) + returnRoute.get(1);
                if(distance <=maxTravelDist){
                    queue.add(distance);
                    map.put(distance, Arrays.asList(forwardRoute.get(0),returnRoute.get(0)));
                }
            }
        }

        Integer first  = queue.poll();
        Integer next = first;
        while(next!=null && next.equals(first)){
            result.add(first, map.get(first));
            next = queue.poll();
        }

        return result;


    }


    List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
    {
        // WRITE YOUR CODE HERE

        Queue<Double> distances = new PriorityBlockingQueue<>();
        HashMap<Double, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for(List<Integer> eachLocation: allLocations){
            double distance = findDistance(eachLocation.get(0), eachLocation.get(1));
            distances.add(distance);
            map.put(distance, eachLocation);
        }



        for(Double distance: distances){
            if(numDeliveries < 1){
                break;
            }
            result.add(map.get(distances.poll()));
            numDeliveries--;
        }

        return result;



    }
    // METHOD SIGNATURE ENDS

    private double findDistance(int x, int y){
        return Math.sqrt(x*x + y*y);
    }


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int[] result = twoSum(nums, -nums[i]);
            if(result != null){
                lists.add(Arrays.asList(nums[i], result[0], result[1]));
            }
        }

        return lists;

    }


    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public int generalizedGCD(int num, int[] arr)
    {
        int gcd = arr[0];
        for(int i = 1; i < num; i++){
            gcd = gcd(arr[i], gcd);
        }
        return gcd;
    }

    public List<Integer> cellCompete(int[] states, int days)
    {

        // WRITE YOUR CODE HERE
        for(int day = 0; day < days; day++){
            int[] newState = new int[states.length];

            for(int index = 0; index < states.length; index++){
                if(index == 0){
                    newState[index] = states[index+1];
                }
                else if(index == states.length -1){
                    newState[index] = states[index-1];
                } else if(states[index-1] == 1 ^ states[index+1]==1){
                    newState[index] = 1;
                } else{
                    newState[index] = 0;
                }
            }
            states = Arrays.copyOf(newState, newState.length);
            if(day == days-1){
                ArrayList<Integer> list = new ArrayList<>();
                for(int each: newState){
                    list.add(each);
                }
                return list;
            }
        }

        return null;


    }




    public int numIslands(char[][] grid) {
        int  count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    DFS(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void DFS(char[][] grid, int row, int col){

        if(row < 0 || col< 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != '1'){
            return;
        }
        // mark visited
        grid[row][col] = '#';
        // right
        DFS(grid , row,col+1);
        // down
        DFS(grid , row+1,col);
        // left
        DFS(grid , row,col-1);
        // up
        DFS(grid, row-1,col);

    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        int maxFreq = 0;
        String maxWord = "";
        String[] words = paragraph.toLowerCase().replaceAll("\\!|\\?|\\'|\\,|\\;|\\.", " ").split("\\s+");
        for(String each: words){
            if(!bannedSet.contains(each)){
                int count = frequencyMap.getOrDefault(each, 0) + 1;
                frequencyMap.put(each, count);
                if(count > maxFreq){
                    maxFreq = count;
                    maxWord = each;
                }
            }
        }

        return maxWord;
    }




    public static boolean isValidParenthesis(String s) {
        String open = "{[(";
        String close = "}])";
        if(s.length() % 2 == 1){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(open.indexOf(c) != -1){
                stack.push(c);
            }
            if(!stack.isEmpty() && open.indexOf(stack.peek()) == close.indexOf(c)){
                stack.pop();
            } else if(stack.isEmpty() && close.indexOf(c) !=-1){ // i.e. s is having close brackets
                return false;
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
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target-nums[i], i);
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
