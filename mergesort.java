import java.util.Random;
import java.util.Scanner;

public class mergesort {

    static void merge(int arr[], int l, int m, int r) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i;
        Random r = new Random();
        System.out.println("how many elements do u want \n");
        n = sc.nextInt();
        double startt = System.currentTimeMillis();
        int arr[] = new int[n];
        for (i = 0; i < n; i++) {
            arr[i] = r.nextInt(9000);
            System.out.println(arr[i]);
        }
        mergeSort(arr, 0, n - 1);
        double endt = System.currentTimeMillis();
        System.out.print("time taken = ");
        System.out.println(endt - startt);
        System.out.println("\nSorted array is \n");
        for (i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("decreasing orded");
        for (i = n - 1; i > 0; i--) {
            System.out.println(arr[i]);
        }
    }
}