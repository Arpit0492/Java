package InterviewProblems; /**
 * Created by Arpit on 30-05-2017.
 */
import java.util.*;
public class CoinChange {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(coinChange(new int[]{431,62,88,428},90844));
//        System.out.println(coinChange(new int[]{2,4},8));
    }
    //BRUTE FORCE
    public static int coinChange(int[] coins, int amount) {

        //CORNER CASE
        if(amount==0)
            return 0;

        //Making a dictionary for all denominations we have
        HashMap<Integer,Integer> denominations = new HashMap<>();

        // transferring coins into denominations dictionary
        for (int c : coins)
            denominations.put(c,1);

        // A dictionary for all sum values from lowest till the actual amount that we can make from given denominations
        HashMap<Integer,Integer> combsUptoSum = new HashMap<>();

        //Building minimum combination denominations required starting from 1 to target Amount.
        for (int sum = 1; sum <=amount; sum++) {

            /*checking if sum is a denomination itself, then we don't need to check for its combination
              and simply add it in the combinations up to sum dictionary with combination value 1/
            */
            if (denominations.containsKey(sum))
                combsUptoSum.put(sum,1);

            else{
                /*Else we come here Now, every sum value is a combination of two halves,
                one is till the half of the sum (i.e sum/2) other one second half is (sum - first half).
                for eg: 12 can be represented by following combinations
                1,11 2,10 3,9 4,8 5,7 6,6
                 */
                int fh = sum/2, minComb = Integer.MAX_VALUE;

                for (int firstHalf = 1; firstHalf <=fh ; firstHalf++) {
                    int secondHalf = sum-firstHalf;
                    /*Now if we have both halves for a sum then target sum's combinations is simply the addition of the two
                      and then we find the minimum of all combinations.
                     */
                    if (combsUptoSum.containsKey(firstHalf) && combsUptoSum.containsKey(secondHalf)){
                        if (minComb > (combsUptoSum.get(firstHalf) + combsUptoSum.get(secondHalf))) {
                            minComb = (combsUptoSum.get(firstHalf) + combsUptoSum.get(secondHalf));
                            combsUptoSum.put(sum,minComb);
                        }
                    }
                }

                // I am doing this for every sum up to target amount, Hence getting TLE. Need to save results of previous sums i guess (MEMOIZATION CALLING)!

            }
        }


        // if target amount is there in the calculation above simply return the minimum combination for it. Else return -1.
        if (combsUptoSum.containsKey(amount))
            return combsUptoSum.get(amount);
        else
            return -1;

    }
}
