package de.exxcellent.utilities;

import java.util.List;

public class Helper {
	public static int findColumnIDWithLabel(String[]labels, String label)
	{
		for(int i=0;i<labels.length;i++)
		{
			if(labels[i].equals(label))
			{
				return i;
			}
		}
		return -1;
	}
	
	public static int findIDWithMinimumDifference(float[] set1, float[] set2)
	{
		float minimumDifference = Float.MAX_VALUE;
		
		int minDifferenceIndex = -1;
		for(int i=0;i<Math.min(set1.length, set2.length);i++)
		{
			float diffTmp = Math.abs(set1[i]-set2[i]);
			if(diffTmp<minimumDifference)
			{
				minimumDifference = diffTmp;
				minDifferenceIndex = i;
			}	
		}
		return minDifferenceIndex;
	}
	
	public static float[][] convertListOfArraysToMatrix(List<float[]> listOfFloatArrays)
	{
		float[] tmpValues;
		int maxLengthX = listOfFloatArrays.size();
		int maxLengthY = 0;
		
		for(int i=0;i<listOfFloatArrays.size();i++)
		{
			if(maxLengthY<listOfFloatArrays.get(i).length)
			{
				maxLengthY = listOfFloatArrays.get(i).length;
			}
		}
		
		float[][] data = new float [maxLengthX][maxLengthY];
		
		for(int i=0;i<maxLengthX;i++)
		{
			tmpValues = listOfFloatArrays.get(i);
			for(int j=0;j<tmpValues.length;j++)
			{
				data[i][j]= tmpValues[j];
			}
		}
		return data;
	}
	
	public static float[][] transposeMatrix(float[][] data)
	{
		float[][] tmpMatrix = new float[data[0].length][data.length];
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[0].length; j++)
            	tmpMatrix[j][i] = data[i][j];
        return tmpMatrix;
	}
}
