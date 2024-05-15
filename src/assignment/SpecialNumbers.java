package assignment;

public class SpecialNumbers
{
    public static void printSpecialNumbers()
    {
        boolean[] usedNumbers = new boolean[10];
        for (int currNum = 1; currNum <= 9; currNum++)
        {
        	usedNumbers[currNum] = true;
        	
        	printNumbersUtil(usedNumbers, currNum, 1);
        	
        	usedNumbers[currNum] = false;
        }
    }

    public static void printNumbersUtil(boolean[] usedNumbers, long number, int currLength)
    {
        if (currLength == 10)
        {
            System.out.println(number);
            return;
        }

        for (int newNum = 0; newNum <= 9; newNum++)
        {
        	if (!usedNumbers[newNum] && (number * 10 + newNum) % (currLength + 1) == 0)
        	{
        		usedNumbers[newNum] = true;
                printNumbersUtil(usedNumbers, number * 10 + newNum, currLength + 1);
                
                usedNumbers[newNum] = false;
        	}
        }
    }

    public static void main(String[] args)
    {
    	long startTime = System.nanoTime();

        printSpecialNumbers();
        
    	long endTime = System.nanoTime();
    	
    	long timeInMilliseconds = (endTime - startTime) / 1000000;
    	System.out.println(timeInMilliseconds);
    }
}
