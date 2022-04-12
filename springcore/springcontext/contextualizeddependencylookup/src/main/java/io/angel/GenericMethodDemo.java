package io.angel;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import static java.lang.System.out;

class Pair<K, V extends Number> implements Comparable<Pair<K, V>> {
    private K key;
    private V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public int compareTo(Pair<K, V> o) {
        if(this.value.intValue() < o.value.intValue())
            return -1;
        else if (this.value == o.value)
            return 0;
        else
            return 1;
    }
}

public class GenericMethodDemo {
    private static <K extends Number, V extends Number> void print(List<Pair<K,V>> list) {
        for(Pair<K, V> p : list) {
            out.println(p);
        }
    }

    private <K extends Number, V extends Number> void prt(List<Pair<K, V>> list) {
        for(Pair<K, V> p : list) {
            out.println(p);
        }
    }
    public static void main(String[] args) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        pairs.add(new Pair<Integer, Integer>(1, 5));
        pairs.add(new Pair<Integer, Integer>(2, 1));
        pairs.add(new Pair<Integer, Integer>(3, 7));
        pairs.add(new Pair<Integer, Integer>(4, 3));
        pairs.add(new Pair<Integer, Integer>(5, 9));

        Collections.sort(pairs);
        // Compiler infers type parameter, so we can avoid them.
        // GenericMethodDemo.<Integer, Integer> print(pairs);
        GenericMethodDemo demo = new GenericMethodDemo();
        demo.<Integer, Integer>prt(pairs);
    }
}