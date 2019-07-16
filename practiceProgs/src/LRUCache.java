import java.time.Instant;
import java.util.*;
import java.util.LinkedList;

public class LRUCache {
    private Map<String, String> map = new HashMap();
    private Queue<String> keys = new LinkedList<>();
    private Repo repo = new Repo();
    private int cacheSize = 5;

    public String get(String key) {
        if(map.containsKey(key)) {
            bringKeyToFront(key);
            return map.get(key);
        }

        String val = repo.get(key); //fetch from repo
        map.put(key, val);  //add to map

        if(keys.size() >= cacheSize) {   //purge oldest key
            String oldest = keys.remove();  //O(1)
            map.remove(oldest);
        }
        keys.add(key);  //add to the end O(1) if doubly linked
        return val;
    }

    private void bringKeyToFront(String key) {
        keys.remove(key);   //O(n)
        keys.add(key);  //O(1) if doubly linked
    }

    class Repo {
        public String get(String key) {
            System.out.println("Getting from repo...");
            return key + " ::: " + Instant.now().toString();
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache();

        for(int i = 1; i <= 5; i++) {
            cache.get(String.valueOf(i));
            cache.keys.forEach(k -> System.out.print(k + " //// " + cache.map.get(k) + " |||| ")); System.out.println();
        }

        cache.get(String.valueOf(2));
        cache.keys.forEach(k -> System.out.print(k + " //// " + cache.map.get(k) + " |||| ")); System.out.println();
        cache.get(String.valueOf(6));
        cache.keys.forEach(k -> System.out.print(k + " //// " + cache.map.get(k) + " |||| ")); System.out.println();
        cache.get(String.valueOf(4));
        cache.keys.forEach(k -> System.out.print(k + " //// " + cache.map.get(k) + " |||| ")); System.out.println();
        cache.get(String.valueOf(1));
        cache.keys.forEach(k -> System.out.print(k + " //// " + cache.map.get(k) + " |||| ")); System.out.println();
    }
}
