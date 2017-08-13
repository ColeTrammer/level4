package puzzle;

public class Stocks {

	public static void main(String[] args) {
		double[] stocks = { 2.3, 5.05, 9.08, 10.09, 3.53, 0.8, 11.14, 22.43, 1.1, 0.9, 24.5 };
		System.out.println(bestPrice(stocks)[0]);
		System.out.println(bestPrice(stocks)[1]);

	}

	public static double[] bestPrice(double[] prices) {

		double[] ans = { prices[0], prices[1] };

		double currentMin = prices[0];

		for (int i = 1; i < prices.length; i++) {
			if (currentMin > prices[i - 1]) {
				currentMin = prices[i - 1];
			}
			if (prices[i] - currentMin > ans[1] - ans[0]) {
				ans[0] = currentMin;
				ans[1] = prices[i];
			}
		}

		return ans;
	}

}
