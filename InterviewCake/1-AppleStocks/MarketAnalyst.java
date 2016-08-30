

public class MarketAnalyst {


    public int get_max_profit(int[] market) {
        
        //Iterate over array
        //Keep track of lowest int found and largest diff found
        //At each other element, calculate diff and see if largest
        
        //Check if smaller than two
        if(market.length < 2) {
            return -1; //Should probably throw an exception
        }
        
        int lowestPrice = market[0];
        int largestDiff = market[1] - market[0];

        for(int marketTime = 0; marketTime < market.length; marketTime++) {

            int currPrice = market[marketTime];

            if(currPrice < lowestPrice) {
                lowestPrice = currPrice;
            } else {
                if( (currPrice - lowestPrice) > largestDiff) {
                    largestDiff = currPrice - lowestPrice;
                }
            }

        }

        return largestDiff;

    }
}