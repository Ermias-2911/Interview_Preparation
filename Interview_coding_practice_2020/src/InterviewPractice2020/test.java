package InterviewPractice2020;

public class test {
    private static void search(int[][] mat, int n, int x) {

        int i = 0, j = n - 1; // set indexes for top right
        // element

        while (i < n ) {
            System.out.println("n  " + mat[i][j]);
            if (mat[i][j] == x) {
                System.out.print("n Found at " + i + " " + j);

            }

            if(j <= 0){
                i++;
                j=n-1;
            }else {
                j--;
            }
        }

        System.out.print("n Element not found");
        return; // if ( i==n || j== -1 )
    }

    // driver program to test above function
    public static void main(String[] args) {
        int mat[][] = {{10, 2, 7, 40},
                {15, 2, 35, 45},
                {27, 29, 7, 48},
                {32, 3, 3, 5}};

        search(mat, 4, 3);





        String inputStr ="teeter";

        for(char i :inputStr.toCharArray()){
            System.out.println(" inputStr.lastIndexOf(i) : "+inputStr.lastIndexOf(i)  +  "  inputStr.indexOf(i)  "+inputStr.indexOf(i));
            if ( inputStr.indexOf(i) == inputStr.lastIndexOf(i)) {
                System.out.println("First non-repeating character is: "+i);
                break;
            }
        }
    }
}



//package InterviewPractice2020;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//class test {
//
//
//    public static void main(String args[]) throws IOException {
//
//        List<User> list = new ArrayList<>();
//
//        list.add(new User("Ermias", "Tedla", 30, 076657));
//        list.add(new User("Tomas", "Nahom", 66, 567789));
//        list.add(new User("Lidya", "Haile", 24, 67777));
//        list.add(new User("Alex", "Welday", 26, 445555));
//        list.add(new User("Alem", "Senay", 44, 998000));
//
//        list.forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName() + " " + a.getAge() + " " + a.getId()));
//        System.out.println(" ");
//
//        // Join String Elements
//        String lis = list
//                .stream()
//                .map(User::getFirstName)
//                .collect(Collectors.joining(", ", "[", "]"));
//         System.out.println("Joined String elements are: " + lis);
//
//
////        List<User> xx = list.stream().
////                sorted((x, b) -> x.getAge() + b.getAge()).collect(Collectors.toList());
//
//
//    }
//
//
//    public static class User {
//        private String FirstName;
//        private String LastName;
//        private int age;
//        private int id;
//
//        public User(String firstName, String lastName, int age, int id) {
//            FirstName = firstName;
//            LastName = lastName;
//            this.age = age;
//            this.id = id;
//        }
//
//        public String getFirstName() {
//            return FirstName;
//        }
//
//        public void setFirstName(String firstName) {
//            FirstName = firstName;
//        }
//
//        public String getLastName() {
//            return LastName;
//        }
//
//        public void setLastName(String lastName) {
//            LastName = lastName;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        public void setAge(int age) {
//            this.age = age;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//
//    }
//}
