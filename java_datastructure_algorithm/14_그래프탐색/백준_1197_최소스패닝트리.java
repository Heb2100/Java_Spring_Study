import java.util.*;

class Edge implements Comparable<Edge>{
	
	int from;
	int to;
	int cost;
	
	public Edge(int from, int to, int cost) {
		super();
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	} 	
	
}

public class Solution {
	
	static int[] parents;
	
	static int findSet(int input) {
		if (input == parents[input]) return input;
		return parents[input] = findSet(parents[input]);
	}
	
	static void union(int x, int y) {
		int left = findSet(x);
		int right = findSet(y);
		parents[left] = right;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점 1 - 10000 
		int E = sc.nextInt(); // 간선 1 - 100000
		
		// 초기화
		parents = new int[V+1];
		for  (int i = 0; i <= V; i++) {
			parents[i] = i;
		}
		
		Edge[] edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			edges[i] = new Edge(from, to, cost);
		}
		
		Arrays.sort(edges);
		
		int cnt = 0; int pt = 0; int ans = 0;
		while (cnt < V-1) {
			Edge cur = edges[pt++];
			if (findSet(cur.from) != findSet(cur.to)) {
				cnt++;
				union(cur.from, cur.to);
				ans += cur.cost;
			}
		}
		System.out.println(ans);
		
		
		
	}

}
