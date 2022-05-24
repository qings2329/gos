package com.test.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class CanReliveObj {

    public static CanReliveObj obj;

    public static void main(String[] args) throws InterruptedException {

//        CanReliveObj canReliveObj = new CanReliveObj();
//        System.out.println("原始 canReliveObj 的哈希值 " + canReliveObj.hashCode() + " , toString: " + canReliveObj);

        // 将CanReliveObj对象与GCRoot连接
        obj = new CanReliveObj();
        System.out.println("原始 obj 的哈希值 " + obj.hashCode() + " , toString: " + obj);

        ReferenceQueue weakRq = new ReferenceQueue();
        System.out.println("weakRq：" + weakRq.toString());

        WeakReference  weakReference = new WeakReference(obj, weakRq);
        System.out.println("weakReference：" + weakReference);
        System.out.printf("weakReference.isEnqueued: %s , obj: %s \n", weakReference.isEnqueued(), weakReference.get());


        ReferenceQueue phantomRq = new ReferenceQueue();
        PhantomReference phantomReference = new PhantomReference(obj, phantomRq);

        // 将CanReliveObj对象与GCRoot断开连接
        obj = null;
        // 下面的一行代码会导致 finalize() 不被调用, why?  ---- 因为 enqueue()
//        System.out.printf("weakReference.enqueue: %s , obj: %s \n", weakReference.enqueue(), weakReference.get());

        System.out.println("第1次GC");
        System.gc();

        // weakReference.isEnqueued: false , obj: null ; 为什么 weakReference.get() 已经是null？
        System.out.printf("weakReference.isEnqueued: %s , obj: %s \n", weakReference.isEnqueued(), weakReference.get());
//        System.out.println("weakRq.poll: " + weakRq.poll());
//        System.out.println("weakRq.remove: " + weakRq.remove());

        System.out.println("phantomReference.isEnqueued: " + phantomReference.isEnqueued());
//        System.out.println("phantomRq.poll: " + phantomRq.poll());

        System.out.println("等待。。。。。。。。。。。。。。。。。。。。。");
        Thread.sleep(1000);

        System.out.printf("weakReference.isEnqueued: %s , obj: %s \n", weakReference.isEnqueued(), weakReference.get());
//        System.out.println("weakRq.poll: " + weakRq.poll());

        // weakReference 里面的 queue 变了
        System.out.println("weakRq：" + weakRq);

        System.out.println("phantomReference.isEnqueued: " + phantomReference.isEnqueued());
//        System.out.println("phantomRq.poll: " + phantomRq.poll());



        // false。CanReliveObj对象已经复活，不能回收
        System.out.println("obj == null ？" + (obj == null));
        System.out.println("复活 obj 的哈希值 " + obj.hashCode());

        // 将CanReliveObj对象与GCRoot断开连接
        obj = null;
        System.out.println("第2次GC");
        System.gc();

        Thread.sleep(1000);
        // true。finalize方法仅仅会被GC调用一次，不能再复活了
        System.out.println("obj == null ？" + (obj == null));

        // 只有对象被回收，phantomReference才会进入队列
        System.out.printf("weakReference.isEnqueued: %s , obj: %s \n", weakReference.isEnqueued(), weakReference.get());
        System.out.println("phantomReference.isEnqueued: " + phantomReference.isEnqueued());
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize方法被调用");
        super.finalize();
        // 将CanReliveObj对象与GCRoot重新连接，以复活自身对象
        obj = this;
    }

}

