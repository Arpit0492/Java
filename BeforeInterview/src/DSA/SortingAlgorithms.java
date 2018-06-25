package DSA;

/**
 * Created by ARPIT JOHRI on 16-11-2016.
 */
    public class SortingAlgorithms {

        static int swaps=0;
        public static void main(String[] args) {

            int A[] ={7, 3, 5, 3, 7, 6, 5, 6};
            int n = A.length;

            //SelectionSort(A,n);

            //InsertionSort(A,n);
            //MergeSort(A,n);
            QuickSort(A,0,n-1);
//            System.out.println(swaps);
//            for (int i = 0; i <n; ++i) {
//                System.out.printf("%d ",A[i]);
//            }

        }

        // TODO: 20-11-2016 Learn Definitions of all sorting algorithms.
        private static void SelectionSort(int A[], int n){
            for (int i = 0; i<n; i++) {
                int minValIndex = i;
                for (int j = i+1; j<n; j++) {
                    if(A[j] < A[minValIndex]){
                        minValIndex=j;
                    }
                }
                int temp = A[i];
                A[i] = A[minValIndex];
                A[minValIndex] = temp;
            }
        }

        private static int BubbleSort(int A[], int n){
            int swaps=0;

            for (int i = 0; i <n; i++) {
                for (int j = i+1; j <n; j++) {
                    if(A[i]>A[j]){
                        int temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                        swaps++;
                    }
                }
            }
            return swaps;
        }

        private static int InsertionSort(int A[], int n){
            int swaps=0;
            for (int i = 1; i <n; i++) {
                int temp = A[i];
                int j = i-1;
                while (j>=0&&A[j]>temp){
                    A[j+1]=A[j];
                    j--;
                    swaps++;
                }
                A[j+1]=temp;
            }
            return swaps;
        }

        private static void MergeSort(int A[], int n){

            if (n<2){
                return;
            }

            int mid = n/2;

            int left[] = new int[mid];
            int right[] = new int[n-mid];

            for (int i = 0; i <mid; i++) {
                left[i]=A[i];
            }

            for (int i = mid; i <n; i++) {
                right[i-mid]=A[i];
            }

            MergeSort(left,left.length);
            MergeSort(right,right.length);
            Merge(left,right,A);

        }

        private static void Merge(int [] left, int[] right, int[] A) {

            int nL = left.length,i=0,j=0,k=0,nR = right.length;
            while (i<nL&&j<nR){
                if(left[i]<=right[j]){
                    A[k]=left[i];
                    i++;
                }
                else{
                    A[k]=right[j];
                    j++;
                }
                k++;
            }

            while(i<nL){
                A[k]=left[i];
                i++;
                k++;
            }

            while(j<nR){
                A[k]=right[j];
                j++;
                k++;
            }

        }

        // TODO: 16-11-2016 Attain better understanding
        private static void QuickSort(int A[], int start, int end){
            if (start<end) {
                int pIndex = Partition(A,start,end);
                    QuickSort(A,start,pIndex-1);
                    QuickSort(A,pIndex+1,end);
            }

        }

        private static int Partition(int[] A, int start, int end) {

            int pivot = A[end];
            int pIndex = start;
            for (int i = start; i <end; i++) {
                if (A[i]<=pivot){
                    int temp = A[i];
                    A[i] = A[pIndex];
                    A[pIndex]=temp;
                    pIndex++;
//                    swaps++;
                }
            }
            int temp = A[pIndex];
            A[pIndex] = A[end];
            A[end]=temp;
            return pIndex;
        }


    }
