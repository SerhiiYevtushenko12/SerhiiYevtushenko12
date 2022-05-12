package Lesson2;

import java.util.*;

public class main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<String, Integer> my = new HashMap<>();

        for (int i = 0; i < 20; i++) {
            my.put("" + i, i);
            list.add(i);
            set.add(i);

            my.put("i", i);
            list.add(i);
            set.add(i);
        }


        Iterator<Map.Entry<String, Integer>> iterator = my.entrySet().iterator();
        Iterator<Integer> iter = list.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }

        while (iter.hasNext()) {
            System.out.print(iter.next() + ", ");
        }

        printCollection(iter);
        printCollection(iterator);
    }

    public static void printCollection(Iterator iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println(" ");
    }
}
