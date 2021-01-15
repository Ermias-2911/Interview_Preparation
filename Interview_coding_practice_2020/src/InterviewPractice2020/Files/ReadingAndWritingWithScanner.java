package InterviewPractice2020.Files;
// Java Program to illustrate reading from Text File
// using Scanner Class

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadingAndWritingWithScanner {

	public static void main(String[] args) throws Exception {
		String directory = System.getProperty("user.home");
		String fileName = "sample.txt";
		String absolutePath = directory + File.separator + fileName;

		// pass the path to the file as a parameter
		File file = new File(absolutePath);
		Scanner sc = new Scanner(file);

		while (sc.hasNextLine())
			System.out.println(sc.nextLine());
	}
}



/// Reading from text file as string in Java
class ReadTextAsString {

	public static String readFileAsString(String fileName) throws Exception {
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(fileName)));
		return data;
	}

	public static void main(String[] args) throws Exception {
		String directory = System.getProperty("user.home");
		String fileName = "sample.txt";
		String absolutePath = directory + File.separator + fileName;
		String data = readFileAsString(absolutePath);
		System.out.println(data);
	}
}
