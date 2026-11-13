package ua.opnu;

import java.util.*;

public class Task {

    // ЗАВДАННЯ 1: removeShorterStrings()
    public static void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String s1 = list.get(i);
            String s2 = list.get(i + 1);
            if (s1.length() < s2.length()) {
                list.remove(i);
            } else if (s2.length() < s1.length()) {
                list.remove(i + 1);
            } else {
                list.remove(i);
            }
        }
    }

    // ЗАВДАННЯ 2: stutter()
    public static void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            String s = list.get(i);
            list.add(i + 1, s);
        }
    }

    // ЗАВДАННЯ 3: switchPairs()
    public static void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    // ЗАВДАННЯ 4: removeDuplicates()
    public static void removeDuplicates(List<String> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
            }
        }
    }

    // ЗАВДАННЯ 5: markLength4()
    public static void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    // ЗАВДАННЯ 6: isPalindrome()
    public static boolean isPalindrome(Queue<Integer> q) {
        if (q == null || q.isEmpty()) return true;
        Deque<Integer> stack = new ArrayDeque<>();
        int size = q.size();

        for (int i = 0; i < size; i++) {
            int n = q.poll();
            stack.push(n);
            q.add(n);
        }

        boolean isPal = true;
        for (int i = 0; i < size; i++) {
            int n = q.poll();
            int s = stack.pop();
            if (n != s) isPal = false;
            q.add(n);
        }
        return isPal;
    }

    // ЗАВДАННЯ 7: reorder()
    public void reorder(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) return;
        Queue<Integer> positives = new LinkedList<>();
        Stack<Integer> negativesStack = new Stack<>();
        
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int n = queue.poll();
            if (n < 0) {
                negativesStack.push(n);
            } else {
                positives.add(n);
            }
        }
        
       
        Queue<Integer> negatives = new LinkedList<>();
        while (!negativesStack.isEmpty()) {
            negatives.add(negativesStack.pop());
        }
        
        while (!negatives.isEmpty()) {
            queue.add(negatives.poll());
        }
        while (!positives.isEmpty()) {
            queue.add(positives.poll());
        }
    }
    
    // ЗАВДАННЯ 8: rearrange()
    public void rearrange(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) return;
        Queue<Integer> evens = new LinkedList<>();
        Queue<Integer> odds = new LinkedList<>();
        
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int n = queue.poll();
            if (n % 2 == 0) {
                evens.add(n);
            } else {
                odds.add(n);
            }
        }
        
        while (!evens.isEmpty()) {
            queue.add(evens.poll());
        }
        while (!odds.isEmpty()) {
            queue.add(odds.poll());
        }
    }

    // ЗАВДАННЯ 9: maxLength()
    public static int maxLength(Set<String> set) {
        if (set == null || set.isEmpty()) return 0;
        int max = 0;
        for (String s : set) {
            if (s.length() > max) max = s.length();
        }
        return max;
    }

    // ЗАВДАННЯ 10: removeEvenLength()
    public static void removeEvenLength(Set<String> set) {
        if (set != null) {
            set.removeIf(s -> s.length() % 2 == 0);
        }
    }

    // ЗАВДАННЯ 11: numInCommon()
    public static int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return set1.size();
    }

    // ЗАВДАННЯ 12: isUnique()
    public static boolean isUnique(Map<String, String> map) {
        if (map == null || map.isEmpty()) return true;
        Collection<String> values = map.values();
        Set<String> uniqueValues = new HashSet<>(values);
        return values.size() == uniqueValues.size();
    }

    // ЗАВДАННЯ 13: intersect()
    public static Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (map2.containsKey(key) && map2.get(key).equals(value)) {
                result.put(key, value);
            }
        }
        return result;
    }

    // ЗАВДАННЯ 14: reverse()
    public static Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    // ЗАВДАННЯ 15: rarest()
    public static int rarest(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("Map is empty");
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int val : map.values()) {
            countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        }

        int minFrequency = Integer.MAX_VALUE;
        int rarestVal = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int val = entry.getKey();
            int freq = entry.getValue();

            if (freq < minFrequency) {
                minFrequency = freq;
                rarestVal = val;
            } else if (freq == minFrequency) {
                if (val < rarestVal) {
                    rarestVal = val;
                }
            }
        }
        return rarestVal;
    }

    // ЗАВДАННЯ 16: maxOccurrences()
    public static int maxOccurrences(List<Integer> list) {
        if (list == null || list.isEmpty()) return 0;

        Map<Integer, Integer> counts = new HashMap<>();
        int max = 0;

        for (int n : list) {
            int count = counts.getOrDefault(n, 0) + 1;
            counts.put(n, count);
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}
