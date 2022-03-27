package com.uxunchina.taling.study.someAlgorithmProblem;


import java.util.Scanner;

/**
 * P1.有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * 思路解析：
 *  月份       兔子总数
 *   1         1
 *   2         1
 *   3         1+1 = 2
 *   4         1+1+1 = 3
 *   5         1+1+1+1+1 = 5
 *   6         1+1+1+1+1+1+1+1 = 8
 *   ...       ...
 *   n         f(n) = f(n-1)+f(n-2)
 */
public class P1_TestRabbit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input the mouth:");
        int mouth = Integer.parseInt(scanner.nextLine());
        System.out.println("now rabbit num is:"+fun(mouth));
    }

    public static int fun(int mouth){
        if(mouth == 1 || mouth == 2){
            return 1;
        }else{
            return fun(mouth-1) + fun(mouth - 2);
        }
    }
}
