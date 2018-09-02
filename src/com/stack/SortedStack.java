package com.stack;

import java.util.Stack;

public class SortedStack  extends Stack<Integer> {
        Stack<Integer> tempStack = new Stack<Integer>();

        public Integer push(Integer val){
            if(tempStack.isEmpty()){
                tempStack.push(val);
                return super.push(val);
            } else {
                if(tempStack.peek()< val){

                    tempStack.pop();
                    tempStack.push(super.pop());
                    Integer t = super.push(val);
                    if(!tempStack.isEmpty()) {
                        super.push(tempStack.peek());
                    }
                    return t;
                } else {
                    return super.push(val);
                }

            }

        }

        public Integer pop(){
            Integer val = super.pop();
            tempStack.pop();
            if(!super.isEmpty()){
                tempStack.push(super.peek());
            }
            return val;
        }

        public boolean isEmpty(){
            return super.isEmpty();
        }

        public Integer peek(){
            return super.peek();
        }
}
