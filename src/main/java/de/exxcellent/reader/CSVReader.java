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
	private String[][] data;

	@Override
	public boolean readFile(String filePath) {
		BufferedReader bufferReader = null;
		String lineTmp;
		String splitBy = ",";
		boolean firstLine = true;
		List<String[]> dataTmp = new ArrayList<String[]>();

		try {
			bufferReader = new BufferedReader(new FileReader(filePath));
			while ((lineTmp = bufferReader.readLine()) != null) {
				String[] lineSeperated = lineTmp.split(splitBy);

				// We read the first line separately because in our case the labels
				// are stored in it
				if (firstLine) {
					labels = lineSeperated;
					firstLine = false;
				} else {
					dataTmp.add(lineSeperated);
				}
			}

			data = Helper.convertListOfArraysToMatrix(dataTmp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (bufferReader != null) {
				try {
					bufferReader.close();
				} catch (IOException e) {
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
	public String[][] getData() {
		return data;
	}

}
