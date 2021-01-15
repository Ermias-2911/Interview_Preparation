package InterviewPractice2020.Files;
// https://stackabuse.com/reading-and-writing-files-in-java/
import java.io.*;
// Reads character by character
public class ReadingAndWritingWithFileReaderAndFileWriter {
	public static void main(String args[]) {

		String directory = System.getProperty("user.home");
		String fileName = "new.txt";
		String absolutePath = directory + File.separator + fileName;
//
//		// Write the content in file
//		try (
//				FileWriter fileWriter = new FileWriter(absolutePath)) {
//			String fileContent = "This is a sample text./ werqwerqwe / wqelrkj k ";
//			String[]   st = fileContent.split("/");
//			for(int i =0; i < st.length; i++){
//				fileWriter.write( st[i] +"\n ");
//			}
//
//
//			//fileWriter.write(fileContent);
//			fileWriter.close();
//		} catch (
//				IOException e) {
//			// Cxception handling
//		}

		// Read the content from file
		try (FileReader fileReader = new FileReader(absolutePath)) {
			int ch = fileReader.read();
			while (ch != -1) {
				System.out.print((char) ch );
				ch = fileReader.read();
			}
		} catch (FileNotFoundException e) {
			// Exception handling
		} catch (IOException e) {
			// Exception handling
		}
	}
}
