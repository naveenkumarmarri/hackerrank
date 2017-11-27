package com.practise.algos;

public class SetOfDenominations {

	public static void main(String args[])
    {
        int[] coinDenominations = {25,10,5,1};
        double totalAmountInDollars = 3.46;
        int[] numberOfEachCoin = getNumber(coinDenominations,totalAmountInDollars);
        for(int number : numberOfEachCoin)
            System.out.println(number);
    }

    private static int[] getNumber(int[] coinDenominations, double totalAmountInDollars) {
        int numberOfEachCoin[] = new int[coinDenominations.length];
        int totalAmountInCents = (int) (totalAmountInDollars*100);
        for(int i=0;i<coinDenominations.length;i++)
        {
            int denomination = coinDenominations[i];
            numberOfEachCoin[i] = totalAmountInCents/denomination;
            totalAmountInCents = totalAmountInCents%denomination;
        }
        return numberOfEachCoin;
    
	}

}
