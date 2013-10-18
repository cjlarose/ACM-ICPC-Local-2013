import java.util.Scanner;


public class candy {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()) {
			int n = in.nextInt();
			if(n == 0) return;
			int steps = 0;
			int[] array = new int[n];
			for(int i = 0; i < n; i++) {
				array[i] = in.nextInt();
			}
			
			while(!allEqual(array)) {
				
				int[] array2 = new int[n];
				array2[0] = array[0]/2 + array[array.length-1]/2;
				for(int j = 1; j < array.length; j++) {
					array2[j] = array[j]/2 + array[j-1]/2;
				}
				array = array2;	
				
				for(int j = 0; j < array.length; j++) {
					if(array[j] % 2 == 1)
						array[j]++;
				}
				
				steps++;
			}
			
			System.out.println(steps + " " + array[0]);
		}
	}
	
	static boolean allEqual(int[] array) {
		if(array.length <= 1)
			return true;
		
		for(int i = 0; i < array.length-1; i++)
			if(array[i] != array[i+1])
				return false;
		
		return true;
	}

}
