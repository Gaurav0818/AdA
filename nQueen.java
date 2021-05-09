import java.util.Scanner;
import java.util.*;

public class nQueen {

	static Scanner scan;
	static int N = 4;

    static List<List<Integer> > result
        = new ArrayList<List<Integer> >();
	
    static boolean solveNQUtil(int board[][], int col)
        {
            int N = board.length;
            if (col == N) {
     
                List<Integer> v = new ArrayList<>();
     
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (board[i][j] == 1)
                            v.add(j + 1);
                    }
                }
                result.add(v);
                return true;
        }
        boolean res = false;
        for (int i = 0; i < N; i++) {
            
            if (placement(board, i, col)) {
            
                board[i][col] = 1;
          
                res = solveNQUtil(board, col + 1) || res;
 
                board[i][col] = 0; 
            }
        }
        return res;
    }

    static List<List<Integer> > nqueen(int n)
    {
        result.clear();
        int board[][] = new int[n][n];
        solveNQUtil(board, 0);
         
        return result;
    }

	static void printBoard(int board[][]) {
		int i;
		for (i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				if (board[i][j] == 1) {
					System.out.print("Q\t");
				} else {
					System.out.print("_\t");
				}
			System.out.println("\n");
		}
	}

	static boolean placement(int board[][], int row, int col) {
		int i, j;
		for (i = 0; i < col; i++) {
			if (board[row][i] == 1)
				return false;
		}
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1)
				return false;
		}
		for (i = row, j = col; j >= 0 && i < N; i++, j--) {
			if (board[i][j] == 1)
				return false;
		}
		return true;
	}

	static boolean board(int board[][], int col) {
		if (col >= N)
			return true;
		for (int i = 0; i < N; i++) {
			if (placement(board, i, col)) {
				board[i][col] = 1;
				if (board(board, col + 1))
					return true;

				board[i][col] = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.println("State the value of N: ");
		N = scan.nextInt();
		int[][] board = new int[N][N];
		if (!board(board, 0)) {
			System.out.println("No Solution");
		}
		printBoard(board);

        List<List<Integer> > res = nqueen(N);
        System.out.println(res);
	}
}
