import java.util.*;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for (tc = 1; tc <= 10; tc++) {
			
			int target = sc.nextInt();
			int size = target/10;
			
			int[][] dp = new int[size+1][8];
			int[] coins = new int[size+1];
			Arrays.fill(coins, Integer.MAX_VALUE);
			
			for (int i = 1; i < size+1; i++) {
//				System.out.println("coins" + Arrays.toString(coins));

				if (coins[i] > coins[i-1]+1) {
					coins[i] = coins[i-1]+1;
					for (int copy = 0; copy < 8; copy++) {
						dp[i][copy] = dp[i-1][copy];
					}
					dp[i][0]++;
				}
				
				
				if (i >= 5 && coins[i] > coins[i-5]+1) {
					coins[i] = coins[i-5]+1;
					for (int copy = 0; copy < 8; copy++) {
						dp[i][copy] = dp[i-5][copy];
					}
					dp[i][1]++;
				}
				
				
				if (i >= 10 && coins[i] > coins[i-10]+1) {
					coins[i] = coins[i-10]+1;
					for (int copy = 0; copy < 8; copy++) {
						dp[i][copy] = dp[i-10][copy];
					}
					dp[i][2]++;
				}
				
				
				if (i >= 50 && coins[i] > coins[i-50]+1) {
					coins[i] = coins[i-50]+1;
					for (int copy = 0; copy < 8; copy++) {
						dp[i][copy] = dp[i-50][copy];
					}
					dp[i][3]++;
				}
				
				
				if (i >= 100 && coins[i] > coins[i-100]+1) {
					coins[i] = coins[i-100]+1;
					for (int copy = 0; copy < 8; copy++) {
						dp[i][copy] = dp[i-100][copy];
					}
					dp[i][4]++;
				}
				
				
				if (i >= 500 && coins[i] > coins[i-500]+1) {
					coins[i] = coins[i-500]+1;
					for (int copy = 0; copy < 8; copy++) {
						dp[i][copy] = dp[i-500][copy];
					}
					dp[i][5]++;
				}
				
				
				if (i >= 1000 && coins[i] > coins[i-1000]+1) {
					coins[i] = coins[i-1000]+1;
					for (int copy = 0; copy < 8; copy++) {
						dp[i][copy] = dp[i-1000][copy];
					}
					dp[i][6]++;
				}
				
				
				if (i >= 5000 && coins[i] > coins[i-5000]+1) {
					coins[i] = coins[i-5000]+1;
					for (int copy = 0; copy < 8; copy++) {
						dp[i][copy] = dp[i-5000][copy];
					}
					dp[i][7]++;
				}
				
				
			}

			System.out.println("#" + tc);
			for (int i = 7; i >= 0; i--) {
				System.out.print(dp[size][i] + " ");
			}
			System.out.println();
			
			
		}
		
		
	}

}
