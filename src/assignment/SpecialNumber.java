package assignment;

public class SpecialNumber
{
	static final int MAX_NUM_LENGTH = 10;
	
    public static void main(String[] args)
    {
    	long startTime = System.nanoTime();

    	boolean[] isNumberUsed = new boolean[MAX_NUM_LENGTH];
    	generateAndPrintSpecialNumbers(isNumberUsed, 0, 0);

    	long endTime = System.nanoTime();

    	long totalTimeInNanoseconds = endTime - startTime;
    	System.out.println(totalTimeInNanoseconds);
    }

    public static void generateAndPrintSpecialNumbers(boolean[] isNumberUsed, long currentNumber, int currentNumLength)
    {
        if (currentNumLength == MAX_NUM_LENGTH)
        {
            System.out.println(currentNumber);
            return;
        }

        for (int nextNumber = 0; nextNumber <= 9; nextNumber++)
        {
        	if (isSpecialNumber(isNumberUsed, currentNumber, nextNumber, currentNumLength))
        	{
        		isNumberUsed[nextNumber] = true;
        		generateAndPrintSpecialNumbers(isNumberUsed, currentNumber * 10 + nextNumber, currentNumLength + 1);
        		isNumberUsed[nextNumber] = false;
        	}
        }
    }
    
    public static boolean isSpecialNumber(boolean[] isNumberUsed, long currentNumber, int nextNumber, int currentNumLength)
    {
        return !(currentNumber == 0 && nextNumber == 0) && !isNumberUsed[nextNumber]
        		&& (currentNumber * 10 + nextNumber) % (currentNumLength + 1) == 0;
    }
}
