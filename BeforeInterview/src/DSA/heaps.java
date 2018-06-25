package DSA;

/**
 * Created by ARPIT JOHRI on 08-02-2017.
 *
 * External DS
 */
public class heaps {
}

class minHeap {
    int arr[],num;
    minHeap(int a){
        arr = new int[a];
        num = 0;
    }
    public void swap(int arr[],int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public void Minheap(int a){
        while(a>0&&arr[(a-1)/2]>arr[a]){
            swap(arr,(a-1)/2,a);
            a = (a-1)/2;
        }
    }
    public void Minheapify(int a){
        int largest = a;
        if(2*a+1<num&&arr[largest]>arr[2*a+1])
            largest = 2*a+1;
        if(2*a+2<num&&arr[largest]>arr[2*a+2])
            largest = 2*a+2;
        if(largest!=a){
            swap(arr,a,largest);
            Minheapify(largest);
        }
    }
    public void insert(int a){
        arr[num++] = a;
        Minheap(num-1);
    }
    public void deleteAtIndex(int a){
        int pi = arr[a];
        arr[a] = arr[num-1];
        num--;
        if(arr[a]>pi)
            Minheapify(a);
        else
            Minheap(a);
    }
    public int getMin(){
        int pi = arr[0];
        //deleteAtIndex(0);
        if(num==0)
            pi = -1;
        return pi;
    }
    public boolean deleteAtValue(int a){
        int i;
        boolean u = false;
        for(i=0;i<num;i++){
            if(arr[i]==a){
                deleteAtIndex(i);
                u = true;
                break;
            }
        }
        if(!u)
            return true;
        else
            return false;
    }
}

class maxHeap {
    int arr[],num;
    maxHeap(int a){
        arr = new int[a];
        num = 0;
    }
    public void swap(int arr[],int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public void Maxheap(int a){
        while(a>0&&arr[(a-1)/2]<arr[a]){
            swap(arr,(a-1)/2,a);
            a = (a-1)/2;
        }
    }
    public void Maxheapify(int a){
        int largest = a;
        if(2*a+1<num&&arr[largest]<arr[2*a+1])
            largest = 2*a+1;
        if(2*a+2<num&&arr[largest]<arr[2*a+2])
            largest = 2*a+2;
        if(largest!=a){
            swap(arr,a,largest);
            Maxheapify(largest);
        }
    }
    public void insert(int a){
        arr[num++] = a;
        Maxheap(num-1);
    }
    public void deleteAtIndex(int a){
        int pi = arr[a];
        arr[a] = arr[num-1];
        num--;
        if(arr[a]<pi)
            Maxheapify(a);
        else
            Maxheap(a);
    }
    public int getMax(){
        int pi = arr[0];
        //deleteAtIndex(0);
        if(num==0)
            pi = -1;
        return pi;
    }
    public void deleteAtValue(int a){
        for(int i=0;i<num;i++){
            if(arr[i]==a){
                deleteAtIndex(i);
                break;
            }
        }
    }
}