import java.util.*;
import java.io.*;

public class bj_1012 {
	
	static int n, m, g, ans;
	static int[][] a;
	static int[] o = {-1,1,0,0};
	static int[] w = {0,0,-1,1};
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("1012.in"));
			out = new PrintWriter(new File("1012.out"));
			
			int gi = in.nextInt();
			for(int i = 0; i < gi; i++) {
				init();
				out.println(solve());
			}
			
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
		g = in.nextInt();
		a = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				a[i][j] = 0;
			}
		}
		
		ans = 0;
	}
	private static int solve() {
		for(int k = 0; k < g; k++) {
			int tx = in.nextInt();
			int ty = in.nextInt();
			a[tx][ty] = 1;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(a[i][j] == 1) {
					dfs(i, j);
					ans++;
				}
			}
		}
		return ans;
	}
	private static void dfs(int x, int y) {
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
