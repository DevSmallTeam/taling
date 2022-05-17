package com.uxunchina.taling.study.day4;

import com.sun.codemodel.internal.writer.ZipCodeWriter;
import sun.misc.Launcher;
import sun.security.ec.SunEC;
import sun.security.util.CurveDB;

import java.net.URL;
import java.security.Provider;

/**
 * classLoad
 *
 * @author chenfeng
 * @date 2022/04/22 10:06
 **/
public class ClassLoadTest {

    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader); //sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取其上层：扩展类加载器
        ClassLoader extClassLoad = systemClassLoader.getParent();
        System.out.println(extClassLoad);//sun.misc.Launcher$ExtClassLoader@579bb367

        //扩展类加载器上层： bootstrap ClassLoad 获取不到的。
        ClassLoader bootstrapClassLoad = extClassLoad.getParent();
        System.out.println(bootstrapClassLoad); //null

        //对于用户自定义类 来说：默认使用系统类加载器加载
        ClassLoader classLoader = ClassLoadTest.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);  //sun.misc.Launcher$ExtClassLoader@579bb367

        //String 类使用引导类加载器进行加载器。 --> java的核心类库都是使用引导类加载器进行加载器。
        ClassLoader parent1 = String.class.getClassLoader();
        System.out.println(parent1); //null
    }

}

class ClassLoadTest1 {
    public static void main(String[] args) {
        System.out.println("----------启动类加载器------------");
        //获取bootstrap class loader 能加载的哪些路径
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL element : urLs) {
            System.out.println(element.toExternalForm());
        }
        //从上面的路径中随意选择一个类，来看看他的类加载器是什么: 引导类加载器
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);

        System.out.println("---------扩展类加载器---------");
        String property = System.getProperty("java.ext.dirs");
        for (String path : property.split(";")) {
            System.out.println(path);
        }

        ClassLoader classLoader1 = SunEC.class.getClassLoader();
        System.out.println(classLoader1); //sun.misc.Launcher$ExtClassLoader@3b95a09c
    }
}
