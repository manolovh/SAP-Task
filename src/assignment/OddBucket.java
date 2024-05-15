package assignment;

import java.util.ArrayList;
import java.util.List;

public class OddBucket
{
	static final int REGULAR_WEIGHT = 10;
	static final int HEAVIER_WEIGHT = 11;
	
	public static void main(String[] args)
	{
		// Sample input
		int[] inputBoxes = new int[] {
			REGULAR_WEIGHT, REGULAR_WEIGHT, REGULAR_WEIGHT, HEAVIER_WEIGHT, REGULAR_WEIGHT,
			REGULAR_WEIGHT, HEAVIER_WEIGHT, HEAVIER_WEIGHT, REGULAR_WEIGHT, HEAVIER_WEIGHT
		};

		printOddBoxes(inputBoxes);
	}

	public static void printOddBoxes(int[] inputBoxes)
	{
		int[] powersOfTwoArray = new int[inputBoxes.length];

		for (int power = 0; power < powersOfTwoArray.length; power++)
		{
			powersOfTwoArray[power] = (int) Math.pow(2, power);
		}

		int heavierBallsSum = getHeavierBallsSum(powersOfTwoArray, inputBoxes);
		List<Integer> oddBoxes = getOddBoxes(powersOfTwoArray, heavierBallsSum);

		System.out.println(oddBoxes);
	}

	public static List<Integer> getOddBoxes(int[] powersOfTwoArray, int heavierBallsSum)
	{
		var answer = new ArrayList<Integer>();

		heavierBallsSum /= HEAVIER_WEIGHT - REGULAR_WEIGHT;
		String binaryBallSum = Integer.toBinaryString(heavierBallsSum);

		for (int index = binaryBallSum.length() - 1; index >= 0; index--)
		{
			if (binaryBallSum.charAt(index) == '1')
			{
				answer.add(binaryBallSum.length() - index);
			}
		}

		return answer;
	}

	public static int getHeavierBallsSum(int[] powersOfTwoArray, int[] inputBoxes)
	{
		int heavierBallsSum = 0;

		for (int index = 0; index < powersOfTwoArray.length; index++)
		{
			heavierBallsSum += inputBoxes[index] * powersOfTwoArray[index] - REGULAR_WEIGHT * powersOfTwoArray[index];
		}
		
		return heavierBallsSum;
	}
}
