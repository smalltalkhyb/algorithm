package com.hyb.algorithm.basic.genericity;




public class GenericNoLimit {


    public static void main(String[] args) {
        GenericExtend<Number> numberGenericExtend = new GenericExtend<>();
        GenericExtend<Integer> integerGenericExtend = new GenericExtend<>();
        integerGenericExtend.add(100);
        integerGenericExtend.add(200);
        //numberGenericExtend.addAll(integerGenericExtend);  //会报错
        numberGenericExtend.addAllExtend(integerGenericExtend); //正确


//        GenericExtend<Integer> integerGenericExtend1 = new GenericExtend<>();
//       //假设下面这行是合法的
//        GenericExtend<Number> numberGenericExtend1 = integerGenericExtend1;
//
//        numberGenericExtend1.add(new Double(12.34));
    }
}
