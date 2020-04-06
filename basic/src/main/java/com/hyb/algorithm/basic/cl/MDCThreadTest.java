package com.hyb.algorithm.basic.cl;

import org.slf4j.MDC;


/***
 *
 * https://blog.csdn.net/sunzhenhua0608/article/details/29175283
 */
public class MDCThreadTest  extends Thread {

    private int i;

    public MDCThreadTest(){

    }

    public MDCThreadTest(int i){
        this.i=i;
    }


    public void run(){
        System.out.println(i);

        MDC.put("username",i+"");

        for(int j=0;j<1;j++){
            System.out.println("aaa"+i);

            if(j==10){
                try{
                    this.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

        System.out.println("run:"+i+"   "+MDC.get("username"));
    }

    public static void main(String[] args) {
        MDCThreadTest  mdcThreadTest=new MDCThreadTest(1);
        mdcThreadTest.start();
        MDCThreadTest  mdcThreadTest2=new MDCThreadTest(2);
        mdcThreadTest2.start();
    }

}
