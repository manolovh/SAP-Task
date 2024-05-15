package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OddBuckets
{
	static final int NORMAL_WEIGHT = 10;
	static final int ODD_WEIGHT = 11;
	
	public static void main(String[] args)
	{
		// Random array. Code will also work with dynamically created
		//  or manually modified arrays of different sizes
		int[] inputBoxes = new int[] {
			ODD_WEIGHT, NORMAL_WEIGHT, NORMAL_WEIGHT, NORMAL_WEIGHT, ODD_WEIGHT,
			NORMAL_WEIGHT, NORMAL_WEIGHT, ODD_WEIGHT, ODD_WEIGHT, ODD_WEIGHT
		};
		
		// Create array of unique numbers of power of two
		int[] uniqueNums = new int[inputBoxes.length];
		for (int i = 0; i < uniqueNums.length; i++)
		{
			if (i == 0)
			{
				uniqueNums[i] = 1;
			} else
			{
				uniqueNums[i] = uniqueNums[i - 1] * 2;
			}
		}

		int sum = getBalls(uniqueNums, inputBoxes);
		List<Integer> oddBoxes = getOddBoxes(uniqueNums, sum);

		System.out.println(oddBoxes);
	}
	
	/** Finds odd boxes' numbers. 
	 *   
	 *  Subtracts from the total sum, the "base weight" (NORMAL_WEIGHT * numOfBallsTaken) of
	 *    the balls, taken from each box.
	 *    
	 *  A box with odd balls is a box, whose (weight * numOfBallsTaken - NORMAL_WEIGHT * numberOfBallsTaken)
	 *    is greater than zero and present in the sum. Adds to answer the odd box index + 1. (Avoids zero enumerated indexes)
	 */
	public static List<Integer> getOddBoxes(int[] uniqueNums, int sum)
	{
		var answer = new ArrayList<Integer>();

		for (int i = 0; i < uniqueNums.length; i++)
		{
			sum -= NORMAL_WEIGHT * uniqueNums[i];
		}

		sum /= ODD_WEIGHT - NORMAL_WEIGHT;
		String binarySum = Integer.toBinaryString(sum);
		
		for (int i = binarySum.length() - 1; i >= 0; i--)
		{
			if (binarySum.charAt(i) == '1')
			{
				answer.add(binarySum.length() - i);
			}
		}
		
		return answer;
	}
	
	/** Pick up one ball from the first box and doubles the count of balls taken
	 *   from each following box.
	 *  This will later help you differentiate which boxes have balls with "odd weight"
	 */
	public static int getBalls(int[] uniqueNums, int[] inputBoxes)
	{
		int sum = 0;

		for (int i = 0; i < uniqueNums.length; i++)
		{
			sum += uniqueNums[i] * inputBoxes[i];
		}
		
		return sum;
	}
}
