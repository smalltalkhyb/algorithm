package com.hyb.algorithm.data.struct.structure.hash;

import java.util.TreeMap;

public class HashTableT<K extends Comparable<K>, V> {


    private final int upperTotal = 1 << 2;
    private final int lowerTotal = 1 << 1;
    private static final int initCapacity = 1 << 4;
    private TreeMap[] hashtable;
    private int M;
    private int size;


    public HashTableT(int msize) {
        this.size = 0;
        this.hashtable = new TreeMap[msize];
        this.M = msize;
        for (int i = 0; i < msize; i++) {
            hashtable[i] = new TreeMap<K, V>();
        }

    }

    public HashTableT() {
        this(initCapacity);
    }

    private int hash(K key) {
        return key.hashCode() & 0x7fffffff % M;
    }

    public void add(K key, V val) {
        int hashCode = hash(key);
        TreeMap<K, V> treeMap = hashtable[hashCode];
        if (treeMap.containsKey(key)) {
            size++;

            if (size > M * upperTotal) {
                resize(2 * M);
            }
        }
        treeMap.put(key, val);
    }

    public V remove(K key) {
        int hashCode = hash(key);
        TreeMap<K, V> treeMap = hashtable[hashCode];
        size--;
        V val = treeMap.remove(key);

        if (size < M * lowerTotal && size > initCapacity) {
            resize(M / 2);
        }
        return val;
    }

    public boolean contains(K key) {
        int hashCode = hash(key);
        TreeMap<K, V> treeMap = hashtable[hashCode];
        return treeMap.containsKey(key);
    }

    public V get(K key) {
        int hashCode = hash(key);
        TreeMap<K, V> treeMap = hashtable[hashCode];
        return treeMap.get(key);
    }


    /**
     *  M  扩容之后 不是素数了， 可以通过 2^M 对应的最大素数  [53,97,193.....]
     * @param newM
     */
    private void resize(int newM) {
        TreeMap<K, V>[] newHashtable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashtable[i] = new TreeMap<>();
        }

        int oldM = M;
        this.M = newM;

        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> treeMap = hashtable[i];
            for (K key : treeMap.keySet()) {
                TreeMap<K, V> newTreeMap = hashtable[hash(key)];
                newTreeMap.put(key, treeMap.get(key));
            }
        }
        this.hashtable = newHashtable;
    }
}
