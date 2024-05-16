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
			HEAVIER_WEIGHT, REGULAR_WEIGHT, REGULAR_WEIGHT, HEAVIER_WEIGHT, REGULAR_WEIGHT,
			REGULAR_WEIGHT, REGULAR_WEIGHT, HEAVIER_WEIGHT, REGULAR_WEIGHT, HEAVIER_WEIGHT
		};

		List<Integer> oddBoxes = getOddBoxes(inputBoxes);
		System.out.println(oddBoxes);
	}

	public static List<Integer> getOddBoxes(int[] inputBoxes)
	{
		int[] powersOfTwoArray = generatePowersOfTwoArray(inputBoxes.length);

		int totalBallsWeight = getTotalBallsWeight(powersOfTwoArray, inputBoxes);
		
		List<Integer> oddBoxes = findOddBoxes(powersOfTwoArray, totalBallsWeight);

		return oddBoxes;
	}

	public static List<Integer> findOddBoxes(int[] powersOfTwoArray, int totalBallsWeight)
	{
		var answer = new ArrayList<Integer>();

		int regularBallsWeight = 0;
		for (int numOfBalls: powersOfTwoArray)
		{
			regularBallsWeight += REGULAR_WEIGHT * numOfBalls;
		}

		totalBallsWeight -= regularBallsWeight;
		totalBallsWeight /= WEIGHT_DIFFERENCE;

		String binaryTotalBallsWeight = Integer.toBinaryString(totalBallsWeight);

		for (int index = binaryTotalBallsWeight.length() - 1; index >= 0; index--)
		{
			if (binaryTotalBallsWeight.charAt(index) == '1')
			{
				answer.add(binaryTotalBallsWeight.length() - index);
			}
		}

		return answer;
	}

	public static int getTotalBallsWeight(int[] powersOfTwoArray, int[] inputBoxes)
	{
		int totalBallsWeight = 0;

		for (int index = 0; index < powersOfTwoArray.length; index++)
		{
			totalBallsWeight += inputBoxes[index] * powersOfTwoArray[index];
		}
		
		return totalBallsWeight;
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
