package com.hyb.algorithm.basic.cl;

public class Finalization {

    private static Finalization finalization;

    @Override
    protected void finalize() {
        System.out.println("Finalized");
        finalization = this;
    }


    public static void main(String[] args) {
        Finalization f = new Finalization();
        System.out.println("first  f=" + f);
        f = null;
        System.gc();

        try {
            Thread.currentThread().sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("second  f=" + f);
        System.out.println(f.finalization);
    }
}
