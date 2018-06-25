package InterviewProblems;

/**
 * Created by Arpit on 30-08-2017.
 * interviewcake.com
 */
import java.util.NoSuchElementException;
import java.util.Stack;

public class TwoStackQueue {

    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public void enqueue(int item) {
        inStack.push(item);
    }

    public int dequeue() {
        if (outStack.empty()) {

            // Move items from inStack to outStack, reversing order
            while (!inStack.empty()) {
                int newestInStackItem = inStack.peek();
                outStack.push(newestInStackItem);
                inStack.pop();
            }

            // If outStack is still empty, raise an error
            if (outStack.empty()) {
                throw new NoSuchElementException("Can't dequeue from empty queue!");
            }
        }
        return outStack.pop();
    }
}
