package com.harvey.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.util.Arrays;

/**
 * 线程信息获取
 *
 * @author harvey
 * @date 2020/12/24
 */
public class ThreadManageInfo{

    public static void main(String[] args) {

        ThreadInfo[] threadInfos = ManagementFactory.getThreadMXBean().dumpAllThreads(false, false);
        Arrays.stream(threadInfos).forEach(threadInfo -> {
            System.out.println("threadId: " + threadInfo.getThreadId());
            System.out.println("threadName: " + threadInfo.getThreadName());
        });
    }

}
