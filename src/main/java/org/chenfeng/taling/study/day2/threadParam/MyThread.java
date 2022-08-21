package org.chenfeng.taling.study.day2.threadParam;

import java.util.Random;

/**
 * 线程传参--通过回调函数
 */
public class MyThread extends Thread {

    private Work work;

    public MyThread(Work work) {
        this.work = work;
    }

    @Override
    public void run() {
        Data data = new Data();
        int n1 = new Random().nextInt(1000);
        int n2 = new Random().nextInt(2000);
        int n3 = new Random().nextInt(3000);
        work.process(data, n1, n2, n3);
        System.out.println(n1 + "+" + n2 + "+" + n3 + "=" + data.value);

    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread(new Work());
        myThread.start();
    }

}

class Data {
    public int value = 0;
}

class Work {
    public void process(Data data, Integer... numbers) {
        for (int n : numbers) {
            data.value += n;
        }
    }
}
