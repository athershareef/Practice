package com.array;

public class ArrayMain {

    public static void main(String[] args) {
        find3SubSeqN(new int[]  {4, 3, 2, 1} );
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
