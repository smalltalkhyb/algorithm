package com.hyb.algorithm.data.struct.structure.hash;

public class Student {

    private int classRoom;
    private int grade;
    private String name;


    public Student(int classRoom,int grade,String name){
        this.classRoom=classRoom;
        this.grade=grade;
        this.name=name;
    }


    @Override
    public int hashCode(){
        int hash=0;
        int b=31;

        hash=hash*b+classRoom;
        hash=hash*b+grade;
        hash=hash*b+name.toLowerCase().hashCode();  //是否区分大小写

        return  hash;
    }


    @Override
    public boolean equals(Object o){

        //如果地址一样
        if(this==o){
            return true;
        }

        if(o==null){
            return  false;
        }

        if(o.getClass()!=this.getClass()){
            return false;
        }

        Student other=(Student)o;

        return  other.classRoom==this.classRoom&&
                other.grade==this.grade&&
                other.name.toLowerCase().equals(this.name.toLowerCase());

    }

}
