package de.exxcellent.reader;

public interface IFileReader {

	/**
	 * This method reads the file under the given path. Afterward the labels and the
	 * data should be available over the corresponding methods.
	 * 
	 * @param filePath
	 *            Path of the file that should be read
	 * @return True if the file could be read and false if any sort of error
	 *         occurred.
	 */
	public boolean readFile(String filePath);

	public String[] getLabels();

	public String[][] getData();

}
