package com.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Runner {
    public static void main(String[] args){

        checkPriority();


    }

    private static void checkPriority() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Arrays.asList(9, 2, 8, 0, 1, 5, 10, 9, 2));
        // PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        //        minHeap.addAll(Arrays.asList(9,2,8,0,1,5, 10, 9, 2));

//        PriorityQueue<Location> locationPriorityQueue = new PriorityQueue<Location>(maxLocationComparator);
             PriorityQueue<Location> locationPriorityQueue = new PriorityQueue<Location>((l1, l2) -> l2.dist-l1.dist);
        // Collections.reverseOrder()
        locationPriorityQueue.add(new Location(2,3,6));
        locationPriorityQueue.add(new Location(2,4,8));
        locationPriorityQueue.add(new Location(5,6,1));
        locationPriorityQueue.add(new Location(5,6,1));
        locationPriorityQueue.add(new Location(5,6,100));
        locationPriorityQueue.add(new Location(5,6,-1));

        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }

        while (!locationPriorityQueue.isEmpty()){
            System.out.println(locationPriorityQueue.poll());
        }

    }

    static Comparator<Location> minLocationComparator = new Comparator<Location>() {
        @Override
        public int compare(Location o1, Location o2) {
            return o1.dist - o2.dist;
        }
    };

    static  Comparator<Location> maxLocationComparator = new Comparator<Location>() {
        @Override
        public int compare(Location o1, Location o2) {
            return o2.dist - o1.dist;
        }
    };
}
