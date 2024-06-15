package com.tegareyn.algorithm.test;

/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @see BaseDataTypeTest
 * @since 2024/1/4 10:26
 **/
public class BaseDataTypeTest {

    public static void main(String[] args) {

    }

    public static void typeTurnTest() {
        // += 操作符会进行隐式自动类型转换,此处a+=b隐式的将加操作的结果类型强制转换为持有结果的类型
        // 而a=a+b则不会自动进行类型转换.
        byte a = 127;
        byte b = 127;
        //b = a + b; // 报编译错误:cannot convert from int to byte
        b += a;

        short s1= 1;
        // s1 = s1 + 1;// short类型在进行运算时会自动提升为int类型,也就是说 s1+1 的运算结果是int类型,而s1是short类型,此时编译器会报错
        // 正确写法
        s1 += 1;
    }

    public static void floatTest() {
        System.out.println(3*0.3);//0.8999999999999999
        System.out.println(3*0.1);//0.30000000000000004
        System.out.println(1*0.3);//0.3
        System.out.println(1*0.3 == 0.3);//true
        System.out.println(3*0.1 == 0.3);//false,因为有些浮点数不能完全精确的表示出来
    }
}
