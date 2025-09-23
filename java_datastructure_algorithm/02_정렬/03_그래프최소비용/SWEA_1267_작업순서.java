import java.util.*;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// 위상정렬. 
		// 리프부터 치고 올라가며 0 을 반복적으로 queue 에 넣는 로직. 
		for (int tc = 1; tc <= 10; tc++) {
			System.out.print("#" + tc + " ");
			int V = sc.nextInt(); // 정점 3 - 1000 
			int E = sc.nextInt(); // 간선 2 - 3000
			
			// 해당 노드로 도착하는 정점의 수
			int[] inNum = new int[V+1];
			
			List<Integer>[] graphs = new ArrayList[V+1];
			for (int i = 1; i <= V; i++) {
				graphs[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				graphs[from].add(to);
				inNum[to]++;
			}
			
			// 초기 0 으로 시작하는 것들을 집어넣어주기 
			Queue<Integer> q = new ArrayDeque<>();
			for (int i = 1; i <= V; i++) {
				if (inNum[i] == 0) q.add(i);
			}
			
			while (!q.isEmpty()) {
				int cur = q.poll(); // 현재 q 에서 pop 해주기
				System.out.print(cur + " ");
				
				for (int adj : graphs[cur]) {
					inNum[adj]--; // 기록된 정점에 인접한 애들의 도착 정점을 줄여주자
					if (inNum[adj] == 0) q.add(adj); // 만약 줄여준 값이 0이라면 q에 추가해주자
				}
			}
			System.out.println();
			
			
			
		}
		
		
	}

}
