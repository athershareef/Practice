package com.string;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        System.out.println(maxSubStringDistinctCharacters("geeksgeeksfor"));

            CountingPrimeSubmatrix(new int[][]{ {3,5,6}, {8,3,2}, {3,5,2}});

    }

    private static void CountingPrimeSubmatrix(int[][] ints) {

    }

    public static boolean isPrime(int n)
    {
        if(n<2)
            return false;
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static int maxSubStringDistinctCharacters(String str){

        int maxDistinctChars = 0;
        int minStringLen = 10;
        for(int i = 0; i < str.length(); i++){
            for(int j = i ; j < str.length(); j++){
                int max = findDistinctChars(str.substring(i, j+1));
                if(maxDistinctChars <= max){
                    minStringLen = j-i+1;
                    maxDistinctChars = max;
                }
           }
        }

        return minStringLen;
    }

    private static int findDistinctChars(String str) {
        HashSet<Character> set = new HashSet<>();
        for(int i =0; i < str.length(); i++){
            set.add(str.charAt(i));
        }
        return set.size();
    }

    public static int longestDistinctChars(String str){
        char [] charArray = str.toCharArray();

        int maxCount = 0;

        int count = 0;

        HashSet<Character> visited = new HashSet<>();

        for(int i =0; i < charArray.length ; i++) {
            if (visited.contains(charArray[i])) {
                count = 0;
                visited.clear();
            }
            visited.add(charArray[i]);
            count++;
            if (maxCount < count) {
                maxCount = count;
            }
        }
        return maxCount;
    }

    public static String compressN(String str) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (Character key : map.keySet()) {
            sb.append(key);
            sb.append(map.get(key));
        }

        return sb.toString().length() < str.length() ? sb.toString() : str;

    }

    public static boolean isPermutationPalindromeN(String str) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        boolean isOdd = false;

        for (Integer each : map.values()) {
            if (each % 2 != 0) {
                if (isOdd) {
                    return false;
                }
                isOdd = true;
            }
        }

        return true;
    }


    private static HashSet<String> permutationRECURSION(String input) {
        return permutation("", input, new HashSet<String>());
    }

    private static HashSet<String> permutation(String prefix, String str, HashSet<String> result) {
        if (str.length() == 0) {
            result.add(prefix);
            return result;
        }
        for (int i = 0; i < str.length(); i++) {
            result = permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length()), result);
        }

        return result;
    }

    public static boolean containsDuplicateCharN2(String str) {
        for (int i = 0; i < str.length(); i++) {
            char each = str.charAt(i);

            for (int j = i + 1; j < str.length(); j++) {

                if (each == str.charAt(j)) {
                    return true;
                }

            }
        }
        return false;

    }

    public static boolean containsDuplicateCharNLOGN(String str) {

        char[] charArr = str.toCharArray();

        Arrays.sort(charArr);
        System.out.println(charArr);

        for (int i = 0; i < charArr.length - 1; i++) {
            if (charArr[i] == charArr[i + 1]) {
                return true;
            }
        }

        return false;

    }


}
