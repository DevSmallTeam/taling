package com.uxunchina.taling.study.day1;

public class SuperExtendExample extends SuperExample{
    private int z;

    public SuperExtendExample(int x, int y,int z) {
        super(x, y);
        this.z = z;
    }


    @Override
    public void func(){
        super.func();

        System.out.println("SuperExtendExample.func(),and z = "+this.z);
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "SuperExtendExample{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
