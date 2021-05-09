import java.util.Scanner;
class OBST
{
    public static void main(String Happy[])
    {
        Scanner s=new Scanner(System.in);
		System.out.println("Enter no. of Elements: ");5
        int n=s.nextInt();
        float arr[][]=new float[n+1][n+1];
        arr[0][0]=0;
        for(int i=1;i<=n;i++)
        {
                System.out.print("Input Key "+(i)+": ");
                arr[i][i]=s.nextFloat();
        }

        for(int i=1;i<=n-1;i++)
        {
            for(int j=1,k=i+1;k<=n;k++,j++)
            {
                arr[j][k]=Cost(arr,j,k,n);
            }
        }
        System.out.println();
        System.out.println();
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static float Cost(float arr[][],int i,int j,int n)
    {
        float sum=0;
        for(int m=i;m<=j;m++)
            sum+=arr[m][m];
        float temp;
        float cost1=arr[i][i-1];
        float cost2=arr[i+1][j];
        float min=cost1+cost2;
        for(int b=i+1;b<=j;b++)
        {
            cost1=arr[i][b-1];
            if(b+1<=n)
                cost2=arr[b+1][j];
            else 
                cost2=0;
            temp=cost1+cost2;
            if(temp<min)
                min=temp;
        }
        return min+sum;
    }

}