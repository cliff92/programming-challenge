package de.exxcellent.challenge;

import de.exxcellent.reader.IFileReader;
import de.exxcellent.utilities.Helper;

public class Data {

	public String[] labels;
	public String[][] data;

	/**
	 * When we construct this class, the data is read from the file with the
	 * forwarded reader. We transpose the data to easier work with it.
	 * 
	 * @param filePath
	 *            Path to the file
	 * @param reader
	 *            This reader is used to read the file with the forwarded file path
	 */
	public Data(String filePath, IFileReader reader) {
		if (reader != null && reader.readFile(filePath)) {

			labels = reader.getLabels();
			data = Helper.transposeMatrix(reader.getData());

		} else {
			System.out.println("Error during the reading of the file!");
		}
	}

	/**
	 * This method returns the value of the row with the smallest difference between
	 * two user defined columns
	 * 
	 * @param labelID
	 *            The value of this row is returned
	 * @param labelMax
	 *            Column label Max
	 * @param labelMin
	 *            Column label Min
	 * @return We return the value of the labelId row with the smallest difference
	 */
	public String findIdWithSmallestDifferenceBetweenTwoColumns(String labelID, String labelMax, String labelMin) {
		int columnMaxTemp = Helper.findColumnIDWithLabel(labels, labelMax);
		int columnMinTemp = Helper.findColumnIDWithLabel(labels, labelMin);

		if (columnMaxTemp < 0 && columnMinTemp < 0) {
			return "Min:Max: No label with this value";
		}

		String[] maxValues = data[columnMaxTemp];
		String[] minValues = data[columnMinTemp];

		int rowId = Helper.findIDWithMinimumDifference(maxValues, minValues);

		if (rowId < 0) {
			return "No minimum found";
		}

		int columnId = Helper.findColumnIDWithLabel(labels, labelID);

		if (columnId < 0) {
			return "No label with this value";
		}
		
		return data[columnId][rowId];
	}
}
