package com.hyb.algorithm.basic;


/***
 *     javac -d . IOffice.java
 *      javac -d . Word.java
 *       javac -d . Excel.java
 *     javac -d . DynamicLoad.java
 *
 *     java com.hyb.algorithm.basic.DynamicLoad  com.hyb.algorithm.basic.Word
 *
 *     java com.hyb.algorithm.basic.DynamicLoad  com.hyb.algorithm.basic.Excel
 */
public class DynamicLoad {

    public static void main(String[] args) {

        String cmd=args[0];


        IOffice office= null;
        try {
            //动态加载类  在类运行时加载
            office = (IOffice)Class.forName(cmd).newInstance();
            office.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
