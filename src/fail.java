import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
* Given a graph, how many disconnected subgraphs 
* remain when a node is removed?
*
* @author Chris LaRose
* @author Tanner Prynn
*/
public class fail {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		
		int i = 1;
		while (true) {
			Network network = new Network(null); 
			
			int u = in.nextInt();
			if (u == 0)
				break;
			int v = in.nextInt();
			network.add_edge(u, v);
			
			while (true) {
				u = in.nextInt();
				if (u == 0)
					break;
				v = in.nextInt();
				network.add_edge(u, v);
			}
			
			System.out.println("Network #" + i);
			network.print_spfs();
			i++;
		}
	}
	
	public static class Network {
		
		private Map<Integer, List<Integer>> map;
		
		public Network(Map<Integer, List<Integer>> init_map) {
			if (init_map != null)
				this.map = init_map;
			else
				this.map = new HashMap<Integer, List<Integer>>();
		}
		
		public void add_edge(int u, int v) {
			this.connect_verticies(u, v);
			this.connect_verticies(v, u);
		}
		
		private void connect_verticies(int u, int v) {
			List<Integer> neighbors = this.map.get(u);
			if (neighbors == null) {
				neighbors = new ArrayList<Integer>();
				this.map.put(u, neighbors);
			}
			neighbors.add(v);
		}
		
		private Set<Integer> visited;
		public int num_subnets() {		
			visited = new HashSet<Integer>();
			int num = 0;
			for(Integer v : this.map.keySet()) {
				if(!visited.contains(v)) {
					num++;
					visit(v);
				}
			}
			
			return num;
		}
		
		void visit(Integer v) {
			visited.add(v);
			List<Integer> neighbors = this.map.get(v);
			if(neighbors == null) return;
			
			for(Integer v1 : neighbors)
				if (!visited.contains(v1))
					visit(v1);
		}
		
		public Network remove_vertex(int v) {
			Map<Integer, List<Integer>> m2 = new HashMap<Integer, List<Integer>>();
			m2.putAll(this.map);
			m2.remove(v);
			return new Network(m2);
		}
		
		public void print_spfs() {
			boolean print_none = true;
			for (int v : this.map.keySet()) {
				// remove, check, count
				Network n2 = this.remove_vertex(v);
				int num = n2.num_subnets();
				if (num != 1) {
					print_none = false;
					System.out.println("  SPF node " + v + " leaves " + num + " subnets");
				}
			}
			if (print_none) 
				System.out.println("  No SPF nodes");
		}
		
	}
}
