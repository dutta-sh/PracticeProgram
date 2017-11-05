package moodys;

import java.util.Scanner;

/*
* In a stock-market, there is one special product with infinite stocks. Its stock price is given for n days, where A[i] denotes the price of the stock
* on the i-th day. You are given q queries, each denoting a customer who is willing to buy the stock for price of atmost x. For each customer,
* find and print the last possible day that the customer can purchase the stock. If the purchase is not possible, print -1.
*/

public class Soln2 {
    static int stockPurchaseDay(int[] prices, int maxQuote, int maxPrice, int minPrice) {
        if(maxQuote >= maxPrice)
            return prices.length;
        if(maxQuote < minPrice)
            return -1;

        for(int i = prices.length - 1; i >= 0; i-- ) {
            if(maxQuote >= prices[i])
                return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int days = in.nextInt();
        int[] prices = new int[days];
        int maxPrice = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < days; i++){
            prices[i] = in.nextInt();
            if(minPrice > prices[i])
                minPrice = prices[i];

            if(maxPrice < prices[i])
                maxPrice = prices[i];
        }
        int cust = in.nextInt();
        for(int i = 0; i < cust; i++){
            int maxQuote = in.nextInt();
            int maxDay = stockPurchaseDay(prices, maxQuote, maxPrice, minPrice);
            System.out.println(maxDay);
        }
        in.close();
    }
}