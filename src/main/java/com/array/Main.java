package com.array;

import com.queue.ArrayQueue;
import com.queue.LoopQueue;
import com.queue.Queue;

import java.util.Random;

/**
 * Created by xufei
 * 2019/4/18
 */
public class Main {

    //测试使用q运行opCount个enqueue和dequeue操作所需要的时间 单位：秒
    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int optCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue,optCount);
        System.out.println("ArrayQueue,time" + time1);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue,optCount);
        System.out.println("LoopQueue,time" + time2);
    }
}
