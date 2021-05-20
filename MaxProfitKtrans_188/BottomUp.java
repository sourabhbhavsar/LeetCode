
public class BottomUp {

	public static int maxProfit(int k, int[] prices) {

		return maxProfitDP(prices, k, prices.length - 1, table);
	}

	public static int maxProfitDPbottomUp(int k, int[] prices) { 
		int n = prices.length;
		int[][] table = new int[k + 1][n];
		
		// if no prices then profit will be 0
		for (int i = 0; i <= k; i++) {
			table[i][0] = 0;
		}
		
		// if we are not allowed to make any transactions, profit will be 0.
		for (int j = 0; j < n; j++) {
			table[0][j] = 0;
		}
		
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < n; j++) {
				int notSoldHere = table[i][j - 1];
				
				// if sold here
				int maxProfitSoFar = 0;
				for (int m = 0; m < j; m++) {
					int profitSoldHere = prices[j] - prices[m];
					
					maxProfitSoFar = Math.max(maxProfitSoFar, 
							profitSoldHere + table[i - 1][m]);
				}
				
				int maxProfitHere = Math.max(maxProfitSoFar, notSoldHere);
				table[i][j] = maxProfitHere;
			}
		}
		
		
		return table[k][n - 1];
	}

	
public class MaxProfitWithKtransaction {

	public static int maxProfit(int k, int[] prices) {
		int[][] table = new int[k + 1][prices.length + 1];
		for (int i = 0; i <= k; i++) {
			for (int j = 0; j <= prices.length; j++) {
				table[i][j] = -1;
			}
		}

		return maxProfitDP(prices, k, prices.length - 1, table);
	}

	public static int maxProfitDPbottomUp(int k, int[] prices) { 
		int n = prices.length;
		int[][] table = new int[k + 1][n];
		
		// if no prices then profit will be 0
		for (int i = 0; i <= k; i++) {
			table[i][0] = 0;
		}
		
		// if we are not allowed to make any transactions, profit will be 0.
		for (int j = 0; j < n; j++) {
			table[0][j] = 0;
		}
		
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < n; j++) {
				int notSoldHere = table[i][j - 1];
				
				// if sold here
				int maxProfitSoFar = 0;
				for (int m = 0; m < j; m++) {
					int profitSoldHere = prices[j] - prices[m];
					
					maxProfitSoFar = Math.max(maxProfitSoFar, 
							profitSoldHere + table[i - 1][m]);
				}
				
				int maxProfitHere = Math.max(maxProfitSoFar, notSoldHere);
				table[i][j] = maxProfitHere;
			}
		}
		
		
		return table[k][n - 1];
	}

	// Driver code
	public static void main(String []args)
	{
		int k = 2;
		int[] prices = { 10, 22, 5, 75, 65, 80 };
		int n = prices.length;
		System.out.println("Maximum profit is: " +
				maxProfitDPbottomUp(k, prices));

		int[] prices2 = {12, 14, 17, 10, 14, 13, 12, 15};
		System.out.println("Maximum profit is: " +
				maxProfitDPbottomUp(3, prices2));

		int[] prices3 = {100, 30, 15, 10, 8, 25, 80};
		System.out.println("Maximum profit is: " +
				maxProfitDPbottomUp(3, prices3));

		int[] prices4 = {90, 80, 70, 60, 50};
		System.out.println("Maximum profit is: " +
				maxProfitDPbottomUp(1, prices4));
	}
}

}
