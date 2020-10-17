public class Hello{
    public static void main(String[] args) {
        int i = 10;
        int sum = 0;
        for (int k = 1; k < i; k++) {
            sum += k;
            if(sum == 6){
                System.out.println(k);
                return;
            }
        }
    }

    // 对应字节码
    /*
    Compiled from "Hello.java"
    public class Hello {
        public Hello();
        Code:
                0: aload_0
                1: invokespecial #1                  // Method java/lang/Object."<init>":()V
                4: return

        public static void main(java.lang.String[]);
        Code:
                0: bipush        10
                2: istore_1
                3: iconst_0
                4: istore_2
                5: iconst_1
                6: istore_3
                7: iload_3
                8: iload_1
                9: if_icmpge     36
                12: iload_2
                13: iload_3
                14: iadd
                15: istore_2
                16: iload_2
                17: bipush        6
                19: if_icmpne     30
                22: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
                25: iload_3
                26: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
                29: return
                30: iinc          3, 1
                33: goto          7
                36: return
    }
    */

}