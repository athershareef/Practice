package com.array;

import java.util.Arrays;

public class ArrayMain {

    public static void main(String[] args) {

        find3SubSeqN(new int[]  {1, 3, 2, 6} );
        swapMaxNumber(new int[]  {7, 3, 4, 6},2);
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
