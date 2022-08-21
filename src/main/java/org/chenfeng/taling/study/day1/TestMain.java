package org.chenfeng.taling.study.day1;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestMain {

    public static void main(String[] args) {
//        SuperExample superExample = new SuperExtendExample(1,2,3);
//        superExample.func();
//        System.out.println(superExample);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();

        //过去九天
        c.setTime(new Date());
        c.add(Calendar.DATE, - 9);
        Date d = c.getTime();
        String day = format.format(d);
        System.out.println("过去九天："+day);

        //过去一月
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        System.out.println("过去一个月："+mon);

        //过去三个月
        c.setTime(new Date());
        c.add(Calendar.MONTH, -3);
        Date m3 = c.getTime();
        String mon3 = format.format(m3);
        System.out.println("过去三个月："+mon3);

        //过去一年
        c.setTime(new Date());
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND,0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);


        c.add(Calendar.YEAR, -1);
        Date y = c.getTime();
        String year = format.format(y);
        System.out.println("过去一年："+year);

        for(int i = 0, len = 13; i < len; i++) {
            int index = (int) (Math.random() * len);
            System.out.println(index);
        }
    }
}
