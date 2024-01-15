import java.util.*;
import java.io.*;

public class bj_2667 {
	
	static int n, g, ans;
	static int[][] a;
	static int[] o = {-1,1,0,0};
	static int[] w = {0,0,-1,1};
	static ArrayList<Integer> arr;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("2667.in"));
			out= new PrintWriter(new File("2667.out"));
			
			init();
			solve();
			out.println(arr.size());
			Collections.sort(arr);
			for(int i = 0; i < arr.size(); i++) {
				out.println(arr.get(i));
			}	
			
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void init() {
		arr = new ArrayList<Integer>();
		n = in.nextInt(); in.nextLine();
		a = new int[n][n];
		for(int i = 0; i < n; i++) {
			String temp = in.nextLine();
			for(int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(temp.charAt(j)+"");
			}
		}
		ans = 0;
		g = 1;
	}
	private static void solve() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(a[i][j] == 1) {
					dfs(i, j);
					arr.add(g);
					g = 1;
				}
			}
		}
	}
	private static void dfs(int x, int y) {
		a[x][y]=0;
			for(int j = 0; j < 4; j++) {
				int nx = x+o[j];
				int ny = y+w[j];
				if(nx<0 || ny < 0 || nx >= n || ny >= n) continue;
				if(a[nx][ny] == 1) {
					g++;
					dfs(nx, ny);
				}
			}
	}
}
