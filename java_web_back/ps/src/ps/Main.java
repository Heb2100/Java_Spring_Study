package ps;

import java.util.*;

public class Main {
	static int INF = 100000000;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 도시 (2 - 100)
		int E = sc.nextInt(); // 정점 (1 - 100000)
		
		int[][] map = new int[V+1][V+1];
		
		for (int i = 0; i <= V; i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			if (map[from][to] > cost) map[from][to] = cost;
		}
		
		
		for (int pass = 1; pass <= V; pass++) {
			for (int from = 1; from <= V; from++) {
				for (int to = 1; to <= V; to++) {
					if (map[from][to] > map[from][pass] + map[pass][to]) {
						map[from][to] = map[from][pass] + map[pass][to];
					}
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (map[i][j] == INF)
					System.out.print(0 + " ");
				else
					System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
