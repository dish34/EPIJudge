package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class BuyAndSellStockTwice {
  @EpiTest(testDataFile = "buy_and_sell_stock_twice.tsv")
  public static double buyAndSellStockTwice(List<Double> prices) {
    // TODO - you fill in here.
	Double minSoFar = prices.get(0);
	Double maxTotalProfit = 0.0;
	List<Double> firstBuySell = new ArrayList<>();

	for (int i = 0; i < prices.size(); i++) {
		minSoFar = Math.min(minSoFar, prices.get(i));
		maxTotalProfit = Math.max(prices.get(i) - minSoFar, maxTotalProfit);
		firstBuySell.add(maxTotalProfit);
	}
	Double maxPriceSoFar = 0.0;
	for (int i = prices.size() - 1; i > 0; i--) {
		maxPriceSoFar = Math.max(maxPriceSoFar, prices.get(i));
		maxTotalProfit = Math.max(maxTotalProfit, maxPriceSoFar - prices.get(i) + firstBuySell.get(i - 1));
	}
	return maxTotalProfit;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStockTwice.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
