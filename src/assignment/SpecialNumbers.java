package assignment;

public class SpecialNumbers
{
    public static void printNumbersInRange()
    {
        StringBuilder number = new StringBuilder("0000000000");
        boolean[] usedNumbers = new boolean[10];
        for (char currChar = '1'; currChar <= '9'; currChar++)
        {
        	number.setCharAt(0, currChar);
        	usedNumbers[currChar - '0'] = true;
        	
        	printNumbersUtil(usedNumbers, number, 1, currChar - '0');
        	
        	usedNumbers[currChar - '0'] = false;
        }
    }

    public static void printNumbersUtil(boolean[] usedNumbers, StringBuilder number, int currLength, int currSum)
    {
        if (currLength == 10)
        {
            System.out.println(number.toString());
            return;
        }

        for (int newNum = 0; newNum <= 9; newNum++)
        {
        	number.setCharAt(currLength, (char) (newNum + '0'));
        	if (usedNumbers[newNum] == false && Long.parseLong(number.substring(0, currLength+1)) % (currLength + 1) == 0)
        	{
        		usedNumbers[newNum] = true;
                printNumbersUtil(usedNumbers, number, currLength + 1, currSum + newNum);
                
                usedNumbers[newNum] = false;
        	}
        }
    }

    public static void main(String[] args)
    {
    	long startTime = System.nanoTime();

        printNumbersInRange();
        
    	long endTime = System.nanoTime();
    	
    	long timeInMilliseconds = (endTime - startTime) / 1000000;
    	System.out.println(timeInMilliseconds);
    }
}
