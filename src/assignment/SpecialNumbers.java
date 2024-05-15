package assignment;

public class SpecialNumbers
{
    public static void printSpecialNumbers()
    {
        boolean[] usedNumbers = new boolean[10];
        for (int currNum = 1; currNum <= 9; currNum++)
        {
        	usedNumbers[currNum] = true;
        	
        	createSpecialNumber(usedNumbers, currNum, 1);
        	
        	usedNumbers[currNum] = false;
        }
    }

    public static void createSpecialNumber(boolean[] usedNumbers, long number, int currLength)
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
        		createSpecialNumber(usedNumbers, number * 10 + newNum, currLength + 1);
                
                usedNumbers[newNum] = false;
        	}
        }
    }

    public static void main(String[] args)
    {
    	long startTime = System.nanoTime();

        printSpecialNumbers();
        
    	long endTime = System.nanoTime();
    	
    	long timeInNanoseconds = endTime - startTime;
    	System.out.println(timeInNanoseconds);
    }
}
