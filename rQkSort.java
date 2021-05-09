import java.util.Random;

class rQkSort 
{ 
    int rcount=0;

    int partition(int arr[], int p, int r) 
    { 
        
        int num = arr[r];  
        int i = (p-1); 
        for (int j=p; j<r; j++) 
        { 
            if (arr[j] < num) 
            { 
        
                i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 

        int temp = arr[i+1]; 
        arr[i+1] = arr[r]; 
        arr[r] = temp; 
  
        return i+1; 
    } 


    void QuickSort(int arr[], int p, int r) 
    { 
        if (p < r) 
        { 
            int q = partition(arr, p, r);
            rcount++; 
            QuickSort(arr, p, q-1); 
            rcount++;
            QuickSort(arr, q+1, r); 
            
        } 
    } 


    void Rcount(){
        System.out.print("Rcount = "+rcount);  
        rcount=0;
    }


    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 


    public static void main(String args[]) 
    { 
        
        Random rand = new Random(); 

        int[] arr=new int[1000];
        
        int n = 1000; 

        for(int i=0;i<n;i++){
            arr[i]= rand.nextInt(10000); 
            // System.out.print(arr[i]+" "); 

        }
        
        long start = System.currentTimeMillis();
        long startTime = System.nanoTime();

        rQkSort ob = new rQkSort(); 

        ob.QuickSort(arr, 0, n-1); 
        
        long end = System.currentTimeMillis();
        long endTime = System.nanoTime();

        System.out.print("\nsorted array \n"); 
        printArray(arr); 
        
        ob.Rcount();

        System.out.println("\nTime Taken for randam = "+(end-start)+" ms / "+(endTime-startTime)+" ns ");


         start = System.currentTimeMillis();
         startTime = System.nanoTime();

        ob.QuickSort(arr, 0, n-1);
        
         end = System.currentTimeMillis();
         endTime = System.nanoTime();

         ob.Rcount(); 
        System.out.println("\nTime Taken for sorted = "+(end-start)+" ms / "+(endTime-startTime)+" ns ");



        for(int i=0;i<1000;i++){
            arr[i]=i;
        }
        start = System.currentTimeMillis();
         startTime = System.nanoTime();

        ob.QuickSort(arr, 0, n-1);
        
         end = System.currentTimeMillis();
         endTime = System.nanoTime();

         ob.Rcount(); 
        System.out.println("\nTime Taken for diff = "+(end-start)+" ms / "+(endTime-startTime)+" ns ");



    } 
} 