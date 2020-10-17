package com.example.springboot.springbootdemo.test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 屈志林
 * @create 2020/10/17
 */
public class CustomClassLoader extends ClassLoader {
    public static void main(String[] args) {

        try {
            Object hello = new CustomClassLoader().findClass("Hello").newInstance();
            Method helloMethod = hello.getClass().getDeclaredMethod("hello");
            helloMethod.setAccessible(true);
            helloMethod.invoke(hello);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        InputStream in = null;
        try {
            in = new FileInputStream("D:\\work\\JAVA-000\\Week_01\\作业2\\Hello.xlass");
            byte[] bytes = toByte(in);
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255-bytes[i]);
            }
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return super.findClass(name);
    }

    private byte[] toByte(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }
}
