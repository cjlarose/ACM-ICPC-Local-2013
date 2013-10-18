import java.math.BigInteger;
import java.util.Scanner;


public class roots {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger n;
		while(in.hasNext()) {
			n = new BigInteger(in.nextLine());
			if(n.equals(BigInteger.ZERO)) return;
			System.out.println(root(n));
		}
	}
	
	static int root(BigInteger n) {
		String s = n.toString();
		BigInteger x = new BigInteger(s);
		
		while(s.length() > 1) {
			x = new BigInteger("0");
			for(int i = 0; i < s.length(); i++) {
				x = x.add(new BigInteger(s.charAt(i) + ""));
			}
			s = x.toString();
		}
		
		return x.intValue();
	}

}
