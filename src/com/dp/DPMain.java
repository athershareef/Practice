package com.dp;

import com.util.Timer;

public class DPMain {
    public static void main(String[] args){

        Timer timer = new Timer();
        timer.start();

        System.out.println(tripleSteps(20));

        System.out.println(timer.stop());

        timer.start();

        System.out.println(tripleSteps(20));

        System.out.println(timer.stop());


    }

    /*
        Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
        steps at a time. Implement a method to count how many possible ways the child can run up the
        stairs.
     */
    private static int tripleSteps(int n){
        // O(N^3)
        if (n < 0) {
            return 0;
        }
        else if(n==0){
            return 1;
        }
        return tripleSteps(n-1) + tripleSteps(n-2) + tripleSteps(n-3);
    }

    private static int tripleStep(int n){
        // Bottom Up

        int[] countways = new int[n+1];

        countways[0] = 1;
        countways[1] = 1;
        countways[2] = 2;

        for(int i = 3; i <= n ; i++){
            countways[i] = countways[i-1] + countways [i-2] + countways[i-3];
        }

        return countways[n];

    }




}
