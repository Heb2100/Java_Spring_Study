import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int ID;
	int val;

	public Node(int ID, int val) {
		super();
		this.ID = ID;
		this.val = val;
	}

	public int compareTo(Node o) {
		// 최소힙을 구현해야 하므로 val 이 더 크면 뒤로 넘겨줘야 한다. 
		return this.val - o.val;
	}
}

public class Main {

	static void addEdge(int u, int v, int ww) {
		to[ptr] = v;
		w[ptr] = ww;
		nxt[ptr] = head[u];
		head[u] = ptr++;
	}
	static int V, E, ptr = 0;
	static int[] head;
	static int[] to;
	static int[] w;
	static int[] nxt;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // 정점 20000
		E = Integer.parseInt(st.nextToken()); // 간선 300000

		head = new int[V+1];
		to = new int[2*E];
		w = new int[2*E];
		nxt = new int[2*E];
		
		int init = Integer.parseInt(br.readLine()); // 시작점

		Arrays.fill(head, -1);
		
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int ww = Integer.parseInt(st.nextToken());
            addEdge(u, v, ww);          // 유향
            // 무방향이라면 아래 한 줄 추가:
            // addEdge(v, u, ww);
        }
		
		
		// 최소큐에 넣어주기
		PriorityQueue<Node> pq = new PriorityQueue<>(); // 갱신될 경우 계속 확인해주기
		int[] minLen = new int[V + 1];
		Arrays.fill(minLen, 3000000);
		minLen[init] = 0;
		pq.add(new Node(init, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			// 현재 더 좋은 값이 있다면 패스!
			if (cur.val > minLen[cur.ID]) continue;
			
			// 갱신할 수 있다면 minLen 을 바꿔주고 q 에 추가해서 그 주변도 한번 더 봐주기
			for (int e = head[cur.ID]; e != -1; e = nxt[e]) {
				int v = to[e];
				int nextval = cur.val + w[e];
				if (nextval < minLen[v]) {
					minLen[v] = nextval;
					pq.add(new Node(v, minLen[v]));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if (minLen[i] == 3000000) {
				bw.write("INF" + "\n");
			} else {
				bw.write(minLen[i] + "\n");

			}
		}
		bw.flush();
		bw.close();
		br.close();

	}

}