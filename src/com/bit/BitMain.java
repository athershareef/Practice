package com.bit;

public class BitMain {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(128));
        System.out.println(Integer.toBinaryString(1775));
        System.out.println(Integer.toBinaryString(insertion(128, 20, 1, 10)));
        System.out.println(Double.toHexString(0.92));
    }

    public static int insertion(int N, int M, int i, int j ){

        return M << i | (N & ~(1 >> (j-i)) );

    }

}
