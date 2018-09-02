package com.util;

public class Timer {
    private Long start;
    private Long end;
    private boolean isValid = false;

    public Timer() {
        this.start = 0L;
        this.end = 0L;
        this.isValid = false;
    }

    public void start() {
        start = System.nanoTime();
    }

    public Long stop(){
        end = System.nanoTime();
        if(start!=0){
            isValid = true;
        }
        return isValid? end - start : -1;
    }
}
