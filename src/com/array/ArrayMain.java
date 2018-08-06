package com.array;

import java.util.Arrays;

public class ArrayMain {

    public static void main(String[] args) {

//        find3SubSeqN(new int[]  {1, 3, 2, 6} );
//        swapMaxNumber(new int[]  {7, 3, 4, 6},2);
        System.out.println(findMaxSubArrayNegative(new int[]  {-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int findMaxSubArrayNegative(int[] array){

        int max = array[0];
        int maxTillNow = array[0];

        for(int i =1; i < array.length ; i++){
            maxTillNow  = Math.max(array[i], maxTillNow +array[i]);
            max = Math.max(maxTillNow,max);
        }

        return max;
    }

    public static int findMaxSubArray(int[] array){

        int max = 0;
        int maxTillNow = 0;

        for(int i =1; i < array.length ; i++){
            maxTillNow +=array[i];
            if(maxTillNow< 0){
                maxTillNow = 0;
            }
           if(maxTillNow>max){
                max = maxTillNow;
            }
        }

        return max;
    }

    public static void swapMaxNumber(int[] array, int count){
        for(int i =0; i < count ; i++){
            int max = findMax(array, i);
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;
        }

        System.out.println(Arrays.toString(array));
    }

    public static int findMax(int[] array, int index){
        int max = -1;
        for(int i = index; i< array.length ; i++){
            if(max  < array[i]){
                max = i;
            }
        }
        return array[max] > array[index] ? max : index;
    }

   public static void find3SubSeqN(int[] array){

        int min = 100;
        int max = -100;

        boolean done = false;
        boolean found = false;

        for(int i=0; i < array.length ; i++){

            if(array[i] < min){
                min = array[i];
            } else if(array[i] > max){
                if(done){
                    System.out.println(min + " " + max + " " + array[i] );
                    found = true;
                    break;
                }
                max = array[i];
                done = true;
            }

        }

        if(!found){
            System.out.println("No such triplet");
        }
   }

}
