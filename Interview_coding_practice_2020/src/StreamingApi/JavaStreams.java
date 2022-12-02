package StreamingApi;

import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class JavaStreams {
    public static void main(String[] args) throws IOException {
        // 1. Integer Stream
        IntStream
                .range(1, 10)
                .forEach(System.out::print);
        System.out.println();

        // 2. Integer Stream with skip
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(x -> System.out.println(x));
        System.out.println();

        // 3. Integer Stream with sum
        System.out.println(
                IntStream
                        .range(1, 5)
                        .sum());
        System.out.println();

        // 4. Stream.of, sorted and findFirst
        Stream.of("Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        // 5. Stream from Array, sort, filter and print
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
        Arrays.stream(names)    // same as Stream.of(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);

        // 6. average of squares of an int array
        Arrays.stream(new int[]{2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);

        // 7. Stream from List, filter and print
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);

        // 8. Stream rows from text file, sort, filter, and print
        // We’re going to use Files.lines() to create our stream which
        // is going to give us a stream of a string for each line of the file
        Path path = Path.of("/Users/jeremiah-2911/Desktop/Developer Master/Interview-Preparation/Interview_coding_practice_2020/src/StreamingApi/bands.txt");
        Stream<String> bands = Files.lines(path);
        bands.sorted().filter(x -> x.length() > 13).forEach(System.out::println);
        bands.close();

        // 9. Stream rows from text file and save to List
        List<String> bands2 = Files.lines(path) .filter(x -> x.contains("jit")).collect(Collectors.toList());
        bands2.forEach(x -> System.out.println(x));

        // 10. Stream rows from CSV file and count
        Stream<String> rows1 = Files.lines(path);
        int rowCount = (int) rows1.map(x -> x.split(",")).filter(x -> x.length == 3).count();
        System.out.println(rowCount + " rows.");
        rows1.close();

        // 11. Stream rows from CSV file, parse data from rows
        // In this example, we stream rows from a CSV file and we’re going to count the good rows.
        //Suppose we have a file called data.txt with the following contents:
        //A,12,3.7
        //B,17,2.8
        //C,14,1.9
        //D,23,2.7
        //E
        //F,18,3.4
        Path path2 = Path.of("/Users/jeremiah-2911/Desktop/Developer Master/Interview-Preparation/Interview_coding_practice_2020/src/StreamingApi/data.txt");
        Stream<String> rows2 = Files.lines(path2);
        rows2.map(x -> x.split(",")).filter(x -> x.length == 3).filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2]));
        rows2.close();

//##################################### Stream Reuse Solution #######################################
        // W can't reuse sream onece we use terminal operatin
        // To reuse steam agin we use Supplier.get() method of Supplier Functional Interface
        Supplier<Stream<Integer>> numberStream = () -> Stream.of(123, 234, 11, 57, 60, -4);

        List<Integer> evenNumbers = numberStream.get()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());

        List<Integer> oddNumbers = numberStream
                .get().filter(integer -> integer % 2 == 1)
                .collect(Collectors.toList());

        // 12. Stream rows from CSV file, store fields in HashMap
        Stream<String> rows3 = Files.lines(path2);
        Map<String, Integer> map = new HashMap<>();



        map = rows3.map(x -> x.split(",")).filter(x -> x.length == 3).filter(x -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap(x -> x[0],x -> Integer.parseInt(x[1])));
        rows3.close();

        for (String key : map.keySet()) {
            System.out.println(" Stream rows from CSV file, store fields in HashMap :=====> " + key + "  " + map.get(key));
        }

        // 13. Reduction - sum
        double total = Stream.of(7.3, 1.5, 4.8).reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);

        // 14. Reduction - summary statistics
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10).summaryStatistics();
        System.out.println(summary);
    }

}