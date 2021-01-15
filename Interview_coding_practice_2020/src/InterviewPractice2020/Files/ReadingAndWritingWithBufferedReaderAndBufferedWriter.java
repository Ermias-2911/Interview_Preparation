package InterviewPractice2020.Files;
// https://stackabuse.com/reading-and-writing-files-in-java/

import java.io.*;

public class ReadingAndWritingWithBufferedReaderAndBufferedWriter {


	public static void main(String args[]) {


		String directory = System.getProperty("user.home");
		String fileName = "sample.txt";
		String absolutePath = directory + File.separator + fileName;

		// Write the content in file
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))) {
			String fileContent = "This is a sample text./First/Second/Fourth/IP1234/9999";
			// String[]   st = fileContent.split("/");

			bufferedWriter.write(fileContent);
		} catch (IOException e) {
			// Exception handling
		}

		// Read the content from file
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
			String line = bufferedReader.readLine();

			while (line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			// Exception handling
		} catch (IOException e) {
			// Exception handling
		}
	}
}
