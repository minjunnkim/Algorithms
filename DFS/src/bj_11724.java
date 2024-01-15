import java.util.*;
import java.io.*;

public class bj_11724 {

	static int n, m;
	static ArrayList<Integer>[] a;
	static boolean[] v;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("11724.in"));
			out= new PrintWriter(new File("11724.out"));
			
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
		n = in.nextInt();
		m = in.nextInt();
		a = new ArrayList[n+1];
		v = new boolean[n+1];
		for(int i = 0; i < n+1; i++) {
			a[i] = new ArrayList<Integer>();
		}

		for(int i = 0; i < m; i++) {
			int n1 = in.nextInt();
			int n2 = in.nextInt();
			a[n1].add(n2);
			a[n2].add(n1);
			
		}
	}
	private static String solve() {
		int ans = 0;
		for(int i = 1; i <= n; i++) {
			if(!v[i]) {
				dfs(i);
				ans++;
			}
		}
		return ans+"";
	}
	private static void dfs(int s) {
		if(v[s]) return;
		v[s] = true;
		for(int i : a[s]) {
			if(!v[i]) dfs(i);
		}
	}
	

	

}
