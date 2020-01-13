package com.hyb.algorithm.priorityqueue.lock;


import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * MCS 自旋锁
 * MCS 的名称来自其发明人的名字：John Mellor-Crummey和Michael Scott。
 * MCS 的实现是基于链表的，每个申请锁的线程都是链表上的一个节点，
 * 这些线程会一直轮询自己的本地变量，来知道它自己是否获得了锁。
 * 已经获得了锁的线程在释放锁的时候，负责通知其它线程，这样 CPU 之间缓存的同步操作就减少了很多，
 * 仅在线程通知另外一个线程的时候发生，降低了系统总线和内存的开销。实现如下所示：
 *
 * 作者：beanlam
 * 链接：https://www.jianshu.com/p/0f6d3530d46b
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MCSLock {

    public static class MCSNode{
        volatile  MCSNode next;
        volatile boolean isWaiting=true; //默认是在等待锁
    }

    volatile  MCSNode queue; //指向最后一个申请锁的MCSNode;

    private static final AtomicReferenceFieldUpdater<MCSLock,MSCNode>   UPDATER= AtomicReferenceFieldUpdater.newUpdater(MCSLock.class
    ,MCSNode.class,"queue");

    public void lock(MCSNode currentThread){
        MCSNode predecessor=UPDATER.getAndSet(this,currentThread);//step 1

    }
}


//public class MCSLock {
//    public static class MCSNode {
//        volatile MCSNode next;
//        volatile boolean isWaiting = true; // 默认是在等待锁
//    }
//    volatile MCSNode queue;// 指向最后一个申请锁的MCSNode
//    private static final AtomicReferenceFieldUpdater<MCSLock, MCSNode> UPDATER = AtomicReferenceFieldUpdater
//            .newUpdater(MCSLock.class, MCSNode.class, "queue");
//
//    public void lock(MCSNode currentThread) {
//        MCSNode predecessor = UPDATER.getAndSet(this, currentThread);// step 1
//        if (predecessor != null) {
//            predecessor.next = currentThread;// step 2
//            while (currentThread.isWaiting) {// step 3
//            }
//        } else { // 只有一个线程在使用锁，没有前驱来通知它，所以得自己标记自己已获得锁
//            currentThread.isWaiting = false;
//        }
//    }
//
//    public void unlock(MCSNode currentThread) {
//        if (currentThread.isWaiting) {// 锁拥有者进行释放锁才有意义
//            return;
//        }
//
//        if (currentThread.next == null) {// 检查是否有人排在自己后面
//            if (UPDATER.compareAndSet(this, currentThread, null)) {// step 4
//                // compareAndSet返回true表示确实没有人排在自己后面
//                return;
//            } else {
//                // 突然有人排在自己后面了，可能还不知道是谁，下面是等待后续者
//                // 这里之所以要忙等是因为：step 1执行完后，step 2可能还没执行完
//                while (currentThread.next == null) { // step 5
//                }
//            }
//        }
//        currentThread.next.isWaiting = false;
//        currentThread.next = null;// for GC
//    }
//}