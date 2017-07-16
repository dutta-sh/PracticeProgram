package concurrency;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Shouvik on 7/3/2017.
 */
public class ConcurrentHashMapExample {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("A", "a");
        map.put("B", "b");
        map.put("C", "c");

        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            map.put("X", "x");
        }

        ConcurrentHashMap<String,String> premiumPhone = new ConcurrentHashMap<String,String>();
        premiumPhone.put("Apple", "iPhone6");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S6");

        Iterator iterator = premiumPhone.keySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony1", "Xperia Z");
        }
    }
}
