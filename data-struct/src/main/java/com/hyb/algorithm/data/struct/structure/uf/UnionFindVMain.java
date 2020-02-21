package com.hyb.algorithm.data.struct.structure.uf;

import java.util.Random;

public class UnionFindVMain {


    public static  double  test(IUnionFind unionFind,int times){
        long beginTime=System.nanoTime();

        int size=unionFind.getSize();
        Random random=new Random();
        for(int i=0;i<times;i++){
            int a=random.nextInt(size);
            int b=random.nextInt(size);
            unionFind.unionElements(a,b);
        }

        for(int i=0;i<times;i++){
            int a=random.nextInt(size);
            int b=random.nextInt(size);
            unionFind.isConnected(a,b);
        }



        long endTime=System.nanoTime();
        return  (endTime-beginTime)/1000000000.00;
    }

    public static void main(String[] args) {

        int size=100000;

        int times=100000;
//        IUnionFind unionFind1=new UnionFindV1(size);
//        System.out.println("UnionFindV1  spend times="+test(unionFind1,times));
//
//
//        IUnionFind unionFind2=new UnionFindV2(size);
//        System.out.println("unionFind2  spend times="+test(unionFind2,times));


        IUnionFind unionFind3=new UnionFindV3(size);
        System.out.println("unionFind3  spend times="+test(unionFind3,times));

        IUnionFind unionFind4=new UnionFindV4(size);
        System.out.println("unionFind4  spend times="+test(unionFind4,times));

        IUnionFind unionFind5=new UnionFindV5(size);
        System.out.println("unionFind5  spend times="+test(unionFind5,times));

        IUnionFind unionFind6=new UnionFindV6(size);
        System.out.println("unionFind6  spend times="+test(unionFind6,times));
    }
}
