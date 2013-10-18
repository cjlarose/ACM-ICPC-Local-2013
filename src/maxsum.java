import java.util.Scanner;

/**
* Given 2D array, what is the maximum sum over all 2D sub-arrays?
*
* @author Chris LaRose
*/
public class maxsum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		System.out.println(max_sum(matrix));
	}
	
	public static int max_sum(int[][] m) {
		Integer max = null;
		int n = m.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int i2 = i; i2 < n; i2++) {
					for (int j2 = j; j2 < n; j2++) {
						int sub_sum = sub_matrix_sum(m, i, j, i2, j2);
						if (max == null || sub_sum > max)
							max = sub_sum;
					}
				}
			}
		}
		return max;
	}
	
	public static int sub_matrix_sum(int[][] m, int i1, int j1, int i2, int j2) {
		int sum = 0;
		for (int i = i1; i <= i2; i++) {
			for (int j = j1; j <= j2; j++) {
				sum += m[i][j];
			}
		}
		return sum;
	}
}
