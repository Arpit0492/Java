package DSA; /**
 * Created by ARPIT JOHRI on 07-02-2017.
 */

import java.util.*;
public class TestDS {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int Q = scan.nextInt();
        int k = scan.nextInt();
        MinHeap1 minHeap = new MinHeap1(Q);
        for (int i = 0; i <Q; i++) {
            int type = scan.nextInt();
            if (type==1){
                int x = scan.nextInt();
                int y = scan.nextInt();

                minHeap.add(Math.abs(x*x+y*y));

            }


            if(type==2){



                System.out.println(minHeap.peek());


            }
        }




    }


}

class MinHeap1 {
    public int capacity ;
    private int size ;

    int [] items ;
    public MinHeap1(int n){
        items = new int[n];
        capacity = n;
        size = 0;
    }



    private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1;}
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2;}
    private int getParentIndex(int childIndex) { return (childIndex - 1) / 2;}

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size;}
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size;}
    private boolean hasParent(int index) { return getParentIndex(index) >= 0;}

    private int leftChild(int index) { return items[getLeftChildIndex(index)];}
    private int rightChild(int index) { return items[getRightChildIndex(index)];}
    private int parent(int index) { return items[getParentIndex(index)];}

    private void swap(int indexOne, int indexTwo){
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity(){
        if (size == capacity){
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek(){
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll(){
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item){
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while(hasParent(index) && parent(index) > items[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]){
                break;
            }
            else{
                swap(index,smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }


}
