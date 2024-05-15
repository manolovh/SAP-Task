package assignment;

public class SpecialNumbers {

    public static void printNumbersInRange() {
        char[] number = new char[10];
        for (char curr_char = '1'; curr_char <= '9'; curr_char++)
        {
        	number[0] = curr_char;
        	printNumbersUtil(number, 1, curr_char - '0');
        }
    }

    public static void printNumbersUtil(char[] number, int currLength, int currSum) {
        if (currLength == number.length) {
//            System.out.println(number);
            return;
        }

        for (int newNum = 0; newNum <= 9; newNum++) {
        	if ((currSum + newNum) % (currLength + 1) == 0)
        	{
                number[currLength] = (char) ('0' + newNum);
                printNumbersUtil(number, currLength + 1, currSum + newNum);        		
        	}
        }
    }

    public static void main(String[] args) {
    	long startTime = System.nanoTime();

        printNumbersInRange();
        
    	long endTime = System.nanoTime();
    	
    	long timeInMilliseconds = (endTime - startTime) / 1000000;
    	System.out.println(timeInMilliseconds);
    }
}
