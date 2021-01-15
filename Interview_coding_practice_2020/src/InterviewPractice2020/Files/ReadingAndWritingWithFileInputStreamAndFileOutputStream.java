package InterviewPractice2020.Files;
// https://stackabuse.com/reading-and-writing-files-in-java/
import java.io.*;

public class ReadingAndWritingWithFileInputStreamAndFileOutputStream {
	public static void main(String args[]) {
		String directory = System.getProperty("user.home");
		String fileName = "sample.txt";
		String absolutePath = directory + File.separator + fileName;


        // write the content in file
		try (FileOutputStream fileOutputStream = new FileOutputStream(absolutePath)) {
			String fileContent = "This is a sample text.";
			fileOutputStream.write(fileContent.getBytes());

		} catch (FileNotFoundException e) {
			// exception handling
		} catch (IOException e) {
			// exception handling
		}

        // reading the content of file
		try (FileInputStream fileInputStream = new FileInputStream(absolutePath)) {
			int ch = fileInputStream.read();
			while (ch != -1) {
				System.out.print((char) ch);
				ch = fileInputStream.read();
			}
		} catch (FileNotFoundException e) {
			// exception handling
		} catch (IOException e) {
			// exception handling
		}
	}
}
