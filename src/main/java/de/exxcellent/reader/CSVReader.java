package de.exxcellent.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.exxcellent.utilities.Helper;

public class CSVReader implements IFileReader {

	private String[] labels;
	private float[][] data;
	
	@Override
	public boolean readFile(String filePath) {
		BufferedReader bufferReader = null;
		String lineTmp;
		String csvSplitBy = ",";
		boolean firstLine = true;
		float[] tmpValues;
		List<float[]> dataTmp = new ArrayList<float[]>();
		
		try {
			bufferReader = new BufferedReader(new FileReader(filePath));
			while((lineTmp = bufferReader.readLine()) != null)
			{
				String [] lineSeperated = lineTmp.split(csvSplitBy);
				
				if(firstLine)
				{
					labels = lineSeperated;
					firstLine = false;
				}
				else 
				{
					tmpValues = new float[lineSeperated.length];
					for(int i=0;i<lineSeperated.length;i++)
					{
						tmpValues[i] = Float.parseFloat(lineSeperated[i]);
					}
					dataTmp.add(tmpValues);
				}
			}
			
			data = Helper.convertListOfArraysToMatrix(dataTmp);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return false;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
		finally 
		{
			if(bufferReader != null)
			{
				try {
					bufferReader.close();
				}
				catch(IOException e){
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public String[] getLabels() {
		return labels;
	}

	@Override
	public float[][] getData() {
		return data;
	}

	
}
