
public class AppleStocks {
    public static void main(String[] args) {

        int[] stock_prices_yesterday = {10, 7, 5, 8, 11, 9};

        MarketAnalyst m = new MarketAnalyst();

        System.out.println(m.get_max_profit(stock_prices_yesterday));
    }
}

