import java.util.*;
import java.io.*;

public class Rumor_893C {

	static int n, m;
	static int[] cost;
	static String[] input;
	static ArrayList<Integer>[] a;
	static boolean[] v;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("893C.in"));
			out= new PrintWriter(new File("893C.out"));
			
			init();
			out.println(solve());
			
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void init() {
		
		input =in.nextLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		cost = new int[n+1];
		v = new boolean[n+1];
		a = new ArrayList[n+1];
		for(int i = 0; i < n; i++) {
			cost[i+1] = Integer.parseInt(input[i]);
			a[i+1] = new ArrayList<>();
		}

		for(int i = 0; i < m; i++) {
			input = in.nextLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			a[x].add(y);
			a[y].add(x);
		}
	}
	private static long solve() {
		long cost = 0;
		for(int i = 1; i <= n; i++) {
			if(!v[i]) cost += dfs(i);

		}
		return cost;
	}
	private static long dfs(int i) {
		v[i] = true;
		
		long min = cost[i];
		for(int c : a[i]) {
			if(!v[c]) min = Math.min(min,  dfs(c));
		}
		return min;
		
		
	}
	

	

}
