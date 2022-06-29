package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class BuyAndSellStock {
  @EpiTest(testDataFile = "buy_and_sell_stock.tsv")
  public static double computeMaxProfit(List<Double> prices) {
    // TODO - you fill in here.
	Double max_profit = (double) 0;
	Double min_price = prices.get(0);
	
	for(int i=0; i< prices.size(); i++)
	{
		max_profit = Math.max(max_profit, prices.get(i) - min_price);
		min_price = Math.min(min_price, prices.get(i));
	}
	
    return max_profit;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStock.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
