package smartable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Smartable smart = new SmartOperations();

        // removeInRange
        List<Integer> list = Arrays.asList(0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10, 0, 12, 0, 14, 0, 16);
        List<Integer> result = smart.removeInRange(list, 0, 5, 13);
        System.out.println("removeInRange: " + result);

        // isUnique
        Map<String, String> map = new HashMap<>();
        map.put("Вася", "Иванов");
        map.put("Петр", "Петров");
        map.put("Виктор", "Сидоров");
        System.out.println("isUnique: " + smart.isUnique(map));

        // intersect
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Janet", 87);
        map1.put("Logan", 62);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Logan", 62);
        map2.put("Kim", 52);
        System.out.println("intersect: " + smart.intersect(map1, map2));

        // countCommon
        List<Integer> list1 = Arrays.asList(3, 7, 3, -1, 2, 3, 7, 2, 15, 15);
        List<Integer> list2 = Arrays.asList(-5, 15, 2, -1, 7, 15, 36);
        System.out.println("countCommon: " + smart.countCommon(list1, list2));

        // removeEvenLength
        Set<String> set = new HashSet<>(Arrays.asList("foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude"));
        System.out.println("removeEvenLength: " + smart.removeEvenLength(set));

        // maxOccurrences
        List<Integer> occurrencesList = Arrays.asList(4, 7, 4, -1, 2, 4, 7, 2, 15, 15);
        System.out.println("maxOccurrences: " + smart.maxOccurrences(occurrencesList));
    }
}
