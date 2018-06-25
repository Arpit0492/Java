package InterviewProblems;

import java.util.Stack;

/**
 * Created by Arpit on 30-08-2017.
 * interviewcake.com
 */
public class MaxStack {

    private Stack<Integer> oStack = new Stack<>();
    private Stack<Integer> mStack = new Stack<>();


    // Add a new item to the top of our stack. If the item is greater
    // than or equal to the last item in maxesStack, it's
    // the new max! So we'll add it to maxesStack.
    private void Push(int x){
        oStack.push(x);
        if (mStack.empty() || x > mStack.peek()){
            mStack.push(x);
        }
    }

    // Remove and return the top item from our stack. If it equals
    // the top item in maxesStack, they must have been pushed in together.
    // So we'll pop it out of maxesStack too.
    private int Pop(){
        int item = oStack.pop();
        if (item == mStack.peek()){
            mStack.pop();
        }
        return item;
    }

    // The last item in maxesStack is the max item in our stack.
    private int getMax(){
        return mStack.peek();
    }

}
