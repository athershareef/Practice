package com.sample;

public class V implements Base{

    public static void main(String[] args){
        Base a = new V();
        a.rum();
    }


    public void rum() {
        System.out.println("V rum");
    }
}
