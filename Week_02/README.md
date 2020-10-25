学习笔记
- 本机内存8g,使用java -Xmx2g -Xms2g -XX:+PrintGCDetails GCLogAnalysis 效率是最高的，最大堆内存为物理内存的1/4
- 使用串行化gc  java -XX:+UseSerialGC  -Xmx512m -Xms512m -XX:+PrintGCDetails GCLogAnalysis
发生12次gc,平均每次耗时33ms
将最大堆内存设置为2g，发生5次gc，每次80ms
- 使用cms    java -XX:+UseConcMarkSweepGC  -Xmx512m -Xms512m -XX:+PrintGCDetails GCLogAnalysis
发生12次gc，每次11-48ms
- 使用ParallelGC   java -XX:+UseParallelGC  -Xmx512m -Xms512m -XX:+PrintGCDetails GCLogAnalysis
发生27次gc，每次9-15ms， 6次full gc，每次50-70ms
- 使用G1GC  java -XX:+UseG1GC  -Xmx512m -Xms512m -XX:+PrintGC GCLogAnalysis
