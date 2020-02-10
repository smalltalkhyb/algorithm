package com.hyb.algorithm.basic.genericity;

//这个类是个泛型类
public class GenericMethod<T>{
    private T val;

    public GenericMethod(T val){
        this.val=val;
    }

    //虽然在方法中使用了泛型，但是这个并不是一个泛型方法
    //这只是类中的一个普通成员方法，只不过它的返回值是在声明泛型类已经声明过的泛型
    //所以在这个方法中才可以继续使用T 这个泛型
    public T getVal(){
        return val;
    }

    /**
     * 编译器会报错  “cannot reslove symbol E”
     *  因为在类的声明中并未声明泛型E ，所以在使用E做形参和返回值类型时，编译器无法识别
     */
//        public E setVal(E val){
//            this.val=val;
//        }


    /**
     *  真正的泛型方法
     *  首先在public 与返回值之间的<E> 必不可少，这表明这是一个泛型方法，并且声明了一个泛型E
     *  这个E可以出现在这个泛型方法的任意位置
     *  泛型的数量也可以任意多个
     *  如 public <T,K> K showKeyName(Generic<T> container){...}
     *
     *
     */

    public <E> E showValName(GenericMethod<E> container){
        E e=container.getVal();
        return e;
    }



    //这也不是一个泛型方法，这就是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
    public void showValName2(GenericMethod<Number> obj){

    }

    //静态方法不能使用泛型
//    public static T getStaticVal(){
//        return  new GenericMethod<Integer>(222).getVal();
//    }

}