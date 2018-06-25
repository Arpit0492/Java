package DSA;

/**
 * Created by ARPIT JOHRI on 16-11-2016.
 *
 * Better Implementation than Array
 *
 */
public class CircularQueue {

    private static int MAX_SIZE=5;
    private static int front = -1, rear = -1;
    private static int Cqueue[] = new int[MAX_SIZE];

    public static void main(String[] args) {
        CEnqueue(2);
        CEnqueue(4);
        CEnqueue(6);
        Print();
        CDequeue();
        CEnqueue(8);
        Print();
        CDequeue();
        CDequeue();
        CDequeue();
        CDequeue();
        Print();

        CEnqueue(22);
        CEnqueue(42);
        CEnqueue(62);
        CDequeue();
        Print();

    }

    private static boolean isEmpty(){
        return front==-1&&rear==-1;
    }

    private static boolean isFull(){
        return ((rear + 1) % MAX_SIZE) == front;
    }
    private static void CEnqueue(int x){
        if (isFull()){
            System.out.printf("FULL\n");
            return;
        }
        else if(isEmpty()){
            front++;
            rear++;
        }
        else{
            rear=(rear+1)%MAX_SIZE;
        }
        Cqueue[rear]=x;
    }

    private static void CDequeue(){
        if (isEmpty()){
            System.out.printf("EMPTY\n");
            return;
        }
        else if(front==rear){
            front=-1;
            rear=-1;
        }
        else {
            front=(front+1)%MAX_SIZE;
        }

    }

    private static int Front(){
        if (isEmpty())
            return -1;
        else
            return Cqueue[front];
    }

    private static void Print(){
        if (isEmpty()) {
            System.out.printf("nothing to print\n");
            return;
        }
        int count = (rear+MAX_SIZE-front)%MAX_SIZE+1;
        for (int i = 0; i <count; i++) {
            int index = (front+i)%MAX_SIZE;
            System.out.printf("%d ", Cqueue[index]);
        }
        System.out.println();
    }

}
