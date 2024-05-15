package assignment;

public class SpecialNumber
{
    public static void main(String[] args)
    {
    	long startTime = System.nanoTime();

    	boolean[] isNumberUsed = new boolean[10];
    	printSpecialNumber(isNumberUsed, 0, 0);

    	long endTime = System.nanoTime();

    	long totalTimeInNanoseconds = endTime - startTime;
    	System.out.println(totalTimeInNanoseconds);
    }

    public static void printSpecialNumber(boolean[] isNumberUsed, long currentNumber, int currentNumLength)
    {
        if (currentNumLength == 10)
        {
            System.out.println(currentNumber);
            return;
        }

        for (int nextNumber = 0; nextNumber <= 9; nextNumber++)
        {
        	if (currentNumber == 0 && nextNumber == 0)
        	{
        		continue;
        	}

        	if (!isNumberUsed[nextNumber] && (currentNumber * 10 + nextNumber) % (currentNumLength + 1) == 0)
        	{
        		isNumberUsed[nextNumber] = true;
        		printSpecialNumber(isNumberUsed, currentNumber * 10 + nextNumber, currentNumLength + 1);
        		isNumberUsed[nextNumber] = false;
        	}
        }
    }
}
