import java.util.*;
import java.io.*;

public class PBnF_755C {

	static int n, m, ans;
	static ArrayList<Integer> []a;
	static boolean[] v;
	static int[] o = {-1,1,0,0};
	static int[] w = {0,0,-1,1};
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("755C.in"));
			out= new PrintWriter(new File("755C.out"));
			
			init();
			solve();
			
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void init() {
		n = in.nextInt();
		a = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		v = new boolean[n];
		for(int i = 0; i < n; i++) {
			int x = in.nextInt();
			a[i].add(x);
			a[x].add(i);
			
		}
		ans = 0;
	}
	private static void solve() {
		for(int i = 1; i <= n; i++) {
			if(!v[i]) { 
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
	}
	private static void dfs(int index) {
		a[x][y]=0;
			for(int j = 0; j < 4; j++) {
				int nx = x+o[j];
				int ny = y+w[j];
				if(nx<0 || ny < 0 || nx >= n || ny >= m) continue;
				if(a[nx][ny] == 1) {
					dfs(nx, ny);
				}
			}
		}
	

	

}
