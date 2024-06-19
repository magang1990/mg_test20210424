package com.mg.xunhuan;

/**
 * @author mg
 * @date 2024-03-16
 */
public class BreakTest {
    public static void main(String[] args) {
        for(int j=1;j<=3;j++){
            //打印每一行的星号
            for(int i=1;i<=4;i++){
                if(i>2){
                    break;
                }
                System.out.print("*");
            }

            //换行
            System.out.println();
        }

        System.out.println("-----------------------");
        // 用break作标记跳出指定结构
        a:for(int j=1;j<=3;j++){
            //打印每一行的星号
            for(int i=1;i<=4;i++){
                if(i>2){
                    break a;
                }
                System.out.print("*");
            }

            //换行
            System.out.println();
        }
    }
}
