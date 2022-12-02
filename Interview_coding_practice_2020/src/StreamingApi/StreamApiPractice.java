package StreamingApi;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiPractice {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(10, 11, 20, 21, 30, 31, 40, 41);
        System.out.println(" integerList :======> " + integerList);

        List<String> stringList = Arrays.asList("Banana Juice", "Orange Juice", "Apple Juice",
                "Strawberry Juice", "B_juice", "B_juice", "A_juice", "O_juice", "O_juice");
        System.out.println(" stringList :======> " + stringList);

        //>>>>>>>>>>>>>>> Predicate, it will return boolean true if x > 20 else false <<<<<<<<<<<<<<<<<
        Predicate<Integer> predicate = x -> (x > 20);

        //>>>>>>>>>>> We can create stream using Stream.of() method. But, the best wey is to call Stream method on collection. <<<<<<
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);


        // ######################## Change List to Stream, filer with predicate, and print  #########################
        //>>>>>>>>>>> Changing integerList to Stream <<<<<<<<<<<<
        Stream<Integer> stream = integerList.stream();

        //>>>>>>>>>>> Filtering stream data with predicate. <<<<<<<<<<<<
        Stream<Integer> filteredData = stream.filter(predicate);

        //>>>>>>>>>>>  To print we have to use collect.() method. <<<<<<<<<<<<<<<
        List<Integer> data = filteredData.collect(Collectors.toList());
        System.out.println("\n filteredData.collect(Collectors.toList()) :======> " + data);

        // >>>>>>>>> To shorten the above code into one line of code <<<<<<<<<<<<
        List<Integer> data_one = integerList.stream().filter(predicate).collect(Collectors.toList());
        System.out.println(" integerList.stream().filter(predicate).collect(Collectors.toList()) :======> " + data_one);

        // >>>>>>>>>> To shorten the predicate into one line of code using Lambda Expression <<<<<<<<<<<
        List<Integer> data_two = integerList.stream().filter((x) -> x > 20).collect(Collectors.toList());
        System.out.println(" integerList.stream().filter((x)-> x > 20).collect(Collectors.toList() :======> " + data_two);

        System.out.println();
        System.out.println("#############################  Terminal Operations  ####################################");

        //############################################# Terminal Operation  ###############################################

        // >>>>>>>>>>>>>>  allMatch() <<<<<<<<<<<<<<<<
        boolean allMatch = stringList.stream().allMatch((s) -> s.contains("Juice"));
        System.out.println("   allMatch((s) -> s.contains(\"Juice\") :======> " + allMatch);

        // >>>>>>>>>>>>>>>>  anyMatch() <<<<<<<<<<<<<<<<<<
        boolean anyMatch = stringList.stream().anyMatch((s) -> s.startsWith("A"));
        System.out.println("   anyMatch((s) -> s.startsWith(\"A\") :======> " + anyMatch);

        // >>>>>>>>>>>>>>>>  noneMatch((x) -> x > 50) <<<<<<<<<<<<<<<<<<
        boolean nonMatch = stringList.stream().noneMatch((s) -> s.contains("Potato"));
        System.out.println("   noneMatch((s) -> s.contains(\"Potato\") :======> " + nonMatch);

        // >>>>>>>>>>>>>>>>  collect() <<<<<<<<<<<<<<<<<<
        // Or using method reference List<String> stringUpperCaseList = stringList.stream().map(String::toUpperCase).collect(Collectors.toList());
        List<String> stringUpperCaseList = stringList.stream().map((s) -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println("   collect(Collectors.toList()) :======> " + stringUpperCaseList);

        // >>>>>>>>>>>>>>>>  count() <<<<<<<<<<<<<<<<<<
        // Or using method reference List<String> stringUpperCaseList = stringList.stream().map(String::toUpperCase)).count();
        long stringUpperCaCount = stringList.stream().map((s) -> s.toUpperCase()).count();
        System.out.println("   count() :======> " + stringUpperCaCount);

        // >>>>>>>>>>>>>>>>  findAny() <<<<<<<<<<<<<<<<<<
        Optional<String> stringListFindAny = stringList.stream().findAny();
        System.out.println("   findAny() :======> " + stringListFindAny);

        // >>>>>>>>>>>>>>>>  findFirst() <<<<<<<<<<<<<<<<<<
        Optional<String> stringListFindFirst = stringList.stream().findFirst();
        System.out.println("   findFirst() :======> " + stringListFindFirst);

        // >>>>>>>>>>>>>>>>  forEach() <<<<<<<<<<<<<<<<<<
        // Or using method reference stringList.stream().forEach(System.out::println );
        stringList.stream().forEach((s) -> System.out.println("     forEach() :======> " + s));

        // >>>>>>>>>>>>>>>>  forEachOrdered() <<<<<<<<<<<<<<<<<<
        // Or using method reference stringList.stream().forEachOrdered(System.out::println );
        stringList.stream().forEachOrdered((s) -> System.out.println("      forEachOrdered() :======> " + s));

        // >>>>>>>>>>>>>>>>  min() <<<<<<<<<<<<<<<<<<
        // Or using method reference Optional<String> stringMin = stringList.stream().min(String::compareTo)
        Optional<String> stringMin = stringList.stream().min((x, y) -> x.compareTo(y));
        System.out.println("   min((x, y) -> x.compareTo(y)) :======> " + stringMin);

        // >>>>>>>>>>>>>>>>  max() <<<<<<<<<<<<<<<<<<
        // Or using method reference Optional<String> stringMin = stringList.stream().max(String::compareTo)
        Optional<String> stringMax = stringList.stream().max((x, y) -> x.compareTo(y));
        System.out.println("   max((x, y) -> x.compareTo(y)) :======> " + stringMax);

        // >>>>>>>>>>>>>>>>  count() <<<<<<<<<<<<<<<<<<
        long countString = stringList.stream().filter(x -> x.startsWith("A")).count();
        System.out.println("   (x -> x.startsWith(\"A\")).count() :======> " + countString);

        // >>>>>>>>>>>>>>>>  reduce() <<<<<<<<<<<<<<<<<<
        String stringReduce = stringList.stream().reduce(" Type of Juice: ", (x, y) -> x + " | " + y);
        System.out.println("   reduce(\"\", (x, y) -> x + y) :======> " + stringReduce);

        // >>>>>>>>>>>>>>>>  toArray() <<<<<<<<<<<<<<<<<<
        String[] sArray = stringList.toArray(s -> new String[s]);
        System.out.println("   toArray() :======> " + Arrays.toString(sArray));

        Object[] stringArray = stringList.stream().toArray();
        System.out.println("   toArray() :======> " + Arrays.toString(stringArray));


        System.out.println();
        System.out.println("#############################  Intermediate Operations  ####################################");
        // ########################################## Intermediate Operation  #########################################

        // >>>>>>>>>>>>>>>>  filter() <<<<<<<<<<<<<<<<<<
        List<String> filteredString = stringList.stream().filter(x -> !x.startsWith("A")).collect(Collectors.toList());
        System.out.println("  filter(x -> !x.startsWith(\"A\") :======> " + filteredString);

        // >>>>>>>>>>>>>>>>  map() <<<<<<<<<<<<<<<<<<
        List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");
        // Or using method reference map(Integer::valueOf)
        List<Integer> stringToInteger = listOfStrings.stream().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
        System.out.println("   map(Integer::valueOf).collect(Collectors.toList() :======> " + stringToInteger);

        // Or using method reference map(String::toLowerCase)
        List<String> lowerCaseString = stringList.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
        System.out.println("   map(s -> s.toLowerCase()).collect(Collectors.toList()) :======> " + lowerCaseString);

        // >>>>>>>>>>>>>>>>  flatMap() <<<<<<<<<<<<<<<<<<
        List<String> stringlistOne = Arrays.asList("Eating", "balance");
        List<String> stringlistTwo = Arrays.asList("diet", "food", "is", "good!");
        List<List<String>> stringlistList = Arrays.asList(stringlistOne, stringlistTwo);

        // Or using method reference flatMap(Collection::stream)
        List<String> flatMapString = stringlistList.stream().flatMap(s -> s.stream()).collect(Collectors.toList());
        System.out.println("   stringlistList.stream().flatMap(s -> s.stream()) :======> " + flatMapString);

        List<String> flatMapStSecondWay = Stream.of(stringlistOne, stringlistTwo).flatMap(s -> s.stream()).collect(Collectors.toList());
        System.out.println("   Stream.of(stringlistOne, stringlistTwo).flatMap(s -> s.stream()) :======> " + flatMapStSecondWay);

        // >>>>>>>>>>>>>>>>  sorted() <<<<<<<<<<<<<<<<<<
        // Or using method reference sorted(String::compareTo) or stream().sorted() will return natural order
        List<String> sortedString = stringList.stream().sorted((s, ss) -> s.compareTo(ss)).collect(Collectors.toList());
        System.out.println("   sorted((s, ss) -> s.compareTo(ss)) :======> " + sortedString);

        // >>>>>>>>>>>>>>>>  distninct() <<<<<<<<<<<<<<<<<<
        List<String> distinctS = stringList.stream().distinct().collect(Collectors.toList());
        System.out.println("   stringList.stream().distinct() :======> " + distinctS);

        // >>>>>>>>>>>>>>>>  limit() <<<<<<<<<<<<<<<<<<
        List<String> limitedS = stringList.stream().limit(3).collect(Collectors.toList());
        System.out.println("   stream().limit(3) :======> " + limitedS);


        // >>>>>>>>>>>>>>>>  skip() <<<<<<<<<<<<<<<<<<
        List<String> skipS = stringList.stream().skip(3).collect(Collectors.toList());
        System.out.println("   stream().skip(3) :======> " + skipS);

        // >>>>>>>>>>>>>>>>  peek() <<<<<<<<<<<<<<<<<<
        stringList.stream().distinct().filter(s -> s.length() < 10)
                .peek(s -> System.out.println("     Peek Filtered value: :======> " + s))
                .map(String::toUpperCase)
                .peek(s -> System.out.println("     Peek Mapped value: :======> " + s))
                .collect(Collectors.toList());


        // >>>>>>>>>>>>>>>>  parallel() and parallelStream() <<<<<<<<<<<<<<<<<<
        long r = stringList.parallelStream().filter(s -> s.contains("J")).count();
        System.out.println("  r: " + r);
        IntStream intSt = IntStream.rangeClosed(1, 10);
        System.out.println(" parallel() Stream " + intSt.parallel().filter(s -> s > 4).count());


        // ########################################## Stream Problems  #########################################
        System.out.println(" ");
        System.out.println("#############################  Stram Problems  ####################################");

        List<Integer> nStream = Arrays.asList(12, 11, 13, 16, 20, 3, -4, 2, 26, 23, 1, 2, 3);


        // Q1 Given a list of integers, find out all the even numbers exist in the list using Stream functions?
        List<Integer> evenNumber = nStream.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println("  ========>>>  evenNumber: " + evenNumber);

        // Q2 Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        List<Integer> numberStartwithOne = nStream.stream().filter(x -> x / 10 == 1).collect(Collectors.toList());
        List<Integer> numberOne = nStream.stream().filter(x -> x == 1).collect(Collectors.toList());
        List<Integer> nubersStaratWithOne = Stream.of(numberStartwithOne, numberOne).flatMap(x -> x.stream()).collect(Collectors.toList());
        System.out.println("  ========>>>  Solution with flatMap() & filter() nubersStaratWithOne&One: " + nubersStaratWithOne);

        //Best Solution
        List<String> nStartwithOne = nStream.stream().map(String::valueOf).filter(s -> s.startsWith("1")).collect(Collectors.toList());
        System.out.println("  ========>>>  Solution with Map() & filter()  nubersStaratWithOne&One with Map: " + nStartwithOne);

        // Q3 How to find duplicate elements in a given integers list in java using Stream functions?
        Set<Integer> duplicateE = nStream.stream().filter(x -> Collections.frequency(nStream, x) > 1).collect(Collectors.toSet());
        System.out.println("========>>>  Solution using  Set filter(x -> Collections.frequency(nStream, x) > 1) duplicateElement: " + duplicateE);

        // Alternative Solution
        Set<Integer> dup = new HashSet<>();
        Set<Integer> dupN = nStream.stream().filter(x -> !dup.add(x)).collect(Collectors.toSet());
        System.out.println("  ========>>>  Solution using Set filter(x -> !dup.add(x)) duplicateElement: " + dupN);

        // Alternative Best Solution
        Set<Integer> duplicatNumber = nStream.stream().filter(x -> nStream.stream().filter(y -> y == x).count() > 1).collect(Collectors.toSet());
        System.out.println("  ========>>>  Solution using Set filter(x -> nStream.stream().filter(y -> y == x).count() > 1) duplicateElement: " + duplicatNumber);

        // Q4 Given the list of integers, find the first element of the list using Stream functions?
        Optional<Integer> findFirst = nStream.stream().findFirst();
        System.out.println("  ========>>>  Solution using findFirst() findFirst: " + findFirst);

        // Q6 Given a list of integers, find the maximum value element present in it using Stream functions?
        Optional<Integer> theMaxNumb = nStream.stream().max((x, y) -> x.compareTo(y));
        System.out.println("  ========>>>  Solution using max((x,y) -> x.compareTo(y)) theMaxNumb: " + theMaxNumb);


        // Q7 Given a String, find the first non-repeated character in it using Stream functions?
        String input = "Java Hungry Blog Alive is Awesome";


       // Q10 Given a list of integers, sort all the values present in it in descending order using Stream functions?
        List<Integer> intReverseR = integerList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println("  ========>>>  Solution using sorted(Collections.reverseOrder()): " + intReverseR);

        // ########################################## Stream Problems On Employee Pojo  ################################
        System.out.println(" ");
        System.out.println("########################## Stream Problems On Employee Pojo  ##############################");

        List<Employee> listOfEmployee = new ArrayList<>();
        listOfEmployee.add(new Employee("firstNameC", "lastNameC", 2600.00, List.of("Project 2", "Project 3"), new Address( "111 1St St", "Oakland", 94444, "CA")));
        listOfEmployee.add(new Employee("firstNameA", "lastNameA", 3300.00, List.of("Project 10", "Project 11"),new Address( "222 2St St", "San Jose", 95777, "CA")));
        listOfEmployee.add(new Employee("firstNameA", "lastNameE", 2700.00, List.of("Project 2", "Project 3"), new Address( "333 3St St", "San Marcos", 97888, "TX")));
        listOfEmployee.add(new Employee("firstNameD", "lastNameD", 1800.00, List.of("Project 10", "Project 11"), new Address( "444 4St St", "San Jose", 95000, "CA")));
        listOfEmployee.add(new Employee("firstNameB", "lastNameB", 2200.00, List.of("Project 1", "Project 2"), new Address( "555 5St St", "San Marcos", 99111, "TX")));

        System.out.println("   >>>>>>>>>>>>>>>>>>>  List of Added Employee ) <<<<<<<<<<<<<<<<<<< ");
        listOfEmployee.stream().forEach(emp -> System.out.println("   >>>>>>>>>>  " + emp));
        System.out.println(" ");


        // filter(), map()
        System.out.println("\nIncrease Employee salary by 10 % who paid > 2300.00");
        List<Employee> mappedList = listOfEmployee.stream()
                                .filter(sal -> sal.getSalary() > 2300.00)
                                .map( nEmp -> new Employee(nEmp.getfName(),
                                nEmp.getlName(),
                         nEmp.getSalary() * 1.10,
                                nEmp.getProjects(),
                                nEmp.getAddresses())).collect(Collectors.toList());
        System.out.println("   **********  Solution using map() ********* ");
        mappedList.forEach(result -> System.out.println("   ====>>> " + result));

        // filter(), map()
        System.out.println("\nFind first Employee who increase his salary by  10% if not return null ");
        Employee firstEmp = mappedList.stream().findFirst().orElse(null);
        System.out.println("   **********  Solution using findFirst() ********* ");
        System.out.println("   ====>>> " + firstEmp);

        // map(), flatMap(), collect(Collectors.joining())
        System.out.println("\nGet each Employee of project as one string");
        String proString = listOfEmployee.stream()
                .map( emp -> emp.getProjects())
                .flatMap(str -> str.stream())
                .collect(Collectors.joining( ", "));
        System.out.println("   **********  Solution using map(), flatMap(), collect(Collectors.joining(\",\")) ********* ");
        System.out.println("   ====>>> " + proString);

        // sorted()
        System.out.println("\nSort Employee by first name ");
        List<Employee> sortedEmp = listOfEmployee.stream()
                .sorted((e1, e2) -> e1.getfName().compareToIgnoreCase(e2.getfName()))
                .collect(Collectors.toList());
        System.out.println("   **********  Solution using sorted() ********* ");
        sortedEmp.forEach(result -> System.out.println("   ====>>> "+result));


        // generate(Math::random), limit()
        System.out.println("\nGenerate 5 random number ");
        Stream.generate(Math::random)
                        .limit(5)
                        .forEach(value -> System.out.println( "   ===> " + value));

        // max()
        System.out.println("\nGet Employee with the max salary ");
       Employee maxSalaries = listOfEmployee.stream()
                       .max(Comparator.comparing(Employee::getSalary))
                       .orElseThrow(NoSuchElementException::new);
        System.out.println("   **********  Solution using max() ********* ");
        System.out.println("   ====>>> " + maxSalaries);

        // reduce()
        System.out.println("\nGet All Employees' of total salary");
        Double totalSalary = listOfEmployee.stream()
                        .map(emp -> emp.getSalary())
                                .reduce(0.0, (s1, s2)-> s1 + s2);
        System.out.println("   **********  Solution using reduce() ********* ");
        System.out.println("   ====>>> " + totalSalary);

        // filter(), map() findFirst()
        System.out.println("\nGet Employee with exact match name \"fNameA\" and return the result as String ");
        Optional<String> filteredNameS = listOfEmployee.stream()
                .filter(emp -> emp.getfName().startsWith("firstNameA"))
                .map(em -> em.toString())
                .findFirst();
        System.out.println("   **********  Solution using filter(), map(), findFirst() ********* ");
        filteredNameS.stream().forEach(result -> System.out.println("   ====>>> "+result));

        // filter(), map(), collect(Collectors.joining( " , "))
       System.out.println("\nGet all Employees with exact match name \"fNameA\" and return the result as a String ");
       String filteredNameSS = listOfEmployee.stream()
               .filter(emp -> emp.getfName().startsWith("firstNameA"))
               .map(emp -> emp.toString())
               .collect(Collectors.joining( " , "));
        System.out.println("   **********  Solution using filter(), map(), collect(Collectors.joining( \" , \"))) ********* ");
        System.out.println("   ====>>> " + filteredNameSS);

        // filter(), map()
        System.out.println("\nGet all Employees' Name whose address is in CA");
        String filteredEmpByAddress = listOfEmployee.stream()
                .filter(emp -> emp.getAddresses().getState().startsWith("CA"))
                .map(name -> name.getfName())
                .collect(Collectors.joining(", "));
        System.out.println("   **********  Solution using filter(), map() ********* ");
        System.out.println("   ====>>> " + filteredEmpByAddress);

        // groupBy()
        System.out.println("\nGet all Employees' Grouped by city");
        Map< Object, List<Employee>> groupByCity = listOfEmployee.stream()
                .collect(Collectors.groupingBy(result -> result.getAddresses().getCity()));
        System.out.println("   **********  Solution using groupBy() ********* ");
        groupByCity.forEach((k,v)-> System.out.println("   City ====>>> " + k + "  |  Employee ====>>> " + v));

        // groupBy()
        System.out.println("\nGet all Employees' Grouped by state and save it into Set");
        Map< Object, Set<Employee>> groupByState = listOfEmployee.stream()
                .collect(Collectors.groupingBy(result -> result.getAddresses().getState(), TreeMap::new, Collectors.toSet()));
        System.out.println("   **********  Solution using groupBy() ********* ");
        groupByState.forEach((k,v)-> System.out.println("   State ====>>> " + k + "  |  Employee ====>>> " + v));


        // ########################################## Stream Problems On Map Collection  ################################
        System.out.println(" ");
        System.out.println("########################## Stream Problems On Map Collection  ##############################");
        Map<String, Integer> budget = new HashMap<>();
        budget.put("Apt rent", 1500); budget.put("Gas", 150);budget.put("Apt insurance fee", 150);
        budget.put("Utility", 250); budget.put("Grocery", 500);

        System.out.println("   >>>>>>>>>>>>>>>>>>>  List of Added Budget to Map) <<<<<<<<<<<<<<<<<<< ");
        budget.forEach((key, vlaue) -> System.out.println("   >>>>>>>>>>  " + "Key: " + key + " Value: " + vlaue));

        //sorted((e1,e2) -> e1.getValue().compareTo(e2.getValue()))
        System.out.println("\nSort budget map by value and convert it to LinkedHashMap ");
        Map<String, Integer> sortedMap = budget
                .entrySet()
                .stream()
                .sorted((e1,e2) -> e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("   **********  Solution using sorted(Comparator.comparing(Map.Entry::getValue)) ********* ");
        System.out.println("   ====>>> " + sortedMap);

        // sorted(Comparator.comparing(Map.Entry::getValue))
        System.out.println("\nSort budget map by value and convert it to LinkedHashMap ");
        Map<String, Integer> sortedMap2 = budget
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("   **********  Solution using sorted(Comparator.comparing(Map.Entry::getValue)) ********* ");
        System.out.println("   ====>>> " + sortedMap2);

        // sorted(Map.Entry.comparingByValue())
        System.out.println("\nSort budget map by value and convert it to LinkedHashMap ");
        Map<String, Integer> sortedMap3 = budget
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("   **********  Solution using method reference sorted(Map.Entry.comparingByValue()) ********* ");
        System.out.println("   ====>>> " + sortedMap3);

        // sorted(Map.Entry.comparingByValue())
        System.out.println("\nSort budget map by value and convert it to LinkedHashMap");
        Map<String, Integer> sortedMap4 = budget
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("   **********  Solution using method reference sorted(Map.Entry.comparingByValue()) ********* ");
        System.out.println("   **********  Solution using method reference collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new)) ********* ");
        System.out.println("   ====>>> " + sortedMap4);

        // sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        System.out.println("\nSort budget map by value reverse order and convert it to LinkedHashMap ");
        Map<String, Integer> sortReverseOrder = budget
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("   **********  Solution using sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) ********* ");
        System.out.println("   ====>>> " + sortReverseOrder);

        // filter(map -> map.getValue() >= 500)
        System.out.println("\nGet budget map value >= 500 ");
        Map<String, Integer> filterMap = budget
                .entrySet()
                .stream()
                .filter(map -> map.getValue() >= 500)
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        System.out.println("   **********  Solution using filter(map -> map.getValue() >= 500) ********* ");
        System.out.println("   ====>>> " + filterMap);

        // filter(map -> map.getValue() >= 500) and filter(map -> map.getValue() >= 500)
        System.out.println("\nGet budget map value >= 500 ");
        Map<String, Integer> filterMapByKeyandValue = budget
                .entrySet()
                .stream()
                .filter(map -> map.getValue() >= 500)
                .filter(map -> map.getKey().startsWith("A"))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        System.out.println("   **********  Solution using filter(map -> map.getValue() >= 500) ********* ");
        System.out.println("   ====>>> " + filterMapByKeyandValue);


        System.out.println("   **********  Solution using filter() ********* ");
        System.out.println("   ====>>> " );
    }
}