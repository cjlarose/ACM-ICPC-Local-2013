import java.util.Scanner;


public class sum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a, b;
		for(int i = 0; i < n; i++) {
			a = in.nextInt();
			b = in.nextInt();
			System.out.println(a+b);
		}

	}

}
