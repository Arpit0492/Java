package DSA;

/**
 * Created by ARPIT JOHRI on 16-11-2016.
 */

class Node{
    int data;
    Node link;
}



public class LinkedList {

    private static Node head;
    public static void main(String[] args) {
        Insert(5);
        Insert(12);
        Insert(90);
        Insert(100);
     //   Print();
//        InsertatNth(4,1);
//        Print();
//        Print();
//
//        DeleteatNth(5);
//        Print();
        ReverseRecursive(head);
        Print();
//        System.out.printf("%d\n",Search(head,5));
//        PrintBackwardR(head);


    }

    private static void Insert(int x){
        Node newNode = new Node();
        newNode.data=x;
        newNode.link=null;
        if(head==null){
            head=newNode;
            return;
        }

        newNode.link = head;
        head = newNode;
    }

    private static void Print(){
        Node temp = head;

        while (temp!=null){
            System.out.printf("%d ", temp.data);
            temp=temp.link;
        }
        System.out.println();
    }


    private static void InsertatNth(int x, int pos){
        Node newNode = new Node();
        newNode.data=x;
        newNode.link=null;
        if(pos==1){
            newNode.link=head;
            head=newNode;
            return;
        }
        Node temp = head;
        while(pos-2>0){
            temp=temp.link;
            pos--;
        }

        newNode.link=temp.link;
        temp.link = newNode;

    }

    private static void DeleteatNth(int pos){

        if(pos==1){
            head=head.link;
            return;
        }
        Node temp = head;
        while(pos-2>0){
            temp=temp.link;
            pos--;
        }

        temp.link = temp.link.link;

    }

    private static void ReverseIterative(){

        Node prev, curr, next;

        prev = null;
        curr = head;

        while(curr!=null){
            next = curr.link;
            curr.link = prev;
            prev=curr;
            curr=next;
        }
        head=prev;

    }

    private static void ReverseRecursive(Node temp){

        if (temp==null){
            return;
        }
        if(temp.link==null){
            head=temp;
            return;
        }
        ReverseRecursive(temp.link);
        temp.link.link = temp;
        temp.link = null;
    }

    private static int Search(Node head,int x){
        if(head==null)
            return 0;

        int it=1;
        while (head.data!=x){
            head=head.link;
            if(head==null){
                return 0;
            }
            it++;
        }
        return it;
    }

    private static void PrintBackwardR(Node head){

        if (head==null)
            return;

        PrintBackwardR(head.link);
        System.out.printf("%d ",head.data);
        //PrintForwardR(head.link);

    }


}
