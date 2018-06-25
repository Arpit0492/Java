package DSA;

/**
 * Created by ARPIT JOHRI on 16-11-2016.
 */


public class QueueLL {

    private static Node front = null, rear = null;

    public static void main(String[] args) {
        Enqueue(2); Print();
        Enqueue(4); Print();
        Enqueue(6); Print();
        Dequeue();  Print();
        Enqueue(8); Print();
    }

    private static void Enqueue(int x){
        Node newNode = new Node();
        newNode.data=x;
        newNode.link=null;

        if (front==null&&rear==null){
            front=rear=newNode;
            return;
        }
        rear.link=newNode;
        rear=newNode;
    }

    private static void Dequeue(){

        if (front==null){
            System.out.printf("EMPTY");
        }
        else if(front==rear){
            front=rear=null;
        }
        else{
            front=front.link;
        }
    }

    private static int Front(){
        if (front==null) {
            System.out.printf("EMPTY\n");
            return -1;
        }
        else
            return front.data;
    }

    private static void Print(){
        Node temp = front;
        while (temp!=null){
            System.out.printf("%d ",temp.data);
            temp=temp.link;
        }
        System.out.println();
    }



}


