import java.util.Scanner;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class rhyme {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			int n = in.nextInt();
			if (n == 0)
				break;

            if (n == 1) {
			    System.out.println("1 1");
                continue;
            }
			
            RhymeMaster rm = new RhymeMaster(n);
            System.out.printf(n + " %.0f%n", rm.rhyme());
		}
	}

    public static class RhymeMaster {

        int n;

        public RhymeMaster(int n) {
            this.n = n;
        }

        public double rhyme() {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(1, 1);
            for (int i = 2; i < n; i++) {
                map = expand_map(map);
                //print_map(map);
            }
            return sum(map);
        }

        public Map<Integer, Integer> expand_map(Map<Integer, Integer> map) {
            // value, multiplicity
            Map<Integer, Integer> new_map = new HashMap<Integer, Integer>();
            for (Entry e : map.entrySet()) {
                int k = (Integer) e.getKey();
                int v = (Integer) e.getValue();
                add_value(new_map, k+1, v);
                add_value(new_map, k, k * v);
            }
            return new_map;
        }

        public static void add_value(Map<Integer, Integer> map, int key, int multiplicity) {
            Integer m = map.get(key);
            if (m == null)
                map.put(key, multiplicity);
            else
                map.put(key, m + multiplicity);
        }

        public static double sum(Map<Integer, Integer> map) {
            double sum = 0;
            for (Entry e : map.entrySet()) {
                double k = (Integer) e.getKey();
                double v = (Integer) e.getValue();
                sum += (k + 1) * v;
            }
            return sum;
        }

        public static void print_map(Map<Integer, Integer> map) {
            String str = "";
            for (Entry e : map.entrySet())
                for (int i = 0; i < ((Integer) e.getValue()); i++)
                    str += "[1," + e.getKey() + "]";
            System.out.println(str);
        }

    }

}
