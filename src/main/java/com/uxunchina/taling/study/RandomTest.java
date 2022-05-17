package com.uxunchina.taling.study;

import java.util.Random;

/**
 * random
 *
 * @author chenfeng
 * @date 2022/04/27 11:36
 **/
public class RandomTest {

    public static void main(String[] args) {

        randomString(-229985452);
        System.out.println("------------");
        randomString(-229985452);

    }

    private static void randomString(int i) {
        Random ran = new Random(i);
        System.out.println(ran.nextInt());
        System.out.println(ran.nextInt());
        System.out.println(ran.nextInt());
        System.out.println(ran.nextInt());
        System.out.println(ran.nextInt());
        System.out.println(randomStringHelloWorld(-229985452) + " " + randomStringHelloWorld(-147909649));
    }



    public static String randomStringHelloWorld(int i) {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int k = ran.nextInt(27);
            if (k == 0)
                break;

            sb.append((char) ('`' + k));
        }
        return sb.toString();
    }
}
