package mavenassignment;

import java.io.*;
import java.util.*;
import com.opencsv.*;

public class FileTask extends TimerTask {

	protected List<Tshirts> list = new ArrayList<Tshirts>();
	private List<String> filenames = new ArrayList<String>();
	final String folderPath = "C:\\Users\\anirudhdabral\\eclipse-workspace\\mavenassignment\\csv files";

	private void fetch(String file) {
		String path = folderPath + "\\" + file;
		try {
			CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
			FileReader filereader = new FileReader(path);
			CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).withSkipLines(1).build();
			List<String[]> allData = csvReader.readAll();
			for (String[] item : allData) {
				list.add(new Tshirts(item[0], item[1], item[2], item[3], item[4], Double.parseDouble(item[5]),
						Double.parseDouble(item[6]), item[7]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		File folder = new File(folderPath);
		for (File fileEntry : folder.listFiles()) {
			if (!fileEntry.isDirectory() && fileEntry.getName().endsWith(".csv")
					&& filenames.contains(fileEntry.getName()) == false) {
				filenames.add(fileEntry.getName());
				fetch(fileEntry.getName());
			}
		}
	}

}
