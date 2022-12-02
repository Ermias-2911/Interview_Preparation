package InterviewPractice2020.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ReadingFilesUsingJava11And8 {
    public static void main(String []args) throws IOException {


        Path file = Path.of("/Users/jeremiah-2911/sample.txt");

        // The new Java 8 Files.lines is working well in reading small or large text files,
        // returns a Stream (flexible type and support parallel), auto-close the resources, and has a single line of clean code.
        Stream<String> lines = Files.lines(file);


        // With the new method readString() introduced in Java 11, it takes only a single line to read a file’s
        // content into String using the UTF-8 charset.
        // In case of any error during the read operation, this method ensures that the file is properly closed.
        // It throws OutOfMemoryError if the file is extremely large, for example, larger than 2GB.
        String  lString = Files.readString(file);

        // does not preserve order
        lines.forEach(x -> System.out.println("Reading files using Java 8: " + x));
        System.out.println("Reading files usiNG java 11: " + lString);

    }

}
