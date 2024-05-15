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
		int[] uniqueNums = new int[] {1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
		int[] inputBoxes = new int[] {
			NORMAL_WEIGHT, ODD_WEIGHT, NORMAL_WEIGHT, NORMAL_WEIGHT, ODD_WEIGHT,
			NORMAL_WEIGHT, NORMAL_WEIGHT, NORMAL_WEIGHT, ODD_WEIGHT, ODD_WEIGHT
		};
		
		int sum = getBalls(uniqueNums, inputBoxes);
		List<Integer> oddBoxes = getOddBoxes(uniqueNums, sum);

		System.out.println(oddBoxes);
	}
	
	/** Finds odd boxes' numbers. 
	 *   
	 *  Subtracts from the total sum, the "base weight" (NORMAL_WEIGHT * numOfBallsTaken) of
	 *    the balls, taken from each box.
	 *    
	 *  A box with odd weight is a box, whose (weight * numOfBallsTaken - NORMAL_WEIGHT * numberOfBallsTaken)
	 *    is greater than zero and present in the sum. Adds to answer the odd box index + 1. (Avoids zero enumerated indexes)
	 */
	public static List<Integer> getOddBoxes(int[] uniqueNums, int sum)
	{
		var answer = new ArrayList<Integer>();

		for (int i = 0; i < uniqueNums.length; i++)
		{
			sum -= NORMAL_WEIGHT * uniqueNums[i];
		}

		for (int i = uniqueNums.length - 1; i >= 0; i--)
		{
			if (uniqueNums[i] <= sum)
			{
				answer.add(i + 1);
				sum -= uniqueNums[i];
			}
		}
		
		Collections.reverse(answer);
		
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
