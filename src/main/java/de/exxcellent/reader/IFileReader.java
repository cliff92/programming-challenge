package de.exxcellent.reader;

public interface IFileReader {
	
	public boolean readFile(String filePath);
	
	public String[] getLabels();
	
	public float[][] getData();
	
}
