package com.uxunchina.taling.common.someAlgorithmProblem;

/**
 * 打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。例如：
 *         153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
 */
public class P2_FindDaffodilNumber {

    public static void main(String[] args) {
        find();
    }

    public static void find(){
        for (int i=100;i<1000;i++){
            int hundred = i/100%10;
            int ten = i/10%10;
            int bit = i%10;
            if(i == (Math.pow(hundred,3) + Math.pow(ten,3) + Math.pow(bit,3))){
                System.out.println("百位：" + hundred+"，十位："+ ten + ",个位："+ bit);
                System.out.println(i);
            }
        }
    }

}
