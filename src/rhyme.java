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
            Map<Integer, Double> map = new HashMap<Integer, Double>();
            map.put(1, 1.0);
            for (int i = 2; i < n; i++)
                map = expand_map(map);
            //print_map(map);
            return sum(map);
        }

        public Map<Integer, Double> expand_map(Map<Integer, Double> map) {
            // value, multiplicity
            Map<Integer, Double> new_map = new HashMap<Integer, Double>();
            for (Entry e : map.entrySet()) {
                int k = (Integer) e.getKey();
                double v = (Double) e.getValue();
                add_value(new_map, k+1, v);
                add_value(new_map, k, k * v);
            }
            return new_map;
        }

        public static void add_value(Map<Integer, Double> map, int key, double multiplicity) {
            Double m = map.get(key);
            if (m == null)
                map.put(key, multiplicity);
            else
                map.put(key, m + multiplicity);
        }

        public static double sum(Map<Integer, Double> map) {
            double sum = 0;
            for (Entry e : map.entrySet()) {
                double k = (Integer) e.getKey();
                double v = (Double) e.getValue();
                sum += (k + 1) * v;
            }
            return sum;
        }

        public static void print_map(Map<Integer, Double> map) {
            String str = "";
            for (Entry e : map.entrySet())
                str += "[" + e.getKey() + ", " + e.getValue() + "]";
            System.out.println(str);
        }

    }

}
