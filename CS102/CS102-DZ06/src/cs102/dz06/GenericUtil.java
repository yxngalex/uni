package cs102.dz06;

import java.util.*;

public class GenericUtil<T> {

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) < 0) {
                    T tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }
        System.out.println(list);
    }

    public static <T> T[] nizovi(T[] a, T[] b, int index) {
        b = Arrays.copyOfRange(a, index, a.length);
        return b;
    }
}
