package misc;

import java.util.*;

public class UniqueNames {
    // Simple Pair class
    record Pair<K, V> (K key, V value){ }

    public static int countUniquePeople(List<Pair<String, String>> namePairs) {
        if (namePairs == null || namePairs.isEmpty()) {
            return 0;
        }

        HashMap<String, Integer> nameMap = new HashMap<>();
        int personCount = 0;

        for (Pair<String, String> pair : namePairs) {
            String name1 = pair.key();
            String name2 = pair.value();

            if (nameMap.containsKey(name1) && nameMap.containsKey(name2)) { //both are present. so merge them
                if (!nameMap.get(name1).equals(nameMap.get(name2))) {
                    // Merge person IDs
                    int mergeId = nameMap.get(name2);
                    int keepId = nameMap.get(name1);
                    for (String name : nameMap.keySet()) {
                        if (nameMap.get(name) == mergeId) {
                            nameMap.put(name, keepId);
                        }
                    }
                }
            } else if (nameMap.containsKey(name1)) { //only name1 is present. add name2 with same id
                nameMap.put(name2, nameMap.get(name1));
            } else if (nameMap.containsKey(name2)) { //only name2 is present. add name1 with same id
                nameMap.put(name1, nameMap.get(name2));
            } else { //none are present. add both with new id
                personCount++;
                nameMap.put(name1, personCount);
                nameMap.put(name2, personCount);
            }
        }

        System.out.println(nameMap);
        Set<Integer> uniquePersonIds = new HashSet<>(nameMap.values());
        return uniquePersonIds.size();
    }

    public static void main(String[] args) {
        String namePairs1[][] = new String[4][2];
        namePairs1[0] = new String[]{"a", "b"};
        namePairs1[1] = new String[]{"c", "d"};
        namePairs1[2] = new String[]{"c", "a"};
        namePairs1[3] = new String[]{"x", "y"};

        List<Pair<String, String>> namePairs = List.of(
                new Pair<>("Alice", "Bob"), //1
                new Pair<>("Bob", "Charlie"), //1
                new Pair<>("David", "Eve"), //2
                new Pair<>("Eve", "Frank"), //2
                new Pair<>("Greg", "Greg"), //3
                new Pair<>("Alice", "Charlie") //1
        );

        int uniquePeople = countUniquePeople(namePairs);
        System.out.println(uniquePeople); // Output: 3
    }
}

/**
Time Complexity:

Iterating through namePairs:

The for loop iterates through each Pair in the namePairs list. This takes O(N) time, where N is the number of name pairs.
HashMap Operations:

containsKey() and put() operations on a HashMap have an average time complexity of O(1).
Merging Person IDs (Worst Case):

The nested loop for merging person IDs has a worst-case time complexity of O(M), where M is the total number of unique names. In the worst case, every name might be iterated over. However, this worst case is only triggered if many name groups are being merged.
Therefore the merging nested loop inside the main loop, in the worst case, adds a complexity of O(N*M). However, because M is bounded by 2N, we can simplify this to O(N^2) in the absolute worst case.
However, the merging operation is not performed for every pair. In many cases, the names will already be mapped to the same person ID, or they will be new names. If the name pairs are relatively random, and there are not many mergings, the average time complexity will be closer to O(N).
Creating uniquePersonIds:

Creating the HashSet from nameMap.values() takes O(M) time, where M is the number of unique names.
Overall Time Complexity:

The dominant factor in the worst case is the merging loop. Therefore the worst case time complexity is O(N^2).
The average time complexity, assuming a relatively random distribution of name pairs, is closer to O(N).
Space Complexity:

nameMap:

The HashMap nameMap stores a mapping of names to person IDs. In the worst case, it will store all unique names, which is O(M), where M is the number of unique names. Because M is bounded by 2N, this is O(N).
uniquePersonIds:

The HashSet uniquePersonIds stores the unique person IDs. In the worst case, it will store all unique person IDs, which is also O(N).
Pair objects:

The input namePairs list stores N Pair objects. This takes O(N) space.
Overall Space Complexity:

The space complexity is dominated by the nameMap, uniquePersonIds, and the input list, all of which contribute O(N).
Therefore, the overall space complexity is O(N).
Summary:

Time Complexity:
Worst Case: O(N^2)
Average Case: O(N)
Space Complexity: O(N)
Important Note: The time complexity analysis assumes that the HashMap operations (containsKey(), put()) have an average time complexity of O(1). In rare cases, if there are many hash collisions, the time complexity of these operations could degrade to O(N), but this is unlikely in practice.
 */