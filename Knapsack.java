class Knapsack {

	
	static int max(int a, int b) 
	{ 
		return (a > b) ? a : b; 
	}
	
	public static void main(String args[])
	{
		int val[] = new int[] { 12, 7, 16, 20 };
		int wt[] = new int[] { 4, 3, 6, 2 };
		int W = 12;
		int n = val.length;
		int i,j, w;
		int K[][] = new int[n + 1][W + 1];
	
		for (i = 0; i <= n; i++) 
		{
			for (w = 0; w <= W; w++) 
			{
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w]
						= max(val[i - 1]
						+ K[i - 1][w - wt[i - 1]],
						K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}	

		System.out.println("Total Profit: "+ K[n][W]+"\n");

		i=n;
		j=W;
		System.out.println("Items chosen:");
		while(i>0 && j>-1)
		{
		if(K[i][j]==K[i-1][j])
		{
			System.out.println("Item "+i+" = 0");
			i--;
		}

		else{
			System.out.println("Item "+i+" = 1");
			i--;
			j=j-wt[i];
		
			}
		}
		
	}
}


			
