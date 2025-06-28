import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String, List<String>> helperMap = new HashMap<>();
        List<List<String>> anagrams = new ArrayList<>();
        for(String current : strs) {
            char[] chars = current.toCharArray();
            Arrays.sort(chars);
            String sortedCurrentAsKey = new String(chars);
            List<String> listOfStrings = helperMap.getOrDefault(sortedCurrentAsKey, new ArrayList<>());
            if(listOfStrings.isEmpty()) {
                helperMap.put(sortedCurrentAsKey, listOfStrings);
            }
            listOfStrings.add(current);

        }

        anagrams.addAll(helperMap.values());
    }
}
