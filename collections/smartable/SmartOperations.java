package smartable;

import java.util.*;

public class SmartOperations implements Smartable {

    @Override
    public List<Integer> removeInRange(List<Integer> list, int element, int start, int end) {
        List<Integer> result = new ArrayList<>(list);
        for (int i = start; i < end; i++) {
            if (result.get(i) == element) {
                result.remove(i);
                i--; // Уменьшаем индекс, так как список сдвинулся
                end--; // Уменьшаем конечный индекс, так как список стал короче
            }
        }
        return result;
    }

    @Override
    public boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<>();
        for (String value : map.values()) {
            if (!values.add(value)) { // Если значение уже было добавлено, оно не уникально
                return false;
            }
        }
        return true;
    }

    @Override
    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey()) && map2.get(entry.getKey()).equals(entry.getValue())) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    @Override
    public int countCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2); // Оставляем только общие элементы
        return set1.size();
    }

    @Override
    public Set<String> removeEvenLength(Set<String> set) {
        Set<String> result = new HashSet<>();
        for (String s : set) {
            if (s.length() % 2 != 0) { // Проверяем длину строки
                result.add(s);
            }
        }
        return result;
    }

    @Override
    public int maxOccurrences(List<Integer> list) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer num : list) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        return Collections.max(frequencyMap.values());
    }
}