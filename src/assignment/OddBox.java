package assignment;

import java.util.ArrayList;
import java.util.List;

public class OddBox
{
	static final int REGULAR_WEIGHT = 10;
	static final int HEAVIER_WEIGHT = 11;
	static final int WEIGHT_DIFFERENCE = HEAVIER_WEIGHT - REGULAR_WEIGHT;
	
	public static void main(String[] args)
	{
		// Sample input
		int[] inputBoxes = new int[] {
			REGULAR_WEIGHT, REGULAR_WEIGHT, REGULAR_WEIGHT, HEAVIER_WEIGHT, REGULAR_WEIGHT,
			REGULAR_WEIGHT, HEAVIER_WEIGHT, HEAVIER_WEIGHT, REGULAR_WEIGHT, HEAVIER_WEIGHT
		};

		List<Integer> oddBoxes = getOddBoxes(inputBoxes);
		System.out.println(oddBoxes);
	}

	public static List<Integer> getOddBoxes(int[] inputBoxes)
	{
		int[] powersOfTwoArray = generatePowersOfTwoArray(inputBoxes.length);

		int totalBallWeight = getTotalBallWeight(powersOfTwoArray, inputBoxes);
		
		List<Integer> oddBoxes = findOddBoxes(powersOfTwoArray, totalBallWeight);

		return oddBoxes;
	}

	public static List<Integer> findOddBoxes(int[] powersOfTwoArray, int totalBallWeight)
	{
		var answer = new ArrayList<Integer>();

		int regularBallWeight = 0;
		for (int numOfBalls: powersOfTwoArray)
		{
			regularBallWeight += REGULAR_WEIGHT * numOfBalls;
		}

		totalBallWeight -= regularBallWeight;
		totalBallWeight /= WEIGHT_DIFFERENCE;

		String binaryBallSum = Integer.toBinaryString(totalBallWeight);

		for (int index = binaryBallSum.length() - 1; index >= 0; index--)
		{
			if (binaryBallSum.charAt(index) == '1')
			{
				answer.add(binaryBallSum.length() - index);
			}
		}

		return answer;
	}

	public static int getTotalBallWeight(int[] powersOfTwoArray, int[] inputBoxes)
	{
		int totalBallWeight = 0;

		for (int index = 0; index < powersOfTwoArray.length; index++)
		{
			totalBallWeight += inputBoxes[index] * powersOfTwoArray[index];
		}
		
		return totalBallWeight;
	}
	
    public static int[] generatePowersOfTwoArray(int length)
    {
        int[] powersOfTwoArray = new int[length];

        for (int power = 0; power < length; power++)
        {
            powersOfTwoArray[power] = (int) Math.pow(2, power);
        }

        return powersOfTwoArray;
    }
}
