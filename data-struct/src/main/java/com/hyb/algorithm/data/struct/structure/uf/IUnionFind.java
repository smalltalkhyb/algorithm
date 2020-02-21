package com.hyb.algorithm.data.struct.structure.uf;

public interface IUnionFind {
    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
