package com.hyb.algorithm.priorityqueue.lock;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * https://www.jianshu.com/p/0f6d3530d46b
 *
 * 为了解决公平性问题，可以让每个锁拥有一个服务号，表示正在服务的线程，
 * 而每个线程尝试获取锁之前需要先获取一个排队号，然后不断轮询当前锁的服务号是否是自己的服务号，
 * 如果是，则表示获得了锁，否则就继续轮询。下面是一个简单的实现：
 *
 * 作者：beanlam
 * 链接：https://www.jianshu.com/p/0f6d3530d46b
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class TicketLock {

    private AtomicInteger  serviceNum=new AtomicInteger();//服务号
    private AtomicInteger ticketNum=new AtomicInteger(); //排队号


    public int lock(){
        //首先原子性地获得一个排队号
        int myTicketNum=ticketNum.getAndIncrement();
        //只要当前服务号不是自己的就不断轮询
        while (serviceNum.get()!=myTicketNum){

        }
        return myTicketNum;
    }


    public void unlock(int myTicket){

        //只有当前线程拥有者才能释放锁
        int next=myTicket+1;
        serviceNum.compareAndSet(myTicket,next);
    }
}


