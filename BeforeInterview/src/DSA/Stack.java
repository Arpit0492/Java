package DSA; /**
 * Created by ARPIT JOHRI on 15-11-2016.
 */
import static java.lang.Integer.*;

public class Stack {
    private static int MAX_SIZE = 5;
    private static int top = -1;
    private static int stack [] = new int[MAX_SIZE];


    public static void main(String[] args) {

        Push(3);
        Push(5);
        Push(7);
        Push(9);
        Push(11);
        Print();
        Push(13);
        Pop();
        Print();
        Pop();
        Pop();
        Print();

    }


    private static boolean isEmpty(){
        return top==-1;
    }

    private static boolean isFull(){
        return top==MAX_SIZE-1;
    }

    private static void Push(int x){
        if (isFull()) {
            System.out.printf("FULL\n");
            return;
        }
        top++;
        stack[top]=x;
    }

    private static void Pop(){
        if(isEmpty()){
            System.out.printf("EMPTY\n");
            return;
        }
        top--;
    }

    private static int Top(){
        return stack[top];
    }

    private static void Print(){
        for(int i=0; i<=top; i++){
            System.out.printf(stack[i]+" ");
        }
        System.out.println();
    }

}

