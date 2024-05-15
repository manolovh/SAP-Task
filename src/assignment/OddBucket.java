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
			HEAVIER_WEIGHT, REGULAR_WEIGHT, REGULAR_WEIGHT, REGULAR_WEIGHT, HEAVIER_WEIGHT,
			REGULAR_WEIGHT, REGULAR_WEIGHT, HEAVIER_WEIGHT, REGULAR_WEIGHT, HEAVIER_WEIGHT
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

		int ballsSum = selectBallsFromBoxes(powersOfTwoArray, inputBoxes);
		List<Integer> oddBoxes = getOddBoxes(powersOfTwoArray, ballsSum);

		System.out.println(oddBoxes);
	}

	public static List<Integer> getOddBoxes(int[] powersOfTwoArray, int ballSum)
	{
		var answer = new ArrayList<Integer>();

		for (int index = 0; index < powersOfTwoArray.length; index++)
		{
			ballSum -= REGULAR_WEIGHT * powersOfTwoArray[index];
		}

		ballSum /= HEAVIER_WEIGHT - REGULAR_WEIGHT;
		String binaryBallSum = Integer.toBinaryString(ballSum);

		for (int index = binaryBallSum.length() - 1; index >= 0; index--)
		{
			if (binaryBallSum.charAt(index) == '1')
			{
				answer.add(binaryBallSum.length() - index);
			}
		}
		
		return answer;
	}

	public static int selectBallsFromBoxes(int[] multiplicationArray, int[] inputBoxes)
	{
		int ballsSum = 0;

		for (int index = 0; index < multiplicationArray.length; index++)
		{
			ballsSum += multiplicationArray[index] * inputBoxes[index];
		}
		
		return ballsSum;
	}
}
