package com.jingchenxi.jvm.heap;

/**
 * 1. 设置堆空间大小的参数
 *  -Xms 用来设置堆空间（年轻代+老年代）的初始内存大小
 *    -X 是jvm运行参数
 *    -ms 是memory start
 *  -Xmx 用来设置堆空间（年轻代+老年代）的最大内存大小
 *
 *  2。默认堆空间大小
 *    初始内存大小 ：物理内存大小 / 64
 *    最大内存大小 ：物理内存大小 / 4
 *  3。手动设置：-Xms600m -Xmx600m
 *     开发中建议将初始堆内存大小和最大堆内存大小设置为相同的值，避免频繁扩缩容导致的系统损耗
 *
 *  4。查看设置的参数 ： 方式一 ： jps / jstat -gc pid
 *                    方式二 ： -XX:+PrintGCDetails
 */
public class HeapSpaceInitial {
}
