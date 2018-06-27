package com.medium;

import java.util.*;

public class MediumMain {

    public static void main(String[] args) {
//        System.out.println(findMinSumDP(new int[][] { {2,3,4}, {5,8,15}, {3,4,10} , {5,10,6}}));
//        System.out.println(findMinSumDP(new int[][] { {2,5,3,5}, {3,8,4,10}, {4,15,10,6}}));
//          System.out.println(mountain(new int[]{2,1,4,7,3,2,1,5}));
//        System.out.println(mountain(new int[]{2,2,2}));
//        System.out.println(largeValue(new Vector<String>()));

//            System.out.println(longestCommonPrefix(new String[]{"whatcanIdo", "whatcanIdo", "bhatcanIdo"}));
//        System.out.println(removeDuplicatesSorted(new int[] {0,0,1,1,1,2,2,3,3,4}));
        System.out.println(removeNumberFromArray(new int[] {4,5}, 5));
    }

    public static int removeNumberFromArray(int[] array, int val){
        int j= 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] != val){
               array[j] = array [i];
               j++;
            }
        }

        return j;
    }


    public static int removeDuplicatesSorted(int[] array){
        int length =  array.length;
        for(int i = 0, j = 0; i < array.length-1 ; i++){
            if(array[i] == array[i+1]){
                length--;
            } else {
                j++;
                array[j] = array[i + 1];
            }
        }

        return length;
    }

    public static String longestCommonPrefix(String[] input){

        if(input.length == 0){
            return "";
        }

        String result = input[0];

        for(String each: input){
            result = findIntersection(result, each);
        }

        return result.length() > 0 ? result : "No common prefix exists!";

    }

    private static String findIntersection(String s1, String s2){
        for(int i =0 ; i < Math.min(s1.length(), s2.length()) ; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                return s1.substring(0,i);
            }
        }

        return s1.length() >= s2.length() ? s2: s1;


    }



    public static String largeValue(Vector<String> array) {

        Collections.sort(array, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1) > 0 ? -1: 1;
            }
        });


        for (String a : array) {
            System.out.print(a + ", ");
        }
        return "";
    }

        public static int mountain(int[] array){

        if(array.length == 0){
            return 0;
        }

        int length = 0;
        int maxSum = 0;
        int sum = array[0];

        for(int i =1; i < array.length ; i++){
            sum +=array[i];
            if(sum > maxSum && (sum - array[i]) != sum){
                maxSum = sum;
                length ++;
            }
            if(i < array.length -1 && array[i-1] > array [i] && array[i] < array[i+1] ) {
                sum = array[i];
            }
            if(i < array.length -1 &&  array[i-1] == array [i] && array[i] == array[i+1]){
                sum = -array[i];
                maxSum = -array[i];
                length = -1;
            }

        }

        return length;
    }

    public static int findMinSumDP(int[][] cost) {
        int m = cost.length;

        for(int i = 1; i < m ; i++){
            cost[i][0] += Math.min(cost[i-1][1] , cost[i-1][2]);
            cost[i][1] += Math.min(cost[i-1][0] , cost[i-1][2]);
            cost[i][2] += Math.min(cost[i-1][0] , cost[i-1][1]);
        }


        return Math.min(cost[m-1][0], Math.min(cost[m-1][1], cost[m-1][2] ));
    }


    public static int findMinSum(int[][] cost){

        int sum = 0;
        int last  = -1;

        for(int i = 0; i < cost.length ; i++){
            if(last == 0){
                last = findMin(new int[] {cost[i][1],cost[i][2]}) + 1;
            }  else if(last == 1){
                last = findMin(new int[] {cost[i][0],cost[i][2]});
                if(last == 1){
                    last = 2;
                }
            }  else if(last == 2){
                last = findMin(new int[] {cost[i][0],cost[i][1]});
            }  else {
                last = findMin(new int[] {cost[i][0],cost[i][1],cost[i][2]});
            }
            sum += cost[i][last];

        }

        return sum;
    }

    public static int findMin(int[] array){
        int min = 0;

        for(int i =1; i < array.length ; i++){
            if(array[min] > array[i]){
                min = i;
            }
        }

        return min;
    }


}
