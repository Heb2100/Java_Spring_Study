import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, cost;
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static final long INF = Long.MAX_VALUE;
    static int N, M;
    static List<Edge> edges = new ArrayList<>();
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        dist = new long[N + 1];
        Arrays.fill(dist, INF);

        // 벨만-포드 실행
        if (bellmanFord(1)) {
            System.out.println(-1); // 음수 사이클 존재
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) System.out.println(-1);
                else System.out.println(dist[i]);
            }
        }
    }

    // true면 음수 사이클 존재
    static boolean bellmanFord(int start) {
        dist[start] = 0;

        // N-1번 반복
        for (int i = 1; i < N; i++) {
            for (Edge e : edges) {
                if (dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost) {
                    dist[e.to] = dist[e.from] + e.cost;
                }
            }
        }

        // N번째에도 갱신된다면 음수 사이클 존재
        for (Edge e : edges) {
            if (dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost) {
                return true;
            }
        }
        return false;
    }
}
