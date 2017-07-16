import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Shouvik on 7/5/2017.
 */
public class FailSafeFailFastExample {

    public static void main(String[] args)
    {
        Map<String,String> premiumPhone = new HashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");

        Iterator iterator = premiumPhone.keySet().iterator();

        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }

        for(Map.Entry entry : premiumPhone.entrySet()) {
            System.out.println(entry.getKey() + ":::"  + entry.getValue());
            premiumPhone.put("Sony", "Xperia Z");
        }

        List<String> phones = Arrays.asList("Apple", "Samsung", "Nokia");
        Iterator it = phones.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            phones.add("Microsoft");
        }

        ConcurrentHashMap<String,String> premiumPhone2 = new ConcurrentHashMap<String,String>();
        premiumPhone2.put("Apple", "iPhone");
        premiumPhone2.put("HTC", "HTC one");
        premiumPhone2.put("Samsung","S5");

        Iterator iterator2 = premiumPhone2.keySet().iterator();

        while (iterator2.hasNext())
        {
            System.out.println(premiumPhone2.get(iterator2.next()));
            premiumPhone2.put("Sony", "Xperia Z");
        }

    }

}
