import java.math.BigInteger;
import java.util.Scanner;


public class cyclic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			String str = in.next();
			int n = str.length();
			boolean cyclic = true;
			BigInteger big_int = new BigInteger(str);
			for (int i = 1; i <= n; i++) {
				if (!is_cyclic(str, big_int.multiply(new BigInteger(n + "")).toString() )) {
					cyclic = false;
					break;
				}
			}
			System.out.println(str + " is " + (cyclic ? "" : "not ") + "cyclic");
		}
	}
	
	private static boolean is_cyclic(String str1, String str2) {
		return (str1 + str1).contains(str2);
	}

}
