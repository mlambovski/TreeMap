package lab8zad3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test {

    public static <T> Set<T> addAll(Set<T> s, Collection<? extends T> c) {
        Iterator<? extends T> iter = c.iterator();
        while (iter.hasNext()) {
            s.add(iter.next());
        }
        return s;
    }

    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("San Francisco", "Forty-niners");
        map.put("Chicago", "Bears");
        map.put("Denver", "Broncos");
        map.put("Seattle", "Seahawks");
        map.put("Miami", "Dolphins");
        map.put("Detroit", "Lions");
        System.out.println(map.toString());
        System.out.println("Map size: " + map.size());
        System.out.println("Team in Chicago: " + map.get("Chicago"));
        map.replace("San Francisco", "Niners");
        System.out.println("Team in San Francisco: "
                + map.get("San Francisco"));
        System.out.println("San Diego has a team?: "
                + map.containsKey("San Diego"));
        map.remove("Denver");
        System.out.println(map.toString());
        map.put("Dallas", "Cowboys");
        System.out.println(map.toString());
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();
            String team = (String) entry.getKey();
            if (team.charAt(0) >= 'M' && team.charAt(0) <= 'Z') {
                iterator.remove();
            }
        }
        System.out.println(map.toString());

        System.out.println("-------------------------------------------------");
        String strArrA[] = {"dog", "cat", "tiger", "pig"},
                strArrB[] = {"frog", "dog", "monkey", "pig", "snake"};
        TreeSet<String> treeSet = new TreeSet<>();
        Collections.addAll(treeSet, strArrA);
        System.out.println(treeSet);
        ArrayList<String> arrList = new ArrayList<>();
        Collections.addAll(arrList, strArrB);
        System.out.println(arrList);
        TreeSet<String> unionSet = new TreeSet<>(addAll(treeSet, arrList));
        System.out.println(unionSet);
    }
}
