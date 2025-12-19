package com.lanyang.framework.common.context;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lanyang
 * @date 2024/9/5
 * @des
 */
public class TransmittableThreadLocalTest {

    private static final TransmittableThreadLocal<Integer> THREAD_LOCAL = new TransmittableThreadLocal<>();

    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
            1,
            60,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10));

    private static final Executor ttlExecutor = TtlExecutors.getTtlExecutor(threadPoolExecutor);

    public static void main(String[] args) {

        THREAD_LOCAL.set(11);
        System.out.println(Thread.currentThread().getName() + ":" + THREAD_LOCAL.get());

        ttlExecutor.execute(()->{
            //输出11
            System.out.println(Thread.currentThread().getName() + ":" + THREAD_LOCAL.get());
            THREAD_LOCAL.set(22);
            //输出22 这里改变了值
            System.out.println(Thread.currentThread().getName() + ":" + THREAD_LOCAL.get());
        });

        ttlExecutor.execute(()->{
            //输出11 这里仍然保持和主线程一致的值
            System.out.println(Thread.currentThread().getName() + ":" + THREAD_LOCAL.get());
        });

        threadPoolExecutor.execute(()->{
            //输出11
            System.out.println(Thread.currentThread().getName() + ":" + THREAD_LOCAL.get());
            THREAD_LOCAL.set(22);
            //输出22
            System.out.println(Thread.currentThread().getName() + ":" + THREAD_LOCAL.get());
        });

        threadPoolExecutor.execute(()->{
            //输出22 这里已经是修改过的值了
            System.out.println(Thread.currentThread().getName() + ":" + THREAD_LOCAL.get());
        });

    }
}
