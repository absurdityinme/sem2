package org.example.cl_02_03;

import java.util.Collection;
import java.util.Set;

public interface MapInt<K, V> {
    boolean containsKey (K key);
    Collection<V> values();
    Set<K> keySet();
    V remove(K key);
    V put(K key, V value); // return prev value if there had been a key before replacement otherwise null
    V get (K key);
}
