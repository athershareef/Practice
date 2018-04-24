package com.string;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        System.out.println(permutation("ab").toString());

    }

    private static HashSet<String> permutation(String input) {
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
}
