package de.exxcellent.challenge;

import de.exxcellent.reader.IFileReader;
import de.exxcellent.utilities.Helper;

public class Data {
	
	public String [] labels;
	public String[][] data;
	
	public Data(String filePath, IFileReader reader)
	{
		if(reader.readFile(filePath))
		{
			labels = reader.getLabels();
			
			// we transpose the data matrix to have in each line all data points of one label
			data = Helper.transposeMatrix(reader.getData());
		}
		else 
		{
			System.out.println("Error during the reading of the file!");
		}
	}

	public String findIdWithSmallestDifferenceBetweenTwoColumns(String labelID, String labelMax, String labelMin)
	{
		int columnMaxTemp = Helper.findColumnIDWithLabel(labels,labelMax);
		int columnMinTemp = Helper.findColumnIDWithLabel(labels,labelMin);
		
		if(columnMaxTemp < 0 && columnMinTemp < 0) 
		{
			return "No Value";
		}
			
		
		String[] maxValues = data[columnMaxTemp];
		String[] minValues = data[columnMinTemp];
		
		int rowId = Helper.findIDWithMinimumDifference(maxValues,minValues);
		
		if(rowId<0)
			return "No Value";
		
		int columnDay = Helper.findColumnIDWithLabel(labels, labelID);
		
		return data[columnDay][rowId];
	}
}
