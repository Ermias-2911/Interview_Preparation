package StreamingApi;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AdvaceStreamApiProblems {
    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(10,28,87,10,20,76,28,80,80,80);
        System.out.println(" integerList :======> " + intList);
        List<String> stringList = Arrays.asList("one", "two", "three", "one", "two", "four", "four");
        System.out.println(" integerList :======> " + stringList);
        System.out.println("  ");

        // ########################################## Stream Problems On Map Collection  ################################
        System.out.println(" ################################# Stream Apis Problems ################################");

        // ----------------------------------------------------------------------
        // Using Collectors.groupingBy and Fillter
        System.out.println("\nCount duplicate elements  ");

        // Convert list into array
        String[] intArray = stringList.toArray(String[]::new);

        Map<String, Long>  duplicateValue = Arrays.stream(intArray)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                        ));
        Map<String, Long> filteredMap = duplicateValue.entrySet().stream().filter(k -> k.getValue() > 1).collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));
        System.out.println(" DuplicateValue with Array :======> "+ filteredMap);
        // ----------------------------------------------------------------------

        // Using Collectors.groupingBy and Fillter
        System.out.println("\nCount duplicate elements  ");

        String str = " A, B, C, D, A, C, E, D";
        // Convert list into array
        List<String> strList =  Arrays.asList(str.split(","));

        Map<String, Long>  strDuplicate = strList.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                ));
        Map<String, Long> strFiltered = strDuplicate.entrySet().stream().filter(k -> k.getValue() > 1).collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));
        System.out.println(" DuplicateValue with List :======> " + strFiltered);
        // ----------------------------------------------------------------------

        // Using Set and Filter
        System.out.println("\nGet duplicate elements");

        Set<Integer> set = new HashSet<>();
        Set<Integer>  dupValue = intList.stream().filter( x -> !set.add(x)).collect(Collectors.toSet());
        System.out.println(" Duplicate Value Using Set :======> " + dupValue);

        // ----------------------------------------------------------------------
        // Using filter and Collections.frequency                                               
        System.out.println("\nGet duplicate elements");
        Set<Integer>  duplValue = intList.stream()
                        .filter(i->Collections.frequency(intList, i) >1)
                                .collect(Collectors.toSet());
        System.out.println(" Duplicate Value Using filter :======> " + duplValue);

        // ----------------------------------------------------------------------
        // Using reduce() method
        System.out.println("\nGet the sum of all integer ");

        Optional<Integer>  sum = intList.stream().reduce((x, y)-> x + y);
        System.out.println(" Sum of intList is :======> " + sum.get());


        // ----------------------------------------------------------------------
        // Using mpatToint(i -> i) and  average(). average() return optional double
        System.out.println("\nGet smu average of intList ");
        OptionalDouble average = intList.stream()
                        .mapToInt(i -> i)
                                .average();
        System.out.println(" Sum of intList are :======> " + average);

        // ----------------------------------------------------------------------
        // Using
        System.out.println("\nGet even number");
        List<Integer> evenNumber = intList.stream()
                .filter(i -> i % 2 == 0)
                        .collect(Collectors.toList());
        System.out.println(" Even numbers are :======> " + evenNumber);

        // ----------------------------------------------------------------------
        // Using map, map, filter
        System.out.println("\nGet number starting with 2 ");
         List<Integer> numStartWith2 = intList.stream()
                 .map(String::valueOf)
                 .filter(i -> i.startsWith("2"))
                 .map(Integer::valueOf)
                 .collect(Collectors.toList());

         System.out.println(" Numbers starting with 2 :======> " + numStartWith2);  
        // ----------------------------------------------------------------------
        // Using max and get()
        System.out.println("\nGet max value ");
        int max = intList.stream().max((i,j) -> i.compareTo(j)).get();
        System.out.println(" Max value using max() & get() :======> " + max);

        // ----------------------------------------------------------------------
        // Using sorted(Collections.reverseOrder())
        System.out.println("\nGet numbers reversely ");

        List<Integer> reverseNumbers = intList.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(" Reverse sorted numbers using sorted() :======> " + reverseNumbers);

        // ----------------------------------------------------------------------
        // Using
        System.out.println("\nGet ignored the first five element ");

        List<Integer> ignoredList = intList.stream()
                .skip(5)
                        .collect(Collectors.toList());
         System.out.println(" ignored number using skip() :======> " + ignoredList);

        // ----------------------------------------------------------------------
        // Using sorted(Collections.reverseOrder()), distinct(), limi(), skip(), findFirst()
        System.out.println("\nGet second highest number ");

        Optional<Integer> secondHighest = intList.stream()
                .sorted(Collections.reverseOrder())
                .distinct()
                .limit(2)
                .skip(1)
                .findFirst();
        System.out.println(" Second highest number using sorted, distnicts, limit, skip, findFirst :======> " + secondHighest.get());

        // Or
        int secHigh =  intList.stream()
                .sorted(Collections.reverseOrder())
                .distinct()// Using
                .limit(2)
                .skip(1)
                .findFirst()
                .get();

        // ----------------------------------------------------------------------
        // Using map()
        System.out.println("\nGet the squared numbers");

        List<Integer> squarMumber =  intList.stream()
                .map(i -> i*i)
                        .collect(Collectors.toList());
        System.out.println(" Squared number using map() :======> " + squarMumber);

        // ----------------------------------------------------------------------
        // Using
        System.out.println("\nGet  ");


        // ----------------------------------------------------------------------
        // Using
        System.out.println("\nGet  ");
    }
}