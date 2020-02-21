package com.hyb.algorithm.data.struct.structure.uf;

public class UnionFindV1 implements IUnionFind {

    private int[] data;

    public UnionFindV1(int size) {
        data = new int[size];

        // 初始化, 每一个id[i]指向自己, 没有合并的元素
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }
    }

    @Override
    public int getSize() {
        return data.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pid = find(p);
        int qid = find(q);


        //对于循环来说，因为是顺次遍历 内存是连续的 所以jvm 会优化这个过程
        for (int i = 0; i < data.length; i++) {
            if (data[i] == pid) {
                data[i] = qid;
            }
        }
    }

    public int find(int q) {
        if (q < 0 || q > data.length) {
            throw new IllegalArgumentException("q  is Illegal!");
        }

        return data[q];
    }


}
