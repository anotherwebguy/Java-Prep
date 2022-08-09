import java.io.*;
import java.util.*;

public class Code {

    public static void heapify(int[] a, int i){
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left<a.length && a[left]<a[smallest]) smallest=left;
        if(right<a.length && a[right]<a[smallest]) smallest = right;
        if(smallest!=i){
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
            heapify(a,smallest);
        }
    }

    public static int partition(int[] a, int l, int r){
        int pivot = a[r];
        int i = l-1;
        for(int j=l;j<r;j++){
            if(a[j]<pivot){
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i+1];
        a[i+1] = a[r];
        a[r] = temp;
        return i+1;

    }

    public static void quicksort(int[] a, int l, int r){
        if(l<r){
            int p = partition(a,l,r);
            quicksort(a,l,p-1);
            quicksort(a,p+1,r);
        }
    }

    public static void merge(int[] a, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i=0;i<n1;i++) L[i] = a[i+l];
        for(int i=0;i<n2;i++) R[i] = a[i+m+1];
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(L[i]<R[j]){
                a[k++] = L[i++];
            } else {
                a[k++] = R[j++];
            }
        }
        while(i<n1){
            a[k++] = L[i++];
        }
        while(j<n2){
            a[k++] = R[j++];
        }
    }

    public static void mergesort(int[] a, int l, int r){
        if(l<r){
            int m = l+(r-l)/2;
            mergesort(a,l,m);
            mergesort(a,m+1,r);
            merge(a,l,m,r);
        }
    }
    public static void main(String[] args) {
        int[] a = { 3, 4, 1, 7, 2, 5, 10};

        //Selection Sort
        //O(n^2) time complexity
        for(int i=0;i<a.length;i++){
            int mini = i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[mini]){
                    mini = j;
                }
            }
            int temp = a[i];
            a[i] = a[mini];
            a[mini] = temp;
        }
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

        System.out.println();

        //Bubble Sort
        // O(n^2) worst
        for(int i=0;i<a.length-1;i++){
            boolean isSwapped = false;
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(isSwapped==false) break;
        }
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

        //Insertion Sort
        // O(n^2) worst
        for(int i=1;i<a.length;i++){
            int key = a[i];
            int j = i-1;
            while(j>=0 && a[j]>key){
                a[j+1] = a[j];
                j--; 
            }
            a[j+1] = key;
        }
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

        //Merge Sort
        //O(nlogn)
        mergesort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

        //Quick Sort
        //O(nlogn)
        quicksort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

        //heapsort
        //O(nlogn)
        for(int i=a.length/2 - 1;i>=0;i--){
            heapify(a,i);
        }
        for(int i=a.length-1;i>=0;i--){
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a,0);
        }
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

    }
}
