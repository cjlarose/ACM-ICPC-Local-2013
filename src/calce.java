

public class calce {

	public static void main(String[] args) {
		System.out.println("n e");
		System.out.println("- ----------");
		for(int n = 0; n <= 9; n++) {
			double e = 0;
			for(int i = 0; i <= n; i++) {
				e += 1/((double)factorial(i));
			}
			/*
			if(n == 0)
				System.out.println(0 + " " + 1);
			else if(n == 1)
				System.out.println(1 + " " + 2);
				*/
			System.out.println(n + " " + e);
		}
	}
	
	static long factorial(int n) {
		long res = 1;
		for(long i = n; i > 1; i--) {
			res = res * i;
		}
		return res;
	}
}

