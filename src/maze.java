import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;


public class maze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int i = 0;
		while (true) {
			int d = in.nextInt();
			if (d == 0) 
				break;
			
			maze maze = new maze();
			Point start = maze.next_point(in, d);
			Point end = maze.next_point(in, d);

			while (true) {
				Point p1 = maze.next_point(in, d);
				if (p1 == null)
					break;
				Point p2 = maze.next_point(in, d);
				maze.add_link(p1, p2);
			}
			
			boolean path_exists = maze.path_exists(start, end);
			System.out.println("Maze #" + (i+1) + " " + (path_exists ? "can" : "cannot") + " be travelled");
			i++;
		}
	}
	
	Map<Point, List<Point>> map;
	public maze() {
		this.map = new HashMap<Point, List<Point>>();
	}
	
	public void add_link(Point p1, Point p2) {
		this.set_adjacent(p1, p2);
		this.set_adjacent(p2, p1);
	}
	
	private void set_adjacent(Point p1, Point p2) {
		List<Point> neighbors = this.map.get(p1);
		if (neighbors == null) {
			neighbors = new ArrayList<Point>();
			this.map.put(p1, neighbors);
		}
		neighbors.add(p2);
	}
	
	public class Point {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + Arrays.hashCode(arr);
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (!Arrays.equals(arr, other.arr))
				return false;
			return true;
		}
		
		private int[] arr;
		
		public Point(int[] arr) {
			this.arr = arr;
		}
		
		@Override
		public String toString() {
			String str = "[";
			for (int i : arr) {
				str += i + ",";
			}
			str += "]";
			return str;
		}
		
		private maze getOuterType() {
			return maze.this;
		}
	}
	
	Point next_point(Scanner in, int d) {
		int[] start = new int[d];
		for (int i = 0; i < d; i++) {
			int num = in.nextInt();
			if (num < 0)
				return null;
			start[i] = num;
		}
		return new Point(start);
	}
	
	 boolean path_exists(Point src, Point dest) {
		Set<Point> visited = new HashSet<Point>();
		Queue<Point> to_visit = new LinkedList<Point>();
		to_visit.add(src);
		while (!to_visit.isEmpty()) {
			Point u = to_visit.remove();
			
			List<Point> neighbors = this.map.get(u);
			if (neighbors != null) {
				for (Point v : neighbors) {
					if (v.equals(dest))
						return true;
					if (!visited.contains(v))
						to_visit.add(v);
				}
			}
			
			visited.add(u);
		}
		return false;
	}

}
