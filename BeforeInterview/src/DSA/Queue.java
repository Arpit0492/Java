package DSA;

/**
 * Created by ARPIT JOHRI on 16-11-2016.
 */
public class Queue {

    private static int MAX_SIZE=5;
    private static int front = -1, rear = -1;
    private static int queue [] = new int[MAX_SIZE];

    public static void main(String[] args) {
        Enqueue(2);
        Enqueue(4);
        Enqueue(6);
        Print();
        Dequeue();
        Enqueue(8);
        Print();
        Dequeue();
        Dequeue();
        Dequeue();
        Dequeue();
        Print();

        Enqueue(22);
        Enqueue(42);
        Enqueue(62);
        Dequeue();
        Print();

    }

    private static boolean isEmpty(){
        return front==-1&&rear==-1;
    }

    private static boolean isFull(){
        return rear==MAX_SIZE-1;
    }
    private static void Enqueue(int x){
        if (isFull()){
            System.out.printf("FULL\n");
            return;
        }
        else if(isEmpty()){
            front++;
            rear++;
        }
        else{
            rear++;
        }
        queue[rear]=x;
    }

    private static void Dequeue(){
        if (isEmpty()){
            System.out.printf("EMPTY\n");
            return;
        }
        else if(front==rear){
            front=-1;
            rear=-1;
        }
        else {
            front++;
        }

    }

    private static int Front(){
        if (front==-1)
            return -1;
        else
            return queue[front];
    }

    private static void Print(){
        if (isEmpty()) {
            System.out.printf("nothing to print\n");
            return;
        }
        for (int i = front; i <=rear; i++) {
            System.out.printf("%d ", queue[i]);
        }
        System.out.println();
    }


}
