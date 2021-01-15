package InterviewPractice2020.Files;

import java.io.File;

public class GetListOfFileNamesFromFolder {
	public static void main(String a[]) {
		File file = new File("/Users/jeremiah-2911");
		File[] files = file.listFiles();
		for (File f : files) {
			System.out.println(f.getName());
		}
	}
}


