import java.util.Scanner;


public class rhyme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (true) {
			int n = in.nextInt();
			if (n == 0)
				break;
			
			int answer = 1;
			for (int i = 1; i < n; i ++) {
				answer += factorial(i);
			}
			
			System.out.println(n + " " + answer);
		}
	}
	
	static double factorial(int n) {
		double res = 1;
		for(long i = n; i > 1; i--) {
			res = res * i;
		}
		return res;
	}

}
