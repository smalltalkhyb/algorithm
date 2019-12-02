package com.hyb.algorithm.priorityqueue.javaAgent;

import java.lang.instrument.Instrumentation;


/**
 * https://www.jianshu.com/p/7ea5f5aca75b
 */
public class PreMyProgram {


    /**
     *   该方法在main 方法之前运行，与main 方法运行在同一个jvm中
     *   并被同一个System.ClassLoader装载
     *   被统一的安全策略(security policy)和上下文(context) 管理
     * @param agentOps
     * @param inst
     */
    public static void preMain(String agentOps, Instrumentation inst){

        System.out.println("=== premain方法执行");
        System.out.println(agentOps);
    }


    /**
     * 如果不存在 premain(String agentOps,Instrumentation inst)
     * 则会执行 premain(Stirng agentOps)
     * @param agentOps
     */
    public static  void preMain(String agentOps){

        System.out.println("====premain方法执行2====");
        System.out.println(agentOps);
    }


    public static void main(String[] args) {

    }

}
