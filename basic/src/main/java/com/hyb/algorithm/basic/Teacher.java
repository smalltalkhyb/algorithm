package com.hyb.algorithm.basic;

public class Teacher {


    public void print(){
        System.out.println("teacher print");
    }

    public static void main(String[] args) {



        //Teacher类的表示方法
        Teacher teacher =new Teacher();


        //Teacher 也是Class类的实例对象，Class类的实例对象有三种表示方法

        //Class t=new Class();


        //任何类都有一个静态的class 属性
        Class  class1=Teacher.class;

        //通过getClass方法
        Class class2=teacher.getClass();

        /*** 官网class1 class2 是Teacher的类类型（class type）
         *
         * Teacher 是Class的类的实例对象
         */

        // classs1 or class2 相等  一个类只可能是Class的一个类实例对象
        System.out.println(class1==class2);


        //第三种表达方式
        Class class3=null;

        try {
             class3=Class.forName("com.hyb.algorithm.basic.Teacher");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(class2==class3);


        //反过来 我们可以通过Class 创建Teacher实例对象  通过class1 class2 class3创建Teacher的实例对象
        try {
            Teacher teacher1=(Teacher)class1.newInstance();
            teacher1.print();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
