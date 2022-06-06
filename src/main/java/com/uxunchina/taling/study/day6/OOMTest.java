package com.uxunchina.taling.study.day6;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * OOM test
 *-XX:MaxMetaspaceSize=10m -XX:MetaspaceSize=10m -XX:-UseCompressedClassPointers
 * @author chenfeng
 * @date 2022/06/06 17:08
 **/
public class OOMTest extends ClassLoader {
    public static void main(String[] args) {
        int j = 0;
        try {
            OOMTest test = new OOMTest();
            for (int i = 0; i < 10000; i++) {
                //创建ClassWriter对象，用于生成类的二进制字节码
                ClassWriter classWriter = new ClassWriter( 0 );
                //指明版本号，修饰符，类名，包名，父类，接口
                classWriter.visit( Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null );
                //返回byte[]
                byte[] code = classWriter.toByteArray();
                test.defineClass( "Class" + i, code, 0, code.length );
                j++;
            }
        } finally {
            System.out.println( j );
        }
    }
}
