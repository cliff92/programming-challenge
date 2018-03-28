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
	
	public static int findIDWithMinimumDifference(String[] set1, String[] set2)
	{
		float minimumDifference = Float.MAX_VALUE;
		
		int minDifferenceIndex = -1;
		for(int i=0;i<Math.min(set1.length, set2.length);i++)
		{
			float diffTmp = Math.abs(Float.parseFloat(set1[i])-Float.parseFloat(set2[i]));
			if(diffTmp<minimumDifference)
			{
				minimumDifference = diffTmp;
				minDifferenceIndex = i;
			}	
		}
		return minDifferenceIndex;
	}
	
	public static String[][] convertListOfArraysToMatrix(List<String[]> listOfStringArrays)
	{
		String[] tmpValues;
		int maxLengthX = listOfStringArrays.size();
		int maxLengthY = 0;
		
		for(int i=0;i<listOfStringArrays.size();i++)
		{
			if(maxLengthY<listOfStringArrays.get(i).length)
			{
				maxLengthY = listOfStringArrays.get(i).length;
			}
		}
		
		String[][] data = new String [maxLengthX][maxLengthY];
		
		for(int i=0;i<maxLengthX;i++)
		{
			tmpValues = listOfStringArrays.get(i);
			for(int j=0;j<tmpValues.length;j++)
			{
				data[i][j]= tmpValues[j];
			}
		}
		return data;
	}
	
	public static String[][] transposeMatrix(String[][] data)
	{
		String[][] tmpMatrix = new String[data[0].length][data.length];
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[0].length; j++)
            	tmpMatrix[j][i] = data[i][j];
        return tmpMatrix;
	}
}
