package com.hyb.algorithm.basic.cl;

public class LoadDiff {


    public static void main(String[] args) throws ClassNotFoundException {
       // ClassLoader classLoader=Student.class.getClassLoader();

        Class class2=Class.forName("com.hyb.algorithm.basic.cl.Student");

        Class mysqlClass=Class.forName("com.mysql.cj.jdbc.Driver");
    }

}
