package DSA;

/**
 * Created by ARPIT JOHRI on 15-11-2016.
 */


public class StackLL {

    private static Node top = null;

    public static void main(String[] args) {

        Push(2);
        Push(5);
        Push(7);
        Print();
        System.out.println();
        Pop();
        Pop();
        Pop();
        Pop();
        System.out.printf("%d\n",Top());
    }



    private static boolean isEmpty(){
        return top==null;
    }

    private static void Push(int x){
        Node newNode = new Node();
        newNode.data=x;
        newNode.link=top;
        top=newNode;

    }

    private static void Pop(){
        if (isEmpty()) {
            System.out.printf("EMPTY\n");
            return;
        }
        top=top.link;

    }

    private static int Top(){
        if(!isEmpty())
            return top.data;
        else
            return -1;
    }

    private static void Print(){
        Node temp = top;
        while(temp!=null){
            System.out.printf("%d ",temp.data);
            temp=temp.link;
        }
    }


}
