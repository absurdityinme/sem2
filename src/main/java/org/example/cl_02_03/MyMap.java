package org.example.cl_02_03;

import com.sun.source.tree.ReturnTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Set;

public class MyMap<K, V> implements MapInt<K, V> {
    List<K> keys;
    List<V> values;
    MyMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    public boolean containsKey(K key) {
        return keys.contains(key);
    }
    public Collection<V> values() {
        return values;
    }
    public Set<K> keySet() {
        return (Set<K>) values;
    }
    public V remove(K key) {
        V v = values.remove(keys.indexOf(key));
        keys.remove(key);
        return v;
    }
    public V put(K key, V value) {
        V v = null;
        if (keys != null && keys.contains(key)) {
            v = values.get(keys.indexOf(key));
            values.set(keys.indexOf(key), value);
        }
        else if (key != null && value != null) {
            keys.add(key);
            values.add(value);
        }
        return v;
    }
    public V get(K key) {
        return values.get(keys.indexOf(key));
    }
}