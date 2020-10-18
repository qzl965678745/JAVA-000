使用命令java -jar -XX:+UseG1GC gateway-server-0.0.1-SNAPSHOT.jar
jps获取进程id
jmap -heap [pid] 获取堆内存信息

Garbage-First (G1) GC with 8 thread(s)   //使用g1收集器

Heap Configuration:
   MinHeapFreeRatio         = 40
   MaxHeapFreeRatio         = 70
   MaxHeapSize              = 2116026368 (2018.0MB)    //最大堆内存大小，物理内存的1/4
   NewSize                  = 1363144 (1.2999954223632812MB)  
   MaxNewSize               = 1268776960 (1210.0MB)   // 新生代最大内存 5%-20% 物理内存
   OldSize                  = 5452592 (5.1999969482421875MB)
   NewRatio                 = 2
   SurvivorRatio            = 8
   MetaspaceSize            = 21807104 (20.796875MB)
   CompressedClassSpaceSize = 1073741824 (1024.0MB)
   MaxMetaspaceSize         = 17592186044415 MB
   G1HeapRegionSize         = 1048576 (1.0MB)   //每一块内存1m

Heap Usage:
G1 Heap:
   regions  = 2018                  //一共2018快内存，每块1m，使用79m，空闲1938m
   capacity = 2116026368 (2018.0MB)
   used     = 83361776 (79.49998474121094MB)
   free     = 2032664592 (1938.500015258789MB)
   3.939543346938104% used           //使用率
G1 Young Generation:
Eden Space:
   regions  = 50
   capacity = 77594624 (74.0MB)
   used     = 52428800 (50.0MB)
   free     = 25165824 (24.0MB)
   67.56756756756756% used
Survivor Space:
   regions  = 6
   capacity = 6291456 (6.0MB)
   used     = 6291456 (6.0MB)
   free     = 0 (0.0MB)
   100.0% used
G1 Old Generation:
   regions  = 24
   capacity = 50331648 (48.0MB)
   used     = 24641520 (23.499984741210938MB)
   free     = 25690128 (24.500015258789062MB)
   48.95830154418945% used

16170 interned Strings occupying 2166344 bytes.
