package ru.job4j.kiss;

import java.util.*;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return find(value, comparator, true);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return find(value, comparator, false);
    }

    private <T> T find(List<T> value, Comparator<T> comparator, Boolean mask) {
        Iterator<T> it = value.iterator();
        T previous = it.next();
        while (it.hasNext()) {
            T next = it.next();
            if ((comparator.compare(next, previous) > 0) == mask) {
                previous = next;
            }
        }
        return previous;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 3, 4, 5, 5, 1, 8);
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = (a, b) -> {
            if (a > b) {
                return 1;
            }
            if (a < b) {
                return -1;
            }
            return 0;
        };
        System.out.println("max: " + maxMin.max(list, comparator));
        System.out.println("mix: " + maxMin.min(list, comparator));
    }
}
