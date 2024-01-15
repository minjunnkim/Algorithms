import java.util.*;
import java.io.*;

public class bj_10026 {

	static int n, ans, count;
	static String[][] a, a2;
	static int[] o = {-1,1,0,0};
	static int[] w = {0,0,-1,1};
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("10026.in"));
			out= new PrintWriter(new File("10026.out"));
			
			init();

			for(int i = 0; i < 2; i++) {
				out.print(solve() + " ");
				ans = 0;
				count++;
			}
			
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void init() {
		n = in.nextInt(); in.nextLine();
		a = new String[n][n];
		a2 = new String[n][n];
		count = 0;
		for(int i = 0; i < n; i++) {
			String temp = in.nextLine();
			for(int j = 0; j < n; j++) {
				a[i][j] = temp.charAt(j)+"";
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				a2[i][j] = a[i][j];
				if(a2[i][j].equals("G")) a2[i][j] = "R";
			}
		}
		ans = 0;
	}
	private static int solve() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(count == 1) {
					if(a2[i][j].equals("R") || a2[i][j].equals("B")) {
						String ch = a2[i][j];
						dfs(i, j, ch);
						ans++;
					}
				}
				else {
					if(a[i][j].equals("R") || a[i][j].equals("G") || a[i][j].equals("B")) {
						String ch = a[i][j];
						dfs(i, j, ch);
						ans++;
					}
				}
			}
		}
		return ans;
	}
	private static void dfs(int x, int y, String c) {
		if(count == 1) a2[x][y] = "N";
		else a[x][y]= "N";
			for(int j = 0; j < 4; j++) {
				int nx = x+o[j];
				int ny = y+w[j];
				if(nx<0 || ny < 0 || nx >= n || ny >= n) continue;
				if(count == 1) {
					if(a2[nx][ny].equals(c)) {
						dfs(nx, ny, c);
					}
				}
				else {
					if(a[nx][ny].equals(c)) {
						dfs(nx, ny, c);
					}
				}
			}
		}
	

	

}
