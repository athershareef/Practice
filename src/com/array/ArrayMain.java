package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ArrayMain {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[] {3,4}));

        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});

    }



    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for(String str: strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = String.valueOf(arr);
            List<String> val = anagramMap.getOrDefault(sortedStr, new ArrayList<String>());
            val.add(str);
            anagramMap.put(sortedStr, val);
        }

        return new ArrayList<>(anagramMap.values());

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] result = new int[n];
        int i = 0, j =0, k =0;
        while(j < nums1.length && k < nums2.length){
            if(nums1[j]< nums2[k]){
                result[i++] = nums1[j++];
            } else {
                result[i++] = nums2[k++];
            }
        }

        while(j < nums1.length){
            result[i++] = nums1[j++];
        }

        while(k < nums2.length){
            result[i++] = nums2[k++];
        }

        if(n%2 == 0){
            return (result[n/2-1] + result[n/2]) / 2.0;
        }

        return result[n/2];

    }

    public static void find3SubSeqN(int[] array) {


        int min = 100;
        int max = -100;

        boolean done = false;
        boolean found = false;

        for (int i = 0; i < array.length; i++) {

            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                if (done) {
                    System.out.println(min + " " + max + " " + array[i]);
                    found = true;
                    break;
                }
                max = array[i];
                done = true;
            }

        }

        if (!found) {
            System.out.println("No such triplet");
        }
    }

}
