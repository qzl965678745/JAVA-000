学习笔记:
### 字节码技术：
1. 编译java文件      javac Hello.java  生成Hello.class文件
2. 查看字节码        javap -c Hello.class
3. 查看更多字节码信息 javap -c -verbose Hello.class
### 类加载器
1. 类的生命周期：加载----验证----准备----解析----初始化----使用----卸载
2. 类的加载时机
3. 可能会加载，不会初始化的情况
4. 三类加载器（启动，扩展，应用类加载器），加载器特点：双亲委派，负责依赖，缓存加载
### 内存模型
作业3已画出
### 启动参数
-Xmx1024m: 最大堆内存1024m
-Xms1024m: 最小堆内存1024m
-Xmn512m: 年轻代512m
-Xss1m: 栈1m
### jdk内置命令行
- jps/jinfo  查看java进程   
-     jps -lmv 命令可以看到更多信息   jinfo [pid]  当前java进程更多信息
- jstat 查看jvm内部gc相关信息 
-     jstat -gc [pid] 1000 1000  第一个1000表示1s(间隔)，第二个表示执行1000次（次数）
      jstat -gcutil [p id] 1000 1000
- jmap 查看heap或类占用空间统计
-      jmap -histo [pid]     [B 字节数组, [I int数组, [L 类对象
-      jmap -heap [pid]
- jstack 查看线程信息
-      jstack -l [pid]    kill -3 [pid] 
- jcmd 执行jvm相关分析命令（整合命令）
-      jcmd [pid] help (当前进程可以操作那些指令) jcmd [pid] VM.info 等等。。。
- jrunscript/jjs 执行js命令  了解
### 内置图形化工具
- jconsole
- jvisualvm
- idea插件VisualGC
- jmc
### GC原理
引用计数：使用了+1，释放-1.缺点：可能导致循环依赖，计数永不为0，造成内存泄漏，内存溢出等问题；
引用跟踪：从根节点出发，标记依赖对象，由于循环的对象在外部不被依赖，可解决循环依赖问题
标记清除算法
标记+清除+压缩整理
可作为GC Roots对象：1.当前正在执行的方法里的局部变量和输入参数。2.活动线程。3.所有类的静态字段。4.JNI引用
### 常用GC组合
1. Serial + Serial Old 实现单线程的低延迟垃圾回收机制
2. ParNew + CMS 实现多线程的低延迟垃圾回收机制
3. Parallel Scavenge + Parallel Scavenge Old 实现多线程的高吞吐量垃圾回收机制
### 如何选择GC
1. 考虑吞吐量优先，用Parallel GC
2. 考虑低延迟优先，用 CMS
3. 系统堆内存较大，GC时间可控，用G1
4. 内存4G以上，用G1性价比高







摘抄网上：
- -XX:CICompilerCount=3                             最大并行编译数,如果设置大于1，虽然编译速度会提高，但是同样影响系统稳定性，会增加JVM崩溃的可能
- -XX:InitialHeapSize=100M                          初始化堆大小 简写-Xms100M
- -XX:MaxHeapSize=100M                           最大堆大小 简写-Xm x 100M
- -XX:NewSize=20M                                     设置年轻代的大小
- -XX:MaxNewSize=50M                              年轻代最大大小
- -XX:OldSize=50M                                       设置老年代大小
- -XX:MetaspaceSize=50M                          设置方法区大小
- -XX:MaxMetaspaceSize=50M                   方法区最大大小
- -XX:+UseParallelGC                                  使用UseParallelGC 新生代，吞吐量优先
- -XX:+UseParallelOldGC                             使用UseParallelOldGC 老年代，吞吐量优先
- -XX:+UseConcMarkSweepGC                   使用CMS 老年代，停顿时间优先
- -XX:+UseG1GC                                          使用G1GC 新生代，老年代，停顿时间优先
- -XX:NewRatio                                             新老生代的比值,比如-XX:Ratio=4，则表示新生代:老年代=1:4，也就是新生代占整个堆内存的1/5
- -XX:SurvivorRatio                                       两个S区和Eden区的比值,比如-XX:SurvivorRatio=8，也就是(S0+S1):Eden=2:8，也就是一个S占整个新生代的1/10
- -XX:+HeapDumpOnOutOfMemoryError      启动堆内存溢出打印当JVM堆内存发生溢出时，也就是OOM，自动生成dump文件
- -XX:HeapDumpPath=heap.hprof                指定堆内存溢出打印目录 表示在当前目录生成一个heap.hprof文件
- XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -Xloggc:$CATALINA_HOME/logs/gc.log   ：打印出GC日志 可以使用不同的垃圾收集器，对比查看GC情况
- -Xss128k                                                    设置每个线程的堆栈大小 经验值是3000-5000最佳
- -XX:MaxTenuringThreshold=6                   提升年老代的最大临界值 默认值为 15
- -XX:InitiatingHeapOccupancyPercent       启动并发GC周期时堆内存使用占比G1之类的垃圾收集器用它来触发并发GC周期,基于整个堆的使用率,而不只是某一代内存的使用比. 值为 0 则表示”一直执行GC循环”. 默认值为 45.
- -XX:G1HeapWastePercent                       允许的浪费堆空间的占比默认是10%，如果并发标记可回收的空间小于10%,则不会触发MixedGC。
- -XX:MaxGCPauseMillis=200ms                G1最大停顿时间暂停时间不能太小，太小的话就会导致出现G1跟不上垃圾产生的速度。最终退化成Full GC。所以对这个参数的调优是一个持续的过程，逐步调整到最佳状态。
- -XX:ConcGCThreads=n                            并发垃圾收集器使用的线程数量 默认值随JVM运行的平台不同而不同
- -XX:G1MixedGCLiveThresholdPercent=65   混合垃圾回收周期中要包括的旧区域设置占用率阈值  默认占用率为 65%
- -XX:G1MixedGCCountTarget=8                设置标记周期完成后，对存活数据上限为 G1MixedGCLIveThresholdPercent 的旧区域执行混合垃圾回收的目标次数默认8次混合垃圾回收，混合回收的目标是要控制在此目标次数以内
- -XX:G1OldCSetRegionThresholdPercent=1   描述Mixed GC时，Old Region被加入到CSet中默认情况下，G1只把10%的Old Region加入到CSet中
