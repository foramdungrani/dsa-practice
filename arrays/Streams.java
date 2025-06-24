import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill", "Bob");

        //filter
        List<String> filteredName = names.stream()
                .filter(name -> name.length() > 3)
                .toList();
        System.out.println(filteredName);

        //map
        List<String> upperCase = names.stream()
                .map(String::toUpperCase) //metheod reference is used. Lambda can be used name -> name.toUpperCase()
                .toList();
        System.out.println(upperCase);

        //filter + map
        List<Integer> length = names.stream()
                .filter(name -> name.startsWith("J"))
                .map(name -> name.length())
                .toList();
        System.out.println(length);

        //collect to set
        List<Integer> numbers = Arrays.asList(1,1,1,2,2,2,3,3,3);
        Set<Integer> unique = numbers.stream().collect(Collectors.toSet());
        System.out.println(unique);

        //collect with joining
        List<String> people = Arrays.asList("Alice", "Bob", "Charlie");
        String joined = people.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Joined names: " + joined);

        //grouping by
        Map<Integer, List<String>> map = people.stream()
                .collect(Collectors.groupingBy(p -> p.length()));
        System.out.println(map);

        //flatmap
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                List.of(5)
        );
        List<Integer> flat = nested.stream().
                flatMap(n -> n.stream())
                .collect(Collectors.toList());
        System.out.println(flat);
    }
}
