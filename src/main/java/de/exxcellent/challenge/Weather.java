package de.exxcellent.challenge;

import de.exxcellent.reader.IFileReader;
import de.exxcellent.utilities.Helper;

public class Weather {
	
	public String [] labels;
	public float[][] data;
	
	public Weather(String filePath, IFileReader reader)
	{
		reader.readFile(filePath);
		labels = reader.getLabels();
		
		// we transpose the data matrix to have in each line all data points of one label
		data = Helper.transposeMatrix(reader.getData());
	}

	public int findDayWithSmallestTempSpread()
	{
		int columnMaxTemp = Helper.findColumnIDWithLabel(labels,"MxT");
		int columnMinTemp = Helper.findColumnIDWithLabel(labels,"MnT");
		
		if(columnMaxTemp < 0 && columnMinTemp < 0) 
		{
			return -1;
		}
			
		
		float[] maxTemperatures = data[columnMaxTemp];
		float[] minTemperatures = data[columnMinTemp];
		
		int rowId = Helper.findIDWithMinimumDifference(maxTemperatures,minTemperatures);
		
		if(rowId<0)
			return -1;
		
		int columnDay = Helper.findColumnIDWithLabel(labels, "Day");
		
		return (int) data[columnDay][rowId];
	}
	
	
}
