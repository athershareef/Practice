package com.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        System.out.println(isPermutationPalindrome("never odd or even "));

    }

    public static boolean isPermutationPalindrome(String str){

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i=0; i<str.length(); i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) +1);
        }

        boolean isOdd = false;

        for(Integer each: map.values()){
            if(each % 2 != 0 ){
                if(isOdd){
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
        if(str.length() == 0){
            result.add(prefix);
            return result;
        }
        for(int i =0; i< str.length(); i++){
            result = permutation(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1,str.length()), result);
        }

        return result;
    }

    public static boolean containsDuplicateCharN2(String str){
        for(int i = 0; i< str.length() ; i++){
            char each = str.charAt(i);

            for(int j= i+1; j< str.length(); j++ ){

                if(each == str.charAt(j)){
                    return true;
                }

            }
        }
        return false;

    }

    public static boolean containsDuplicateCharNLOGN(String str){

        char [] charArr = str.toCharArray();

        Arrays.sort(charArr);
        System.out.println(charArr);

        for(int i = 0; i < charArr.length-1 ; i++){
            if(charArr[i] == charArr[i+1]){
                return true;
            }
        }

        return false;

    }


}
